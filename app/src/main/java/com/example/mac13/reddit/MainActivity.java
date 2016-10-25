package com.example.mac13.reddit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView, imageView1;
    Animation anim, animRotate;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anim = AnimationUtils.loadAnimation(this, R.anim.new_anim);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.alpha);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(this);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        textView = (TextView) findViewById(R.id.textView);

        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                imageView1.startAnimation(animRotate);
                imageView1.animate().translationX(500).setInterpolator(new AnticipateOvershootInterpolator());
            }
        });


        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Animation Started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "Animation Ended!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        anim.setInterpolator(new AccelerateInterpolator());
    }

    @Override
    public void onClick(View v) {

        imageView.startAnimation(anim);

    }
}
