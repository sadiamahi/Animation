package com.example.saddi.eventfusionproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationTest extends AppCompatActivity {
    Button simple,bigText,bigPicture,notificationAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);

        simple=findViewById(R.id.button);
        bigText=findViewById(R.id.button2);
        bigPicture=findViewById(R.id.button3);
        notificationAction=findViewById(R.id.button4);


        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleN();
            }
        });
        bigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigTextN();

            }
        });
        bigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigPictureN();

            }
        });
        notificationAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationActionN();
            }
        });

    }

    private void simpleN() {
        int nId =0;
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon))
                .setContentTitle("Android course")
                .setContentText("brief description of android course")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(nId,builder.build());
    }

    private void bigTextN() {
        int nId = 1;
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.wall)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.wall))
                .setContentTitle("Android course big picture")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("i am text"))
                .setAutoCancel(true);
        Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(nId,builder.build());

    }

    private void bigPictureN() {
        int nId =2;
        Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.icon);
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.wall)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.wall))
                .setContentTitle("Android course big picture")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
                .setAutoCancel(true);
        Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(nId,builder.build());

    }

    private void notificationActionN() {

        int nId =3;
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.wall)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.wall))
                .setContentTitle("Android course big picture")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("click to visit gogle"))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("www.google.com"));
        PendingIntent pendingIntent=PendingIntent.getActivities(this,0,intent,0);
        builder.addAction(R.drawable.icon,"view",pendingIntent);
        Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(nId,builder.build());
    }
}
