package com.example.administrator.myflower;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.myflower.View.CustomViewPageAdapter;
import com.example.administrator.myflower.View.CustomViewPager;
import com.example.administrator.myflower.View.DotsView;
import com.example.administrator.myflower.View.PositionAnimation;
import com.example.administrator.myflower.View.ViewAnimation;
import com.example.administrator.myflower.View.ViewAnimationUtil;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class GuidActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;

    private CustomViewPager mViewPager;
    private CustomViewPageAdapter mPageAdapter;
    private DotsView mDotsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guid);


        mViewPager = (CustomViewPager) findViewById(R.id.viewpager_main_activity);
        mDotsView = (DotsView) findViewById(R.id.dotsview_main);//找到自定义dotsview控件
//        设置DotsView的图片资源
        mDotsView.setDotsResours(R.mipmap.dot_selected, R.mipmap.dot_unselected);
//        设置圆点图片个数
        mDotsView.setNumberOfPage(NUM_PAGES);

        mPageAdapter = new CustomViewPageAdapter(getSupportFragmentManager());
        mPageAdapter.setNumberOfPage(NUM_PAGES);
        mPageAdapter.setFragmentBackgroundColor(R.color.theme_100);
        mViewPager.setAdapter(mPageAdapter);

        mViewPager.setOnPageChangeListener(new CustomViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mDotsView.selectDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        final Point size = ViewAnimationUtil.getDisplaySize(this);

        View nameTag = findViewById(R.id.imageview_main_activity_name_tag);
        ViewAnimation nameTagAnimation = new ViewAnimation(nameTag);
        nameTagAnimation.addPageAnimation(new PositionAnimation(this, 0, 0, -size.y / 2));
        mViewPager.addAnimation(nameTagAnimation);

        View currentlyWork = findViewById(R.id.imageview_main_activity_currently_work);
        ViewAnimation currentlyWorkAnimation = new ViewAnimation(currentlyWork);
        currentlyWorkAnimation.addPageAnimation(new PositionAnimation(this, 0, -size.x, 0));
        mViewPager.addAnimation(currentlyWorkAnimation);

        View atSkex = findViewById(R.id.imageview_main_activity_at_skex);
        ViewAnimationUtil.prepareViewToGetSize(atSkex);
        ViewAnimation atSkexAnimation = new ViewAnimation(atSkex);
        atSkexAnimation.addPageAnimation(new PositionAnimation(getApplicationContext(), 0,
                0, -(size.y - atSkex.getHeight())));
        atSkexAnimation.addPageAnimation(new PositionAnimation(getApplicationContext(), 1, -size.x, 0));
        mViewPager.addAnimation(atSkexAnimation);

        View mobileView = findViewById(R.id.imageview_main_activity_mobile);
        ViewAnimation mobileAnimation = new ViewAnimation(mobileView);
        mobileAnimation.startToPosition((int) (size.x * 1.5), null);
        mobileAnimation.addPageAnimation(new PositionAnimation(this, 0, -(int) (size.x * 1.5), 0));
        mobileAnimation.addPageAnimation(new PositionAnimation(this, 1, -(int) (size.x * 1.5), 0));
        mViewPager.addAnimation(mobileAnimation);

        View djangoView = findViewById(R.id.imageview_main_activity_django_python);
        ViewAnimation djangoAnimation = new ViewAnimation(djangoView);
        djangoAnimation.startToPosition(null, -size.y);
        djangoAnimation.addPageAnimation(new PositionAnimation(this, 0, 0, size.y));
        djangoAnimation.addPageAnimation(new PositionAnimation(this, 1, 0, size.y));
        mViewPager.addAnimation(djangoAnimation);

        View commonlyView = findViewById(R.id.imageview_main_activity_commonly);
        ViewAnimation commonlyAnimation = new ViewAnimation(commonlyView);
        commonlyAnimation.startToPosition(size.x, null);
        commonlyAnimation.addPageAnimation(new PositionAnimation(this, 0, -size.x, 0));
        commonlyAnimation.addPageAnimation(new PositionAnimation(this, 1, -size.x, 0));
        mViewPager.addAnimation(commonlyAnimation);

        View butView = findViewById(R.id.imageview_main_activity_but);
        ViewAnimation butAnimation = new ViewAnimation(butView);
        butAnimation.startToPosition(size.x, null);
        butAnimation.addPageAnimation(new PositionAnimation(this, 1, -size.x, 0));
        butAnimation.addPageAnimation(new PositionAnimation(this, 2, -size.x, 0));
        mViewPager.addAnimation(butAnimation);

        View diplomeView = findViewById(R.id.imageview_main_activity_diploma);
        ViewAnimation diplomeAnimation = new ViewAnimation(diplomeView);
        diplomeAnimation.startToPosition((size.x * 2), null);
        diplomeAnimation.addPageAnimation(new PositionAnimation(this, 1, -size.x * 2, 0));
        diplomeAnimation.addPageAnimation(new PositionAnimation(this, 2, -size.x * 2, 0));
        mViewPager.addAnimation(diplomeAnimation);

        View whyView = findViewById(R.id.imageview_main_activity_why);
        ViewAnimation whyAnimation = new ViewAnimation(whyView);
        whyAnimation.startToPosition(size.x, null);
        whyAnimation.addPageAnimation(new PositionAnimation(this, 1, -size.x, 0));
        whyAnimation.addPageAnimation(new PositionAnimation(this, 2, -size.x, 0));
        mViewPager.addAnimation(whyAnimation);

        View futureView = findViewById(R.id.imageview_main_future);
        ViewAnimation futureAnimation = new ViewAnimation(futureView);
        futureAnimation.startToPosition(null, -size.y);
        futureAnimation.addPageAnimation(new PositionAnimation(this, 2, 0, size.y));
        futureAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(futureAnimation);

        View arduinoView = findViewById(R.id.imageview_main_arduino);
        ViewAnimation arduinoAnimation = new ViewAnimation(arduinoView);
        arduinoAnimation.startToPosition(size.x * 2, null);
        arduinoAnimation.addPageAnimation(new PositionAnimation(this, 2, -size.x * 2, 0));
        arduinoAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(arduinoAnimation);

        View raspberryView = findViewById(R.id.imageview_main_raspberry_pi);
        ViewAnimation raspberryAnimation = new ViewAnimation(raspberryView);
        raspberryAnimation.startToPosition(-size.x, null);
        raspberryAnimation.addPageAnimation(new PositionAnimation(this, 2, size.x, 0));
        raspberryAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(raspberryAnimation);

        View connectedDeviceView = findViewById(R.id.imageview_main_connected_device);
        ViewAnimation connectedDeviceAnimation = new ViewAnimation(connectedDeviceView);
        connectedDeviceAnimation.startToPosition((int) (size.x * 1.5), null);
        connectedDeviceAnimation.addPageAnimation(new PositionAnimation(this, 2, -(int) (size.x * 1.5), 0));
        connectedDeviceAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(connectedDeviceAnimation);

        View checkOutView = findViewById(R.id.imageview_main_check_out);
        ViewAnimation checkOutAnimation = new ViewAnimation(checkOutView);
        checkOutAnimation.startToPosition(size.x, null);
        checkOutAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(checkOutAnimation);


        View buttoninView = findViewById(R.id.btn_enter);
        ViewAnimation buttoninAnimation = new ViewAnimation(buttoninView);
        buttoninAnimation.startToPosition(size.x, null);
        buttoninAnimation.addPageAnimation(new PositionAnimation(this, 3, -size.x, 0));
        mViewPager.addAnimation(buttoninAnimation);

        buttoninView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

