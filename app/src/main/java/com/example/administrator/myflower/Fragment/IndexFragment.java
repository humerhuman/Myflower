package com.example.administrator.myflower.Fragment;

import android.app.Fragment;
import android.os.Bundle;
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


public class IndexFragment extends Fragment {

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDataAndView();

    }

    public void initDataAndView() {
//        准备数据
        int[] imageId = {R.mipmap.recycler_pic0,R.mipmap.recycler_pic1,R.mipmap.recycler_pic2
                ,R.mipmap.recycler_pic3,R.mipmap.recycler_pic4,R.mipmap.recycler_pic5,R.mipmap.recycler_pic6,
                R.mipmap.recycler_pic7,R.mipmap.recycler_pic8,R.mipmap.recycler_pic9,R.mipmap.recycler_pic10
                ,R.mipmap.recycler_pic11,R.mipmap.recycler_pic12,R.mipmap.recycler_pic13,R.mipmap.recycler_pic14,
        R.mipmap.g1};

        List<Data> mlists = new ArrayList<>();

        for (int i = 1; i <imageId.length; i++) {

            Data data = new Data();
            data.setTitle("首页" + i);
            data.setImageId(imageId[i]);

            mlists.add(data);

        }

            RecyclerView index_recycleView = (RecyclerView) view.findViewById(R.id.index_recycleView);
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
        public View getView () {

            return view;
        }


        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState){



            view = inflater.inflate(R.layout.fragment_index,null);


            return view;
        }
    }
