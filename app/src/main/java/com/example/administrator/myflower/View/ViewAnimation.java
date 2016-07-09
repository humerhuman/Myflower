package com.example.administrator.myflower.View;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class ViewAnimation {


    private View view;
    private HashMap<Integer, ArrayList<PageAnimation>> pageAnimationMap;

    public ViewAnimation(View inView) {
        this.view = inView;
//        创建一个哈希map集合集合包括一个int类型和一个动画集合
        this.pageAnimationMap = new HashMap<Integer, ArrayList<PageAnimation>>();
    }

    /**
     * 开始位置
     * @param xPosition X坐标位置
     * @param yPosition Y坐标位置
     */
    public void startToPosition(Integer xPosition, Integer yPosition) {
        if (xPosition != null) this.view.setX(xPosition);
        if (yPosition != null) this.view.setY(yPosition);
        this.view.requestLayout();
    }

    /**
     * 添加一个animation
     * @param inPageAnimation animation
     */
    public void addPageAnimation(PageAnimation inPageAnimation) {
//        根据int page值取得哈希表中的 animation集合
        ArrayList<PageAnimation> animationList = pageAnimationMap.get(inPageAnimation.page);

        if (animationList == null) animationList = new ArrayList<PageAnimation>();
//        将一个动画加入到animationList中
        animationList.add(inPageAnimation);
//        将page和animationList放入哈希表
        pageAnimationMap.put(inPageAnimation.page, animationList);
    }

    /**
     *
     * @param page
     * @param positionOffset
     */
    public void applyAnimation(int page, float positionOffset) {
        ArrayList<PageAnimation> animationList = pageAnimationMap.get(page);

        if (animationList == null) return;

//        遍历animationList获得animation
        for(PageAnimation animation : animationList) {

            animation.applyTransformation(this.view, positionOffset);
        }
    }


}
