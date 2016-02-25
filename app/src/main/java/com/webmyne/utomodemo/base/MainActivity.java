package com.webmyne.utomodemo.base;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.webmyne.utomodemo.R;
import com.webmyne.utomodemo.helpers.Functions;
import com.webmyne.utomodemo.loginRegister.LoginActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mViewPager;
    TabsPagerAdapter mAdapter;
    private static final int NUM_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(true, new AccordionTransformer());

        TextView txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setTypeface(Functions.getTypeFace(MainActivity.this), Typeface.BOLD);
        txtRegister.setOnClickListener(this);

        TextView txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setTypeface(Functions.getTypeFace(MainActivity.this), Typeface.BOLD);
        txtLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtLogin:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("isLogin", true);
                startActivity(intent);
                break;
            case R.id.txtRegister:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("isLogin", false);
                startActivity(intent);
                break;
        }
    }

    public class TabsPagerAdapter extends FragmentStatePagerAdapter {

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            switch (index) {
                case 0:
                    return UserGuideFragment.newInstance(R.drawable.slider1);
                case 1:
                    return UserGuideFragment.newInstance(R.drawable.slider2);
                case 2:
                    return UserGuideFragment.newInstance(R.drawable.slider3);
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
