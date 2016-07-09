package com.example.administrator.myflower.View;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class SizeAnimation extends  PageAnimation {

    public float dHeigh;
    public float dWidth;

    private int startHeigh;
    private int startWidth;

    /**
     *
     * @param forpage 当前页面id
     * @param dh
     * @param dw
     */
    public SizeAnimation(int forpage,float dh,float dw){
        this.page=forpage;
        this.dHeigh=dh;
        this.dWidth=dw;

    }
    @Override
    public void applyTransformation(View onView, float positionOffset) {


//        获得布局
        ViewGroup.LayoutParams params = onView.getLayoutParams();
        if (positionOffset<0){

            startHeigh=onView.getMeasuredHeight();
            startWidth=onView.getMeasuredWidth();
            return;
        }
        params.height= (int) (dHeigh*startHeigh*positionOffset+startHeigh);
        params.width= (int) (dWidth*startWidth*positionOffset+startWidth);
        onView.setLayoutParams(params);

    }
}
