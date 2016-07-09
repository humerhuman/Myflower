package com.example.administrator.myflower.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class ImageSizeUtil {


    public static ImageSize getImageViewSize(ImageView imageView) {

        ImageSize imageSize = new ImageSize();
        DisplayMetrics metrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();

        int width = imageView.getWidth();//获取imageview的实际高度
        if (width <= 0) {
            width = params.width;//获取imagveiw在layout中的声明高度
        }
        if (width <= 0) {
            width = imageView.getMaxWidth();//检查最大值
        }
        if (width <= 0) {
            width = metrics.widthPixels;
        }

        int height = imageView.getHeight();
        if (width <= 0) {
            height = params.height;//获取imageview中的实际高度
        }
        if (height <= 0) {
            height = imageView.getMaxHeight();
        }
        if (height <= 0) {
            height = metrics.heightPixels;
        }

        imageSize.width = width;
        imageSize.height = height;

        return imageSize;


    }

    public static class ImageSize {

        int width;
        int height;
    }

    /**
     * 将一张图片压缩成可显示图片
     * @param path 图片路径
     * @param imageView 展示图片的
     * @return 返回一个bitmap
     */
    public static Bitmap zoomimage(String path, ImageView imageView){
        BitmapFactory.Options options= new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(path,options);

        ImageSize imageViewSize = getImageViewSize(imageView);

        options.inSampleSize=caculateInSampleSize(options,imageViewSize.width,imageViewSize.height);
        options.inJustDecodeBounds=false;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);

        return bitmap;
    }

    /**
     * 根据需求的宽和高以及图片实际的宽和高计算SampleSize
     *
     * @param options option
     * @param reqwidth 需要的宽
     * @param reqheight 需要的高
     * @return 合适缩放比
     */
    public static int caculateInSampleSize(BitmapFactory.Options options, int reqwidth, int reqheight){

        int width = options.outWidth;
        int height = options.outHeight;

        int inSampleSize =1;
        if (width>reqwidth||height>reqheight){
            int widthround = Math.round(width * 1.0f / reqwidth);
            int heightround = Math.round(height * 1.0f / reqheight);

            inSampleSize=Math.max(widthround,heightround);
        }
        return inSampleSize;
    }


}



