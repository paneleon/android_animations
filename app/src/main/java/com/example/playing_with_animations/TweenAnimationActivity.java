package com.example.playing_with_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        // find button and imageView elements
        Button startAnimation = findViewById(R.id.startAnimation);
        ImageView rocketImage = findViewById(R.id.rocketImage);
        ImageView cometImage = findViewById(R.id.cometImage);

        // set event listener to the button
        startAnimation.setOnClickListener(new View.OnClickListener() {
            // event handler for clicking the start button
            @Override
            public void onClick(View v) {
                // load animation from resources
                Animation rocketAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_rocket);
                // and start animation in the Image View
                rocketImage.startAnimation(rocketAnimation);

                Animation cometAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_comet);
                cometImage.startAnimation(cometAnimation);
            }
        });
    }
}