package com.example.smallbirdking.seriestest;

/**
 * Created by smallbirdking on 2015/10/12.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class list extends Activity {
    ListView listView;
    String [] titles={"标题1","标题2","标题3","标题4"};
    String [] texts={"文本内容A","文本内容B","文本内容C","文本内容D"};
    int [] resIds={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("jj", "KKKKK" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);
        this.setTitle("BaseAdapter for ListView");
        listView=(ListView)this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(titles,texts,resIds));
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