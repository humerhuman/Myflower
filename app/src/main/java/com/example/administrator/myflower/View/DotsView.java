package com.example.administrator.myflower.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class DotsView extends LinearLayout {
//    创建一个ImageView集合，存放圆点图片
   private List<ImageView> dots;
//    被选中圆点id
    private int mSelectedRessource;
//    未被选中的id
    private int mUnSelectedRessource;
//    圆点个数
    private int numberOfpage=0;

    public DotsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setDotsResours(int SelectedRessource,int UnSelectedRessource){

        this.mSelectedRessource=SelectedRessource;
        this.mUnSelectedRessource=UnSelectedRessource;


    }
//    设置圆点个数构造方法

    /**
     *
     * @param pageNumber 圆点个数
     */
    public void setNumberOfPage(int pageNumber){
        this.numberOfpage=pageNumber;
//        创建圆点imageview集合实例
        dots=new ArrayList<>();
//        循环创建并获得圆点ImageView，并创建一个LinearLayout，并将圆点集合放入
        for (int i=0;i<=numberOfpage-1;i++){
            ImageView dot = new ImageView(getContext());
//            获得被选中圆点图标
            dot.setImageDrawable(getResources().getDrawable(mSelectedRessource ,null));
//            创建一个LinearLayout并将圆点放入LinearLayout
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            addView(dot,params);
            dots.add(dot);

        }
        selectDot(0);

    }

    /**
     *获取被选中圆点id
     * @param idex 被选中圆点id
     */
    public void selectDot(int idex) {

        Resources resources = getResources();

        for (int i=0;i<numberOfpage;i++){
//       mSelectedRessource 被选中图片id，mUnSelectedRessource未被选中图片
//       三元运算符，如果(i==idex)是true，drawableId值为mSelectedRessource，如果是false,值为mUnSelectedRessource
            int drawableId=(i==idex)?(mSelectedRessource):(mUnSelectedRessource);

            Drawable drawable = resources.getDrawable(drawableId,null);

            dots.get(i).setImageDrawable(drawable);

        }
    }



}
