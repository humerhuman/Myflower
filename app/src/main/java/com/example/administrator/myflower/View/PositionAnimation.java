package com.example.administrator.myflower.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class PositionAnimation extends PageAnimation {

    public int xPosition;
    public int yPosition;

    private float xStartPosition;
    private float yStartPosition;

    /**
     *
     * @param context
     * @param forPage
     * @param dx
     * @param dy
     */
    public PositionAnimation(Context context, int forPage, int dx, int dy){
        this.page = forPage;
        this.xPosition = dx;
        this.yPosition = dy;
        this.xStartPosition = -1;
        this.yStartPosition = -1;
    }
    @Override
    public void applyTransformation(View onView, float positionOffset) {

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) onView.getLayoutParams();

        if (positionOffset <= 0.0001) {
//        将平移后位置分别赋值给xStartPosition，yStartPosition
            xStartPosition = onView.getTranslationX();
            yStartPosition = onView.getTranslationY();

            return;
        }

//        水平向左平移
        onView.setTranslationX((int)(xPosition * positionOffset) + xStartPosition);
//        水平向右平移
        onView.setTranslationY((int)(yPosition * positionOffset) + yStartPosition);
//        更新界面
        onView.requestLayout();
    }

    }

