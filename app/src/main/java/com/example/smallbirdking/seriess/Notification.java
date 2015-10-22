package com.example.smallbirdking.seriess;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.smallbirdking.seriess.function.BaseActivity;


/**
 * Created by smallbirdking on 2015/10/16.
 */
public class Notification extends BaseActivity implements View.OnClickListener {

    private Button btn_show_intent_act;
    NotificationCompat.Builder mBuilder;
    String title = "";
    int itemId = 0;
    int notifyId = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        btn_show_intent_act = (Button) findViewById(R.id.btn_show_intent_act);
        btn_show_intent_act.setOnClickListener(this);

        initNotify();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onClick(View v) {
        try {
            title = content.Serie_atPlace.get(content.locations[0]).get(0).toString();
            itemId = content.Serie_atPlace_Id.get(content.locations[0]).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.i("Serie_loc", content.Serie_atPlace.toString());
        switch (v.getId()) {
            case R.id.btn_show_intent_act:
                showIntentActivityNotify(itemId);
                break;
            default:
                break;
        }
    }
    public void showIntentActivityNotify(int id){

        mBuilder.setAutoCancel(true)
                .setContentTitle(title)
                .setContentText("click me to see")
                .setTicker("click me to see");

        Intent resultIntent = new Intent(this, Serie.class);
        resultIntent.putExtra(Serie.S_ITEM_ID, String.valueOf((Integer)id));
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        mNotificationManager.notify(notifyId, mBuilder.build());
    }
    private void initNotify(){
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("title")
                .setContentText("content")
                .setContentIntent(getDefalutIntent(android.app.Notification.FLAG_AUTO_CANCEL))
//				.setNumber(number)
                .setTicker("Notification comming")
                .setWhen(System.currentTimeMillis())
                .setPriority(android.app.Notification.PRIORITY_DEFAULT)
//				.setAutoCancel(true)
                .setOngoing(false)//ture，
                .setDefaults(android.app.Notification.DEFAULT_VIBRATE)

                .setSmallIcon(R.drawable.ic_launcher);
    }
}
