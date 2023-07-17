package com.example.simpleanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.net.ssl.HandshakeCompletedEvent;

public class SplashActivity extends AppCompatActivity {
    ImageView iv_top,ic_heart,iv_beat,iv_bottom;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        anhXa();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Init
        Animation animationTop = AnimationUtils.loadAnimation(this,
                R.anim.top_wave);
        //Start
        iv_top.setAnimation(animationTop);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                ic_heart,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)

        );
        //Set duration
        objectAnimator.setDuration(500);
        //set Repeat
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //set repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //start animation
        objectAnimator.start();
        //load gif..........

        //Bottom
        Animation animationBottom = AnimationUtils.loadAnimation(this,
                R.anim.bot_wave);
        iv_bottom.setAnimation(animationBottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                );
                finish();
            }
        },4000);
    }
    private void anhXa(){
        iv_top = findViewById(R.id.iv_top);
        ic_heart= findViewById(R.id.ic_heart);
        iv_beat = findViewById(R.id.iv_beat);
        iv_bottom = findViewById(R.id.iv_bottom);
        textView = findViewById(R.id.txt_view);

    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //when rumble run
            textView.setText(charSequence.subSequence(0,index++));
            if(index <= charSequence.length()){
                //when index = text length
                //run handle
                handler.postDelayed(runnable,delay);
            }
        }
    };
    //Cre animatined text mothod
    public void animaText(CharSequence cs){
        //set text
        charSequence = cs;
        //clear index
        index = 0;
        //clear text
        textView.setText("");
        //remove call back
        handler.removeCallbacks(runnable);
        //run handler
        handler.postDelayed(runnable,delay);
    }
}