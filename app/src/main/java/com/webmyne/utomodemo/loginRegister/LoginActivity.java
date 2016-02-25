package com.webmyne.utomodemo.loginRegister;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.utomodemo.R;
import com.webmyne.utomodemo.helpers.Functions;

/**
 * Created by priyasindkar on 23-02-2016.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private LoginView loginView;
    private TextView txtSignUpBtn, txtForgotPassword, txtTerms;
    private LinearLayout linearBottom;
    private CardView cardSignUp;
    private boolean isLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("UToMo");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_navigation_close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Typeface fonts = Functions.getTypeFace(LoginActivity.this);

        isLogin = getIntent().getBooleanExtra("isLogin", true);


        loginView = (LoginView) findViewById(R.id.loginView);
        linearBottom = (LinearLayout) findViewById(R.id.linearBottom);
        txtSignUpBtn = (TextView) findViewById(R.id.txtSignUpBtn);
        txtSignUpBtn.setTypeface(fonts, Typeface.BOLD);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);
        txtForgotPassword.setTypeface(fonts);
        txtTerms = (TextView) findViewById(R.id.txtTerms);
        txtTerms.setTypeface(fonts);

        cardSignUp = (CardView) findViewById(R.id.cardSignUp);
        cardSignUp.setOnClickListener(this);

        if( !isLogin) {
            txtSignUpBtn.setText("LOGIN");
            loginView.showStartupRegister();
        }

        Animator loginViewAnim = ObjectAnimator.ofFloat(loginView, "translationX",500,0);
        loginViewAnim.setDuration(1000);
        loginViewAnim.setInterpolator(new DecelerateInterpolator());
        loginView.setVisibility(View.VISIBLE);
        loginView.setAnimation(AnimationUtils.loadAnimation(LoginActivity.this, android.R.anim.fade_in));
        AnimatorSet loginSet = new AnimatorSet();

        Animator linearBottomAnim = ObjectAnimator.ofFloat(linearBottom, "translationX",-500,0);
        linearBottomAnim.setDuration(1000);
        linearBottomAnim.setInterpolator(new DecelerateInterpolator());
        linearBottom.setVisibility(View.VISIBLE);
        linearBottom.setAnimation(AnimationUtils.loadAnimation(LoginActivity.this, android.R.anim.fade_in));

        loginSet.playTogether(loginViewAnim, linearBottomAnim);
        loginSet.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardSignUp:
                if(txtSignUpBtn.getText().toString().trim().equals("SIGN UP")) {
                    showRegister();
                } else {
                    showLogin();
                }
                break;
        }
    }

    private void showRegister() {
        txtSignUpBtn.setText("LOGIN");
        Animator loginDisappearAnim = ObjectAnimator.ofFloat(cardSignUp, "translationY",0,-500);
        Animator signUpAppearAnim = ObjectAnimator.ofFloat(cardSignUp, "translationY",500,0);
        loginDisappearAnim.setDuration(500);
        signUpAppearAnim.setDuration(500);

        cardSignUp.setVisibility(View.VISIBLE);
        cardSignUp.setAnimation(AnimationUtils.loadAnimation(LoginActivity.this, android.R.anim.fade_in));
        AnimatorSet loginSet = new AnimatorSet();
        loginSet.playTogether(loginDisappearAnim, signUpAppearAnim);
        loginSet.start();
        loginView.showRegister();
    }

    private void showLogin() {
        txtSignUpBtn.setText("SIGN UP");
        Animator signUpDisappearAnim = ObjectAnimator.ofFloat(cardSignUp, "translationY",0,500);
        Animator loginAppearAnim = ObjectAnimator.ofFloat(cardSignUp, "translationY", -500,0);
        signUpDisappearAnim.setDuration(500);
        loginAppearAnim.setDuration(500);

        cardSignUp.setVisibility(View.VISIBLE);
        cardSignUp.setAnimation(AnimationUtils.loadAnimation(LoginActivity.this, android.R.anim.fade_in));
        AnimatorSet loginSet = new AnimatorSet();
        loginSet.playTogether(signUpDisappearAnim, loginAppearAnim);
        loginSet.start();
        loginView.showLogin();
    }
}
