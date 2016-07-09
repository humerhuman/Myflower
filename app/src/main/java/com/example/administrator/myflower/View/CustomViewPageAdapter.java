package com.example.administrator.myflower.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.myflower.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class CustomViewPageAdapter  extends FragmentStatePagerAdapter {
        private ArrayList<CustomViewpagerFragment> mFragmentList;

    private int mNumberOfPage = 0;
    private int mBackgroundColor;

    public CustomViewPageAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
    }

    public void setNumberOfPage(int numberOfPage) {
        mNumberOfPage = numberOfPage;
    }


    public void setFragmentBackgroundColor(int colorResource) {
        mBackgroundColor = colorResource;
    }

    @Override
    public Fragment getItem(int position) {

        CustomViewpagerFragment fragment = null;

        if (mFragmentList.size()-1 >= position) fragment = mFragmentList.get(position);

        if (fragment == null) {
            fragment = new CustomViewpagerFragment();
            fragment.setBackground(mBackgroundColor);
        }

        return fragment;
    }


    @Override
    public int getCount() {
        return mNumberOfPage;
    }

    public class CustomViewpagerFragment extends Fragment {
        private int color;
        public CustomViewpagerFragment(){
            this.color= R.color.white;
        }

        public void setBackground(int incolor){
            this.color=incolor;

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            LinearLayout view = new LinearLayout(getActivity());
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            view.setOrientation(LinearLayout.VERTICAL);
            view.setBackgroundColor(getResources().getColor(this.color));
            return view;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }
    }
}
