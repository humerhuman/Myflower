package com.example.administrator.myflower.View;

import android.view.View;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public abstract class PageAnimation {

    public int page;
    public abstract void applyTransformation(View onView, float positionOffset);
}
