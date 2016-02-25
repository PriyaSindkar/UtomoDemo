package com.webmyne.utomodemo.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.utomodemo.R;
import com.webmyne.utomodemo.loginRegister.LoginActivity;

/**
 * Created by priyasindkar on 24-02-2016.
 */
public class SplashActivity extends AppCompatActivity {
    private TextView title;
    private ImageView car;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

        ObjectAnimator animX = ObjectAnimator.ofFloat(title, "scaleX", 0.5F, 1F);
        ObjectAnimator animY = ObjectAnimator.ofFloat(title, "scaleY", 0.5F, 1F);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(title, "alpha", 0.5F, 1F);
        animX.setDuration(5000);
        animY.setDuration(5000);
        alpha.setDuration(5000);

        Animator titleAnimation = ObjectAnimator.ofFloat(title, "rotationX",0,1080);
        Animator car2Animation = ObjectAnimator.ofFloat(car, "translationX",0,2000);

        titleAnimation.setInterpolator(new BounceInterpolator());
        titleAnimation.setStartDelay(2500);
        titleAnimation.setDuration(2000);
        car2Animation.setDuration(5000);
        car2Animation.setInterpolator(new AnticipateOvershootInterpolator());


        AnimatorSet set = new AnimatorSet();
        set.playTogether(car2Animation,animX,animY, alpha, titleAnimation);
        set.start();

        car2Animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void init(){
                title = (TextView)findViewById(R.id.title);
                car = (ImageView)findViewById(R.id.car2);
    }
}
