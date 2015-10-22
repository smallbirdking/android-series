package com.example.smallbirdking.seriess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallbirdking.seriess.function.response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by smallbirdking on 2015/10/14.
 */
public class Serie extends AppCompatActivity {
    public static final String S_ITEM_ID = "item_id";

    private response.ResultsEntity mItem;

    private GridView gridView1;
    private Button buttonPublish;
    private final int IMAGE_OPEN = 1;
    private String pathImage;
    private Bitmap bmp;
    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;
    Button btnTakePhoto;
    private static final int CAM_REQUEST = 1313;

    private CheckBox c1,c2 ;
    private Button button;
    Bundle arguments = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("serie", "start");

        super.onCreate(savedInstanceState);
        Log.i("argu", "start000");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.
                SOFT_INPUT_ADJUST_PAN);
        //锁定屏幕
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_serie_detail);
        Log.i("argu", "start00");
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        Log.i("argu", "start0");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.i("argu", "start");
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.


            arguments.putString(S_ITEM_ID,
                    getIntent().getStringExtra(S_ITEM_ID));
            Log.i("argu", arguments.getString(S_ITEM_ID));


            if (arguments.containsKey(S_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                mItem = list.responseObj.getResults().get(Integer.valueOf(arguments.getString(S_ITEM_ID)).intValue());
                //Integer.valueOf(getArguments().getLong(ARG_ITEM_ID)).intValue()
                Activity activity = this;
                CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    appBarLayout.setTitle(mItem.getName());
                }


            }
            Log.i("argu", "end");

            if (mItem != null) {
                String imageURL = content.urlImage+mItem.getPoster_path();
                ImageView imageView = (ImageView) this.findViewById(R.id.serie_detail_Image);
                Picasso.with(Serie.this).load(imageURL).into(imageView);
                ((TextView) this.findViewById(R.id.itemTitle_detail)).setText(mItem.getName());
                ((TextView) this.findViewById(R.id.itemText_detail)).setText(mItem.getOriginal_language());
                ((TextView) this.findViewById(R.id.serie_detail)).setText(mItem.getOverview());

                String title_imageURL = content.urlImage+mItem.getBackdrop_path();
                ImageView title_imageView = (ImageView) this.findViewById(R.id.title_image);
                Picasso.with(Serie.this).load(title_imageURL).into(title_imageView);
            }
        }

        Log.i("gallery","Start");
        gridView1 = (GridView) findViewById(R.id.gridView1);


        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gridview_addpic); //加号
        imageItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("itemImage", bmp);
        imageItem.add(map);
        simpleAdapter = new SimpleAdapter(this,
                imageItem, R.layout.griditem_addpic,
                new String[] { "itemImage"}, new int[] { R.id.imageView1});

        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                // TODO Auto-generated method stub
                if (view instanceof ImageView && data instanceof Bitmap) {
                    ImageView i = (ImageView) view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });
        gridView1.setAdapter(simpleAdapter);
        Log.i("gallery", "click");

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (imageItem.size() == 10) {
                    Toast.makeText(Serie.this, "Max number of image is 9", Toast.LENGTH_SHORT).show();
                } else if (position == 0) {
                    Toast.makeText(Serie.this, "add image", Toast.LENGTH_SHORT).show();
                    //choose picture
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, IMAGE_OPEN);
                } else {
                    dialog(position);
                    //Toast.makeText(MainActivity.this, "clicked" + (position + 1) + " th image",
                    //		Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnTakePhoto = (Button) findViewById(R.id.button_photo);

        btnTakePhoto.setOnClickListener(new btnTakePhotoCliker());

        c1 = (CheckBox) findViewById(R.id.CheckBox01);
        c2 = (CheckBox) findViewById(R.id.CheckBox02);
        button = (Button) findViewById(R.id.Button01);

        //注册事件监听

        c1.setOnCheckedChangeListener(new CheckBoxListener());
            //Log.i("kk",content.Choosed_inSeie.get(mItem.getName()).toString());
        if (content.Choosed_inSeie.get(mItem.getName()).get(content.locations[0]).equals(true)) {
            Log.i("location",content.Choosed_inSeie.get(mItem.getName()).get(content.locations[0]).toString());
            c1.setChecked(true);

        }else {
            Log.i("location",content.Choosed_inSeie.get(mItem.getName()).get(content.locations[0]).toString());
            c1.setChecked(false);
        }
        c1.setText("at home");
        c2.setOnCheckedChangeListener(new CheckBoxListener());
        c2.setText("at school");
        button.setOnClickListener(new ButtonClickListener());



        Log.i("gallery", "end");
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            if(isChecked){
                //Toast
                content.Choosed_inSeie.get(mItem.getName()).put(content.locations[0], true);
                Log.i("location", "add");
                content.Serie_atPlace.get(content.locations[0]).add(mItem.getName());
                content.Serie_atPlace_Id.get(content.locations[0]).add(Integer.valueOf(arguments.getString(S_ITEM_ID)).intValue());
                Log.i("Serie_atPlace", content.Serie_atPlace.get(content.locations[0]).toString());
                Log.i("location", content.Serie_atPlace.get(content.locations[0]).get(0).toString());
                Log.i("content.Choosed_inSeie", String.valueOf(content.Choosed_inSeie));
                Toast.makeText(Serie.this, buttonView.getText() + " choosed", Toast.LENGTH_SHORT).show();
            }else{
                content.Choosed_inSeie.get(mItem.getName()).put(content.locations[0],false);
                for (int i = 0; i < content.Serie_atPlace.get(content.locations[0]).size(); i++) {
                    String ls = content.Serie_atPlace.get(content.locations[0]).get(i);
                    if(ls.equals(mItem.getName())) {
                        Log.i("location", "remove"+content.Serie_atPlace.get(content.locations[0]).get(i).toString());
                        content.Serie_atPlace.get(content.locations[0]).remove(i);
                        content.Serie_atPlace_Id.get(content.locations[0]).remove(i);
                    }
                }
                Log.i("Serie_atPlace", content.Serie_atPlace.get(content.locations[0]).toString());
                Toast.makeText(Serie.this, buttonView.getText()+"cancel choose",Toast.LENGTH_SHORT ).show();
            }
        }
    }

    class ButtonClickListener implements View.OnClickListener {
        String buffer = "";
        public void onClick(View v) {
            if(c1.isChecked())
                buffer = buffer+" "+c1.getText();
            if(c2.isChecked())
                buffer = buffer +" "+c2.getText();
            Toast.makeText(Serie.this, buffer+" choosed", Toast.LENGTH_SHORT).show();
            buffer = "";
        }
    }



    class btnTakePhotoCliker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraintent,CAM_REQUEST);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAM_REQUEST){
            Bitmap thumnail = (Bitmap)  data.getExtras().get("data");
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", thumnail);
            imageItem.add(map);
            simpleAdapter = new SimpleAdapter(this,
                    imageItem, R.layout.griditem_addpic,
                    new String[] { "itemImage"}, new int[] { R.id.imageView1});
            simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                @Override
                public boolean setViewValue(View view, Object data,
                                            String textRepresentation) {
                    // TODO Auto-generated method stub
                    if(view instanceof ImageView && data instanceof Bitmap){
                        ImageView i = (ImageView)view;
                        i.setImageBitmap((Bitmap) data);
                        return true;
                    }
                    return false;
                }
            });
            gridView1.setAdapter(simpleAdapter);
            simpleAdapter.notifyDataSetChanged();
        }
        //open picture
        if(resultCode==RESULT_OK && requestCode==IMAGE_OPEN) {
            Uri uri = data.getData();
            if (!TextUtils.isEmpty(uri.getAuthority())) {
                Cursor cursor = getContentResolver().query(
                        uri,
                        new String[] { MediaStore.Images.Media.DATA },
                        null,
                        null,
                        null);
                if (null == cursor) {
                    return;
                }
                cursor.moveToFirst();
                pathImage = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
            }
        }  //end if
    }

    //refresh pqge
    @Override
    protected void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(pathImage)){
            Bitmap addbmp=BitmapFactory.decodeFile(pathImage);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", addbmp);
            imageItem.add(map);
            simpleAdapter = new SimpleAdapter(this,
                    imageItem, R.layout.griditem_addpic,
                    new String[] { "itemImage"}, new int[] { R.id.imageView1});
            simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                @Override
                public boolean setViewValue(View view, Object data,
                                            String textRepresentation) {
                    // TODO Auto-generated method stub
                    if(view instanceof ImageView && data instanceof Bitmap){
                        ImageView i = (ImageView)view;
                        i.setImageBitmap((Bitmap) data);
                        return true;
                    }
                    return false;
                }
            });
            gridView1.setAdapter(simpleAdapter);
            simpleAdapter.notifyDataSetChanged();
            pathImage = null;
        }
    }


    protected void dialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Serie.this);
        builder.setMessage("sure to delete the image？");
        builder.setTitle("Attention");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                imageItem.remove(position);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
