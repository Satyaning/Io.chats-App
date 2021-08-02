package com.example.iochat.Apps.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iochat.R;
import com.example.iochat.Apps.SignInActivity;

public class SplashActivity extends AppCompatActivity{

        private static int SPLASH_SCREEN = 3000;

        //animation
        Animation topAnim,bottomAnim;
        ImageView image;
        TextView txt1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_splash);
            getSupportActionBar().hide();

            //Animations

            topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
            bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

            //hooks

            image =findViewById(R.id.logo);
            txt1 = findViewById(R.id.text);


            image.setAnimation(topAnim);
            txt1.setAnimation(bottomAnim);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
            },SPLASH_SCREEN);
        }
}