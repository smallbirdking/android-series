package com.example.smallbirdking.seriess;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smallbirdking.seriess.function.response;
import com.squareup.picasso.Picasso;

/**
 * Created by smallbirdking on 2015/10/14.
 */
public class Serie extends AppCompatActivity {
    public static final String S_ITEM_ID = "item_id";
    private response.ResultsEntity mItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("serie", "start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(S_ITEM_ID,
                    getIntent().getStringExtra(S_ITEM_ID));
            Log.i("argu", arguments.getString(S_ITEM_ID));
            /*ItemDetailFragment fragment = new ItemDetailFragment(Serie.this);
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.serie_detail_container, fragment)
                    .commit();*/

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


            if (mItem != null) {
                String imageURL = content.urlImage+mItem.getPoster_path();
                ImageView imageView = (ImageView) this.findViewById(R.id.serie_detail_Image);
                Picasso.with(Serie.this).load(imageURL).into(imageView);
                ((TextView) this.findViewById(R.id.serie_detail)).setText(mItem.getOverview());
            }
        }



    }

}
