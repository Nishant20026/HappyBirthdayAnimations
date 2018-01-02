package com.apai.happybirthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hbdsong);
        mediaPlayer.start();
        Button mainButton = (Button) findViewById(R.id.mainButton);
        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(200);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mainButton.startAnimation(mAnimation);
        mainButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                view.clearAnimation();
                mediaPlayer.stop();
                Intent Intent = new Intent(view.getContext(), IntroductionActivity.class);
                view.getContext().startActivity(Intent);
            }
        });
    }
}
