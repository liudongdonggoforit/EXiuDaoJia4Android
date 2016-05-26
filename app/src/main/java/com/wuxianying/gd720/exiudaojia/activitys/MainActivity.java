package com.wuxianying.gd720.exiudaojia.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.wuxianying.gd720.exiudaojia.R;
import com.wuxianying.gd720.exiudaojia.fragments.GameFragment;
import com.wuxianying.gd720.exiudaojia.fragments.main.APPFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ArrayList<Fragment> fragments;
    private ViewPager viewPager;
    private ImageView mInfo,mProgress,mBrand,mPrice,mScan;
    private int line_width;
    private View line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        viewPager.setAdapter(new FragmentStatePagerAdapter(
                getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                changeState(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                float tagerX = arg0 * line_width + arg2 / fragments.size();
                ViewPropertyAnimator.animate(line).translationX(tagerX)
                        .setDuration(0);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void initData() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new APPFragment());
        fragments.add(new GameFragment());
        fragments.add(new APPFragment());
        fragments.add(new GameFragment());
        fragments.add(new GameFragment());
        line_width = getWindowManager().getDefaultDisplay().getWidth()
                / fragments.size();
        line.getLayoutParams().width = line_width;
        line.requestLayout();
    }

    private void initViews() {
        mInfo = (ImageView) findViewById(R.id.main_info);
        mProgress = (ImageView) findViewById(R.id.main_progress);
        mBrand = (ImageView) findViewById(R.id.main_brand);
        mPrice = (ImageView) findViewById(R.id.main_price);
        mScan = (ImageView) findViewById(R.id.main_scan);
        line = findViewById(R.id.line);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPropertyAnimator.animate(mInfo).scaleX(1.2f).setDuration(0);
        ViewPropertyAnimator.animate(mInfo).scaleY(1.2f).setDuration(0);
    }

    private void changeState(int index) {
        initAnimate();
        if (index == 0) {
            mInfo.setImageResource(R.drawable.main_home_pressed);
            ViewPropertyAnimator.animate(mInfo).scaleX(1.2f).setDuration(200);
            ViewPropertyAnimator.animate(mInfo).scaleY(1.2f).setDuration(200);
        } else if(index == 1){
            mProgress.setImageResource(R.drawable.main_diy_pressed);
            ViewPropertyAnimator.animate(mProgress).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mProgress).scaleY(1.2f)
                    .setDuration(200);
        }else if(index == 2){
            mBrand.setImageResource(R.drawable.main_yellowpage_pressed);
            ViewPropertyAnimator.animate(mBrand).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mBrand).scaleY(1.2f)
                    .setDuration(200);
        }else if(index == 3){
            mPrice.setImageResource(R.drawable.main_price_pressed);
            ViewPropertyAnimator.animate(mPrice).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mPrice).scaleY(1.2f)
                    .setDuration(200);
        }else if(index == 4){
            mScan.setImageResource(R.drawable.main_progress_pressed);
            ViewPropertyAnimator.animate(mScan).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mScan).scaleY(1.2f)
                    .setDuration(200);
        }
    }

    private void initAnimate() {
        mInfo.setImageResource(R.drawable.main_home_normal);
        mProgress.setImageResource(R.drawable.main_diy_normal);
        mBrand.setImageResource(R.drawable.main_yellowpage_normal);
        mPrice.setImageResource(R.drawable.main_price_normal);
        mScan.setImageResource(R.drawable.main_progress_normal);
        ViewPropertyAnimator.animate(mInfo).scaleX(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mInfo).scaleY(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mProgress).scaleX(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mProgress).scaleY(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mBrand).scaleX(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mBrand).scaleY(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mPrice).scaleX(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mPrice).scaleY(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mScan).scaleX(1.0f)
                .setDuration(200);
        ViewPropertyAnimator.animate(mScan).scaleY(1.0f)
                .setDuration(200);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_info:
                viewPager.setCurrentItem(0);
                break;
            case R.id.main_progress:
                viewPager.setCurrentItem(1);
                break;
            case R.id.main_brand:
                viewPager.setCurrentItem(2);
                break;
            case R.id.main_price:
                viewPager.setCurrentItem(3);
                break;
            case R.id.main_scan:
                viewPager.setCurrentItem(4);
                break;
        }
    }
}
