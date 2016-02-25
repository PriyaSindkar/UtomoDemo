package com.webmyne.utomodemo.loginRegister;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.webmyne.utomodemo.R;
import com.webmyne.utomodemo.helpers.Functions;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by priyasindkar on 23-02-2016.
 */
public class LoginView extends FrameLayout implements View.OnClickListener{

    private Context mContext;
    private View loginView, registerView;
    private View loginCard;
    private TextView txtLogin, txtNormalLoginTitle, txtSocialMediaLoginTitle, txtLoginBtn, txtSignUpBtn;
    private MaterialEditText editUserName, editPassword, editEmail, ediPhoneNo;
    private CardView facebookCard, googleCard, socialMediaLoginCard, loginBtnCard;
 //   private ImageView imgCancelSocialMediaLogin;
    private FloatingActionButton fabToggle;
    private boolean isNormalLoginShown = true;


    public LoginView(Context context) {
        super(context);
        this.mContext =context;
        init(context, null);
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext =context;
        init(context, attrs);

    }

    public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext =context;
        init(context, attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoginView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mContext =context;
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.login_view, this, true);

        fabToggle = (FloatingActionButton) findViewById(R.id.fabToggle);
        fabToggle.setOnClickListener(this);

        Typeface fonts = Functions.getTypeFace(mContext);

        //normal login
        loginView = findViewById(R.id.login_window);
        loginCard = findViewById(R.id.login_card);
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtNormalLoginTitle = (TextView) findViewById(R.id.txtNormalLoginTitle);
        txtNormalLoginTitle.setTypeface(fonts);
        editUserName = (MaterialEditText) findViewById(R.id.editUserName);
        editUserName.setTypeface(fonts);
        editPassword = (MaterialEditText) findViewById(R.id.editPassword);
        editPassword.setTypeface(fonts);
        editEmail = (MaterialEditText) findViewById(R.id.editEmail);
        editEmail.setTypeface(fonts);
        ediPhoneNo = (MaterialEditText) findViewById(R.id.ediPhoneNo);
        ediPhoneNo.setTypeface(fonts);
        txtLoginBtn = (TextView) findViewById(R.id.txtLoginBtn);
        txtLoginBtn.setTypeface(fonts, Typeface.BOLD);

        loginBtnCard = (CardView) findViewById(R.id.loginBtnCard);

        //social media login
        registerView = findViewById(R.id.register_window);
        facebookCard = (CardView) findViewById(R.id.facebookCard);
        googleCard = (CardView) findViewById(R.id.googleCard);
        socialMediaLoginCard = (CardView) findViewById(R.id.socialMediaLoginCard);
        txtSocialMediaLoginTitle = (TextView) findViewById(R.id.txtSocialMediaLoginTitle);
        txtSocialMediaLoginTitle.setTypeface(fonts);
       /* imgCancelSocialMediaLogin = (ImageView) findViewById(R.id.imgCancelSocialMediaLogin);
        imgCancelSocialMediaLogin.setOnClickListener(this);*/

    }

    private SupportAnimator getCircularRevealAnimation(View view, int centerX, int centerY, float startRadius, float endRadius) {
        return ViewAnimationUtils.createCircularReveal(
                view, centerX, centerY, startRadius, endRadius);
    }

   /* private void animateLogin() {
        imgCancelSocialMediaLogin.animate().scaleX(0F).scaleY(0F).alpha(0F).rotation(90F).
                setDuration(200).setInterpolator(new AccelerateInterpolator()).start();

        SupportAnimator animator = getCircularRevealAnimation(socialMediaLoginCard, registerView.getWidth() / 2, registerView.getHeight() / 2, 1f * registerView.getHeight(), 0F);
        animator.setDuration(500);
        animator.setStartDelay(100);
        animator.addListener(new SupportAnimator.SimpleAnimatorListener() {
            public void onAnimationStart() {
                loginView.setVisibility(View.VISIBLE);
            }

            public void onAnimationEnd() {
                registerView.setVisibility(View.GONE);
                imgCancelSocialMediaLogin.setScaleX(1F);
                imgCancelSocialMediaLogin.setScaleY(1F);
                imgCancelSocialMediaLogin.setAlpha(1F);
              //  imgCancelSocialMediaLogin.setRotation(45F);
                fabToggle.setVisibility(View.VISIBLE);

                ObjectAnimator animX = ObjectAnimator.ofFloat(fabToggle, "scaleX", 0F, 1F);
                ObjectAnimator animY = ObjectAnimator.ofFloat(fabToggle, "scaleY", 0F, 1F);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(fabToggle, "alpha", 0F, 1F);
                ObjectAnimator rotation = ObjectAnimator.ofFloat(fabToggle, "rotation", 90F, 0F);
                AnimatorSet animator = new AnimatorSet();
                animator.playTogether(animX, animY, alpha, rotation);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(200);
                animator.start();
            }
        });
        animator.start();
    }*/

    private void animateLogin() {
        Path path = new Path();
        RectF rect = new RectF(-241F, -40F, 41F, 242F);
        path.addArc(rect, -45F, 180F);
        path.lineTo(-0F, -50F);

        ObjectAnimator animX = ObjectAnimator.ofFloat(fabToggle, "scaleX", 0F, 1F);
        ObjectAnimator animY = ObjectAnimator.ofFloat(fabToggle, "scaleY", 0F, 1F);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(fabToggle, "alpha", 0F, 1F);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(fabToggle, "rotation", 90F, 0F);
        AnimatorSet animator = new AnimatorSet();
        animator.setDuration(500);
        animator.playTogether(animX, animY, rotation, alpha);


        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                SupportAnimator animator = getCircularRevealAnimation(socialMediaLoginCard, registerView.getWidth() / 2, registerView.getHeight() / 2, 1f * registerView.getHeight(), 0F);
                animator.setDuration(500);
                animator.setStartDelay(100);
                animator.addListener(new SupportAnimator.SimpleAnimatorListener() {
                    public void onAnimationStart() {
                        loginView.setVisibility(View.VISIBLE);
                        fabToggle.setVisibility(View.VISIBLE);
                    }

                    public void onAnimationEnd() {
                        registerView.setVisibility(View.GONE);
                    }
                });
                animator.start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        /*FabAnimation fabAnimation = new FabAnimation(path);
        fabAnimation.setDuration(400);
        fabAnimation.setInterpolator(new AccelerateInterpolator());

        fabAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                SupportAnimator animator = getCircularRevealAnimation(socialMediaLoginCard, registerView.getWidth() / 2, registerView.getHeight() / 2, 1f * registerView.getHeight(), 0F);
                animator.setDuration(500);
                animator.setStartDelay(100);
                animator.addListener(new SupportAnimator.SimpleAnimatorListener() {
                    public void onAnimationStart() {
                        loginView.setVisibility(View.VISIBLE);
                        fabToggle.setVisibility(View.VISIBLE);
                    }

                    public void onAnimationEnd() {
                        registerView.setVisibility(View.GONE);
                        *//*imgCancelSocialMediaLogin.setScaleX(1F);
                        imgCancelSocialMediaLogin.setScaleY(1F);
                        imgCancelSocialMediaLogin.setAlpha(1F);*//*
                        //  imgCancelSocialMediaLogin.setRotation(45F);


                        *//*ObjectAnimator animX = ObjectAnimator.ofFloat(fabToggle, "scaleX", 0F, 1F);
                        ObjectAnimator animY = ObjectAnimator.ofFloat(fabToggle, "scaleY", 0F, 1F);
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(fabToggle, "alpha", 0F, 1F);
                        ObjectAnimator rotation = ObjectAnimator.ofFloat(fabToggle, "rotation", 90F, 0F);
                        AnimatorSet animator = new AnimatorSet();
                        animator.playTogether(animX, animY, alpha, rotation);
                        animator.setInterpolator(new AccelerateInterpolator());
                        animator.setDuration(200);
                        animator.start();*//*
                    }
                });
                animator.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fabToggle.startAnimation(fabAnimation);*/
    }

    private void animateRegister() {
        Path path = new Path();
        RectF rect = new RectF(-241F, -40F, 41F, 242F);
        path.addArc(rect, -45F, 180F);
        path.lineTo(-0F, -50F);


        ObjectAnimator animX = ObjectAnimator.ofFloat(fabToggle, "scaleX", 0F, 1F);
        ObjectAnimator animY = ObjectAnimator.ofFloat(fabToggle, "scaleY", 0F, 1F);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(fabToggle, "alpha", 0F, 1F);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(fabToggle, "rotation", 90F, 0F);
        AnimatorSet animator = new AnimatorSet();
        animator.setDuration(500);
        animator.playTogether(animX, animY, rotation, alpha);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                SupportAnimator animator = getCircularRevealAnimation(socialMediaLoginCard, registerView.getWidth() - 250, 400, 0f, 2F * registerView.getHeight());
                animator.setDuration(700);
                animator.setStartDelay(200);
                animator.addListener(new SupportAnimator.SimpleAnimatorListener() {
                    public void onAnimationStart() {
                        registerView.setVisibility(View.VISIBLE);
                        fabToggle.setVisibility(View.VISIBLE);
                    }

                    public void onAnimationEnd() {
                        loginView.setVisibility(View.GONE);
                    }
                });
                animator.start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        /*FabAnimation fabAnimation = new FabAnimation(path);
        fabAnimation.setDuration(400);
        fabAnimation.setInterpolator(new AccelerateInterpolator());

        fabAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                SupportAnimator animator = getCircularRevealAnimation(socialMediaLoginCard, registerView.getWidth() - 250, 400, 0f, 2F * registerView.getHeight());
                animator.setDuration(700);
                animator.setStartDelay(200);
                animator.addListener(new SupportAnimator.SimpleAnimatorListener() {
                    public void onAnimationStart() {
                        registerView.setVisibility(View.VISIBLE);
                        fabToggle.setVisibility(View.VISIBLE);
                    }

                    public void onAnimationEnd() {
                        loginView.setVisibility(View.GONE);
                    }
                });
                animator.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //fabToggle.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        fabToggle.startAnimation(fabAnimation);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabToggle:
                if( isNormalLoginShown) {
                    animateRegister();
                } else {
                    animateLogin();
                }
                isNormalLoginShown = !isNormalLoginShown;
                break;
           /* case R.id.imgCancelSocialMediaLogin:
                animateLogin();
                break;*/
        }
    }

    class FabAnimation extends Animation {
        private PathMeasure measure;
        private float[] pos;

        public FabAnimation(Path path) {
            measure = new PathMeasure(path, false);
            pos = new float[]{0, 0};
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            measure.getPosTan(measure.getLength() * interpolatedTime, pos, null);
            Matrix matrix = t.getMatrix();
            matrix.setTranslate(pos[0], pos[1]);
            matrix.preRotate(interpolatedTime * 45);
            t.setAlpha(1 - interpolatedTime);
        }
    }

    public void showRegister() {
        txtLoginBtn.setText("Register");
        txtNormalLoginTitle.setText("Register");
        Animator loginBtnDisappearAnim = ObjectAnimator.ofFloat(loginBtnCard, "translationY",0,500);
        Animator signUpBtnAppearAnim = ObjectAnimator.ofFloat(loginBtnCard, "translationY",500,0);
        Animator userNameFieldDisAppearAnim = ObjectAnimator.ofFloat(editUserName, "translationX",200,0);
        Animator emailFieldAppearAnim = ObjectAnimator.ofFloat(editEmail, "translationX",-200,0);
        Animator phoneNoFieldAppearAnim = ObjectAnimator.ofFloat(ediPhoneNo, "translationX",-200,0);

        loginBtnDisappearAnim.setDuration(500);
        signUpBtnAppearAnim.setDuration(500);
        userNameFieldDisAppearAnim.setDuration(500);
        emailFieldAppearAnim.setDuration(500);
        phoneNoFieldAppearAnim.setDuration(500);

        loginBtnCard.setVisibility(View.VISIBLE);
        editUserName.setVisibility(GONE);
        editEmail.setVisibility(VISIBLE);
        ediPhoneNo.setVisibility(VISIBLE);

        loginBtnCard.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
        editEmail.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
        ediPhoneNo.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
        editUserName.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));

        AnimatorSet loginSet = new AnimatorSet();
        loginSet.playTogether(loginBtnDisappearAnim, signUpBtnAppearAnim, emailFieldAppearAnim, phoneNoFieldAppearAnim, userNameFieldDisAppearAnim);
        loginSet.start();
    }

    public void showLogin() {
        txtLoginBtn.setText("LOGIN");
        txtNormalLoginTitle.setText("Login");
        Animator loginBtnDisappearAnim = ObjectAnimator.ofFloat(loginBtnCard, "translationY",0,500);
        Animator loginBtnAppearAnim = ObjectAnimator.ofFloat(loginBtnCard, "translationY",-500,0);
        Animator userNameFieldAppearAnim = ObjectAnimator.ofFloat(editUserName, "translationX", -200,0);
        Animator emailFieldDisAppearAnim = ObjectAnimator.ofFloat(editEmail, "translationX", 0,700);
        Animator phoneFieldDisAppearAnim = ObjectAnimator.ofFloat(ediPhoneNo, "translationX", 0,700);

        loginBtnDisappearAnim.setDuration(500);
        loginBtnAppearAnim.setDuration(500);
        emailFieldDisAppearAnim.setDuration(500);
        phoneFieldDisAppearAnim.setDuration(500);
        userNameFieldAppearAnim.setDuration(500);

        loginBtnCard.setVisibility(View.VISIBLE);
        editUserName.setVisibility(VISIBLE);
        editEmail.setVisibility(GONE);
        ediPhoneNo.setVisibility(GONE);

        loginBtnCard.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));
        editEmail.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));
        ediPhoneNo.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));
        editUserName.setAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));

        AnimatorSet loginSet = new AnimatorSet();
        loginSet.playTogether(loginBtnDisappearAnim, loginBtnAppearAnim, emailFieldDisAppearAnim, phoneFieldDisAppearAnim, userNameFieldAppearAnim);
        loginSet.start();
    }

    public void showStartupRegister () {
        txtLoginBtn.setText("REGISTER");
        txtNormalLoginTitle.setText("Register");
        editUserName.setVisibility(GONE);
        editEmail.setVisibility(VISIBLE);
        ediPhoneNo.setVisibility(VISIBLE);
    }
}
