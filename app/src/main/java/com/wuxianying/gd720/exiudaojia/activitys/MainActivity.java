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
    private ImageView mInfo,mProgress;
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

        mInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


            }
        });

        mProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(0);
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
        line = findViewById(R.id.line);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPropertyAnimator.animate(mInfo).scaleX(1.2f).setDuration(0);
        ViewPropertyAnimator.animate(mInfo).scaleY(1.2f).setDuration(0);
    }

    private void changeState(int arg0) {
        if (arg0 == 0) {
            ViewPropertyAnimator.animate(mInfo).scaleX(1.2f).setDuration(200);
            ViewPropertyAnimator.animate(mInfo).scaleY(1.2f).setDuration(200);
            ViewPropertyAnimator.animate(mProgress).scaleX(1.0f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mProgress).scaleY(1.0f)
                    .setDuration(200);
        } else {
            ViewPropertyAnimator.animate(mInfo).scaleX(1.0f).setDuration(200);
            ViewPropertyAnimator.animate(mInfo).scaleY(1.0f).setDuration(200);
            ViewPropertyAnimator.animate(mProgress).scaleX(1.2f)
                    .setDuration(200);
            ViewPropertyAnimator.animate(mProgress).scaleY(1.2f)
                    .setDuration(200);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_info:
                viewPager.setCurrentItem(1);
                break;
            case R.id.main_progress:
                viewPager.setCurrentItem(0);
                break;
        }
    }
}
