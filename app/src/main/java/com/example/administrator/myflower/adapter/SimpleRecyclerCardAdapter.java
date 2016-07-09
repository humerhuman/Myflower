package com.example.administrator.myflower.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myflower.Bean.Data;
import com.example.administrator.myflower.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/26 0026.
 */
public class SimpleRecyclerCardAdapter extends RecyclerView.Adapter<SimpleRecyclerCardAdapter.SimpleCardViewHolder> {

    private Context mContext;
    private Activity activity;
    private LayoutInflater minflater;
    private List<Data> mData = new ArrayList<Data>();
    private OnItemActionListener onItemActionListener;
    private View view;


    public SimpleRecyclerCardAdapter(Context mContext, List<Data> list){
        this.mContext = mContext;
        minflater = LayoutInflater.from(mContext);
        this.mData.addAll(list);

    }
//    获得ViewHold的视图
    @Override
    public SimpleCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        view = minflater.inflate(R.layout.fragment_contain, parent, false);
        SimpleCardViewHolder viewHolder = new SimpleCardViewHolder(view);
        viewHolder.isRecyclable();

        return viewHolder;


    }
//    创建点击事件
    public void setOnitemActionListener(OnItemActionListener onitemActionListener){
        this.onItemActionListener = onitemActionListener;


    }

//    加载数据
    @Override
    public void onBindViewHolder(final SimpleCardViewHolder holder, final int position) {
        holder.tv.setText(( mData.get(position).getTitle()));
        holder.tv.setHeight(50+(position)%2*30);
        holder.imageView.setImageResource(mData.get(position).getImageId());



        if (onItemActionListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemActionListener.onItemClickListener(v, holder.getAdapterPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Boolean aBoolean = onItemActionListener.onItemLongClickListener(v, holder.getAdapterPosition());
                    return aBoolean;
                }
            });
        }
    }






    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class SimpleCardViewHolder extends RecyclerView.ViewHolder {
        //        为recycleView准备视图
        public TextView tv;
        public ImageView imageView;

        public SimpleCardViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_img);
            tv = (TextView) itemView.findViewById(R.id.item_title);

        }
    }
}


