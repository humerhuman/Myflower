package com.example.administrator.myflower.Fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.myflower.Bean.Data;
import com.example.administrator.myflower.R;
import com.example.administrator.myflower.adapter.OnItemActionListener;
import com.example.administrator.myflower.adapter.SimpleRecyclerCardAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/26 0026.
 */
public class TravelImagesFragment extends Fragment{
    private View view;
    public void initDataAndView() {
//        准备数据
//        int[] imageId = new int[]{R.mipmap.demo, R.mipmap.g1};

        Data data = new Data();
        List<Data> mlists = new ArrayList<>();


        for (int i = 1; i <= 100; i++) {

            data.setTitle("旅行" + i);


//            for (int image : imageId) {
//                data.setImgId(image);
//            }
            mlists.add(data);
        }

        RecyclerView index_recycleView = (RecyclerView) view.findViewById(R.id.travel_recycleView);
        SimpleRecyclerCardAdapter recyclerCardAdapter = new SimpleRecyclerCardAdapter(getContext(), mlists);
        System.out.println("绑定适配器");
        index_recycleView.setAdapter(recyclerCardAdapter);
//        设置网格布局
        index_recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerCardAdapter.setOnitemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClickListener(View view, int pos) {
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public Boolean onItemLongClickListener(View view, int pos) {
                Toast.makeText(getContext(), "长按", Toast.LENGTH_SHORT).show();
                return null;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_travel, container, false);

        initDataAndView();
        return view;
    }
}
