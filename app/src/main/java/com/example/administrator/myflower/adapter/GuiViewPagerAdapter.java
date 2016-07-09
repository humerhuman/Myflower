package com.example.administrator.myflower.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myflower.MainActivity;
import com.example.administrator.myflower.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class GuiViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Activity activity;

    public GuiViewPagerAdapter(List<View> views) {
        this.views = views;

    }




    @Override
    public void destroyItem(View view, int position, Object object) {
        ((ViewPager)view).removeView(views.get(position));

    }

    //    初始化position位置
    @Override
    public Object instantiateItem(View view, int position) {

        ((ViewPager)view).addView(views.get(position));
        if (position==views.size()){
            Button button = (Button) view.findViewById(R.id.btn_enter);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            });
        }

        return views.get(position);

    }



    @Override
    public void finishUpdate(View containe) {
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {

        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==object);
    }
}

