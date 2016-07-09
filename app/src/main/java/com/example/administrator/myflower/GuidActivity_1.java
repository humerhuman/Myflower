package com.example.administrator.myflower;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.myflower.adapter.GuiViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class GuidActivity_1 extends Activity implements ViewPager.OnPageChangeListener {
    //    小圆点图片数组
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guid);


//        初始化view
        initView();
//        初始化底部小点
//        initdot();
    }




    private void initView() {
        LayoutInflater inflater = getLayoutInflater();

        List<View> views = new ArrayList<>();

        views.add(inflater.inflate(R.layout.tab0,null));
        views.add(inflater.inflate(R.layout.tab1,null));
        View tab03 = inflater.inflate(R.layout.tab2, null);
        views.add(tab03);
        Button btn_enter = (Button) tab03.findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidActivity_1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        从指定的XML文件加载视图
//        viewpics= (ViewGroup) inflater.inflate(R.layout.activity_guid, null);
//        实例化小圆点的linearlayout和viewpager
//        ViewPager guiViewPage = (ViewPager)findViewById(R.id.guidViewPage);
//        ViewGroup viewpoint = (ViewGroup) findViewById(R.id.ll);

        dots = new ImageView[views.size()];
//        添加小圆点图片
        for (int i = 0; i< views.size(); i++){
            ImageView imageView = new ImageView(this);//            设置小圆点的参数
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));
//            imageView.setPadding(50,0,50,100);
            imageView.setPadding(30,0,30,30);
//            将小圆点添加到数组中
            dots[i]=imageView;

//            默认选中的是第一张图片，此时第一个小圆点是选中状态，其它不是
            if (i==0){
                dots[i].setBackgroundResource(R.mipmap.push_point_selected);

            }else {
                dots[i].setBackgroundResource(R.mipmap.push_point_def);
            }
//            将imageview添加到小圆点视图中
//            viewpoint.addView(dots[i]);
        }
//        显示滑动的视图

        GuiViewPagerAdapter pagerAdapter = new GuiViewPagerAdapter(views);

//        guiViewPage.setAdapter(pagerAdapter);

//        guiViewPage.setOnPageChangeListener(this);
    }


    //    当新页面被选中时调用
    @Override
    public void onPageSelected(int position) {

        for (int i = 0;i<dots.length;i++){
            dots[position].setBackgroundResource(R.mipmap.push_point_selected);
//            不是当前选中的page，小圆点设置为未选中状态
            if (position != i){
                dots[i].setBackgroundResource(R.mipmap.push_point_def);
            }
        }

    }

    //    当页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //    当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
