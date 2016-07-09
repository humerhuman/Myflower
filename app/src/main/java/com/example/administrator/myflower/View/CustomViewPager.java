package com.example.administrator.myflower.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class CustomViewPager extends ViewPager {

//    动画集合变量
    private List<ViewAnimation> mPageAnimations;
    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
//        获得动画集合实例
        this.mPageAnimations =new ArrayList<ViewAnimation>();
    }

    public CustomViewPager(Context context) {
        super(context);
        this.mPageAnimations =new ArrayList<ViewAnimation>();
    }

    /**
     * 添加一个animation动画
     * @param viewAnimation andimation动画
     */
    public void addAnimation(ViewAnimation viewAnimation){
        mPageAnimations.add(viewAnimation);

    }

//    页面滑动时调用

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
//        position 第一张页面显示的首页位置
//        offsetPixels 从这个位置显示的像素大小
        super.onPageScrolled(position, offset, offsetPixels);

        for (int i = 0; i < mPageAnimations.size(); i++) {
            mPageAnimations.get(i).applyAnimation(position,offset);
        }
    }
}
