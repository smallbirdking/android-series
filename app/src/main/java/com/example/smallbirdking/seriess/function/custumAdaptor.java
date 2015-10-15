package com.example.smallbirdking.seriess.function;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smallbirdking.seriess.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by smallbirdking on 2015/10/13.
 */
public class custumAdaptor extends BaseAdapter{
    private List<response.ResultsEntity> item;
    private Context context ;
    private LayoutInflater inflater ;
    private String url = "https://image.tmdb.org/t/p/w300";
    public custumAdaptor(Context context, List<response.ResultsEntity> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.listview_item, parent, false);
        response.ResultsEntity it = (response.ResultsEntity)getItem(position);
        ImageView imageView = (ImageView)rowview.findViewById(R.id.itemImage);
        TextView itemTitle = (TextView)rowview.findViewById(R.id.itemTitle);
        TextView itemText = (TextView)rowview.findViewById(R.id.itemText);
        String imageURL = url+it.getPoster_path();
        Picasso.with(context).load(imageURL).into(imageView);
        itemTitle.setText(it.getName());
        itemText.setText(it.getOriginal_language());

        return rowview;
    }
}
