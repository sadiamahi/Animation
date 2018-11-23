package com.example.saddi.eventfusionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class AnimationTest extends AppCompatActivity {
    TextView textView;
    Button zoomin, zoomout, blink, fadein, fadeout;
    Animation aZoomIn,aZoomOut,aBlink,aFadeIn,aFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
        textView=findViewById(R.id.textView2);
        zoomin=findViewById(R.id.zoomin);
        zoomout=findViewById(R.id.zoomout);
        blink=findViewById(R.id.blink);
        fadein=findViewById(R.id.fadein);
        fadeout=findViewById(R.id.fadeout);
        aZoomIn=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        aZoomOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        aBlink=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        aFadeIn=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        aFadeOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(aZoomIn);
            }
        });
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(aZoomOut);

            }
        });
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(aBlink);

            }
        });
        fadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(aFadeIn);

            }
        });
        fadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(aFadeOut);

            }
        });

    }
}
