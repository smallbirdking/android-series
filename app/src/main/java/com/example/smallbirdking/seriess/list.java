package com.example.smallbirdking.seriess;

/**
 * Created by smallbirdking on 2015/10/12.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smallbirdking.seriess.function.response;
import com.example.smallbirdking.seriess.function.custumAdaptor;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import cz.msebera.android.httpclient.Header;

public class list extends Activity {

    ListView listView;
    static response responseObj;
    custumAdaptor adaptor;
    String url = "http://api.themoviedb.org/3/search/tv?api_key=61f7950a0c9e1089cf27fbcc524ec7db&query=daredevil";
    Gson gson;
    AsyncHttpClient client ;


    /*tmDBAPI tmdb = new tmDBAPI();
    List<serie> series = new ArrayList<serie>();

    String [] titles={"标题1","标题2","标题3","标题4","kk"};

    String [] texts={"文本内容A","文本内容B","文本内容C","文本内容D","jj"};
    int [] resIds={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);
        listView=(ListView)this.findViewById(R.id.MyListView);
        client = new AsyncHttpClient();
        client.get(list.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, response.class);
                adaptor = new custumAdaptor(list.this, responseObj.getResults());
                listView.setAdapter(adaptor);
                for(int i = 0; i < responseObj.getResults().size(); i++) {
                    String name = responseObj.getResults().get(i).getName();
                    content.Choosed_inSeie.put(name, (HashMap) content.Choosable_Place.clone());
                }
                Log.i("content.Choosed_inSeie", String.valueOf(content.Choosed_inSeie));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


        this.setTitle("BaseAdapter for ListView");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("list", "click");
                Intent detailIntent = new Intent(list.this, Serie.class);
                detailIntent.putExtra(Serie.S_ITEM_ID, String.valueOf(id));
                //detailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(detailIntent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        //listView.setAdapter(new ListViewAdapter(titles,texts,resIds));

    }

    public class ListViewAdapter extends BaseAdapter{
        View [] itemViews;

        public ListViewAdapter(String [] itemTitles, String [] itemTexts,
                               int [] itemImageRes){
            itemViews = new View[itemTitles.length];

            for (int i=0; i<itemViews.length; ++i){
                itemViews[i] = makeItemView(itemTitles[i], itemTexts[i],
                        itemImageRes[i]);
            }
        }

        public int getCount()   {
            return itemViews.length;
        }

        public View getItem(int position)   {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String strTitle, String strText, int resId) {
            LayoutInflater inflater = (LayoutInflater)list.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.listview_item, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView)itemView.findViewById(R.id.itemTitle);
            title.setText(strTitle);
            TextView text = (TextView)itemView.findViewById(R.id.itemText);
            text.setText(strText);
            ImageView image = (ImageView)itemView.findViewById(R.id.itemImage);
            image.setImageResource(resId);

            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }
}