package com.vary.collapsetest.modules.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.adapter.PhotoAdapter;
import com.vary.collapsetest.mvp.model.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-19.
 */

public class MyFragment extends Fragment{

  //  private TextView textView;
    private PhotoAdapter photoAdapter;

    public static MyFragment getInstance(int position){
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_photo, container, false);
     //   textView = (TextView) layout.findViewById(R.id.position);
        setupRecyclerView((RecyclerView) layout.findViewById(R.id.recyclerview),layout);
        Bundle bundle = getArguments();
        if (bundle != null) {
   //         textView.setText("The page Selected is "+bundle.getInt("position"));
        }
        return layout;
    }


    private void setupRecyclerView(RecyclerView rv, View layout) {
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        photoAdapter = new PhotoAdapter();
        rv.setAdapter(photoAdapter);

//        final TwinklingRefreshLayout refreshLayout = (TwinklingRefreshLayout) layout.findViewById(R.id.refresh);
////        ProgressLayout headerView = new ProgressLayout(this);
////        BezierLayout headerView = new BezierLayout(this);
//        BezierLayout headerView = new BezierLayout(getActivity());
//        refreshLayout.setHeaderView(headerView);
//        refreshLayout.setMaxHeadHeight(140);
////        refreshLayout.setFloatRefresh(true);
////        refreshLayout.setPureScrollModeOn(true);
//        refreshLayout.setOverScrollBottomShow(false);
//        refreshLayout.setAutoLoadMore(true);

//        addHeader();
        refreshCard();

//        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
//            @Override
//            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        refreshCard();
//                        refreshLayout.finishRefreshing();
//                    }
//                }, 2000);
//            }
//
//            @Override
//            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loadMoreCard();
//                        refreshLayout.finishLoadmore();
//                    }
//                }, 2000);
//            }
//        });

//        refreshLayout.startRefresh();
    }

    void refreshCard() {
        List<Photo> photos = new ArrayList<>();
//        foods.add(new Food("Preparing Salmon Steak Close Up","BY VIKTOR HANACEK",R.drawable.food1,R.drawable.avatar0));
//        foods.add(new Food("Fresh & Healthy Fitness Broccoli Pie with Basil","BY VIKTOR HANACEK",R.drawable.food2,R.drawable.avatar1));
//        foods.add(new Food("Enjoying a Tasty Burger","BY VIKTOR HANACEK",R.drawable.food3,R.drawable.avatar2));
//        foods.add(new Food("Fresh Strawberries and Blackberries in Little Bowl","BY VIKTOR HANACEK",R.drawable.food4,R.drawable.avatar3));
//        foods.add(new Food("Baked Healthy Fitness Broccoli Pie with Basil","BY VIKTOR HANACEK",R.drawable.food5,R.drawable.avatar4));
        photos.add(new Photo("chest nut", R.drawable.photo1));
        photos.add(new Photo("fish", R.drawable.photo2));
        photos.add(new Photo("cat", R.drawable.photo10));
        photos.add(new Photo("guitar", R.drawable.photo3));
        photos.add(new Photo("common-hazel", R.drawable.photo4));
        photos.add(new Photo("cherry", R.drawable.photo5));
        photos.add(new Photo("flower details", R.drawable.photo6));
        photos.add(new Photo("tree", R.drawable.photo7));
        photos.add(new Photo("blue berries", R.drawable.photo8));
        photos.add(new Photo("snow man", R.drawable.photo9));
        photoAdapter.setDataList(photos);
    }

    void loadMoreCard() {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("chest nut", R.drawable.photo1));
        photos.add(new Photo("fish", R.drawable.photo2));
        photos.add(new Photo("cat", R.drawable.photo10));
        photos.add(new Photo("guitar", R.drawable.photo3));
        photos.add(new Photo("common-hazel", R.drawable.photo4));
        photos.add(new Photo("cherry", R.drawable.photo5));
        photos.add(new Photo("flower details", R.drawable.photo6));
        photos.add(new Photo("tree", R.drawable.photo7));
        photos.add(new Photo("blue berries", R.drawable.photo8));
        photos.add(new Photo("snow man", R.drawable.photo9));
        //chest nut   cat and fish  guitar   common-hazel  cherry   flower details   tree
        //blue berries   snow man
//        foods.add(new Food(R.drawable.food3));
//        foods.add(new Food(R.drawable.food2));
//        foods.add(new Food(R.drawable.food1));
        photoAdapter.addItems(photos);
    }
}
