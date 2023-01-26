package com.example.playing_with_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FramedAnimationActivity extends AppCompatActivity {

    AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framed_animation);

        // find buttons and set on click listener to start/stop animation
        Button startButton = findViewById(R.id.icecream_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        Button stopButton = findViewById(R.id.icecream_stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    // start animation event handler
    public void startAnimation(){
        ImageView image = findViewById(R.id.icecream_animation_image);

        // get BitmapDrawable resources
        BitmapDrawable frame0 = (BitmapDrawable)getResources().getDrawable(R.drawable.ice_cream_truck_start);
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.ice_cream_truck);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_truck_close);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_truck_closer);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_truck_closest);
        BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_truck_window);
        BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_1);
        BitmapDrawable frame7 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_2);
        BitmapDrawable frame8 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_3);
        BitmapDrawable frame9 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_4);
        BitmapDrawable frame10 = (BitmapDrawable) getResources().getDrawable(R.drawable.ice_cream_5);

        int duration = 300;
        // create animation
        frameAnimation = new AnimationDrawable();
        // set animation to cycle
        frameAnimation.setOneShot(false);
        // add frames with durations to animation
        frameAnimation.addFrame(frame0, duration);
        frameAnimation.addFrame(frame1, duration);
        frameAnimation.addFrame(frame2, duration);
        frameAnimation.addFrame(frame3, duration);
        frameAnimation.addFrame(frame4, duration);
        frameAnimation.addFrame(frame5, duration);
        frameAnimation.addFrame(frame6, duration);
        frameAnimation.addFrame(frame7, duration);
        frameAnimation.addFrame(frame8, duration);
        frameAnimation.addFrame(frame9, duration);
        frameAnimation.addFrame(frame10, duration);

        image.setBackground(frameAnimation);
        frameAnimation.setVisible(true, true);
        frameAnimation.start();
    }

    // stop animation event handler
    public void stopAnimation(){
        frameAnimation.stop();
        frameAnimation.setVisible(false, false);
    }
}