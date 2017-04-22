package com.vary.collapsetest.modules.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.adapter.FoodAdapter;
import com.vary.collapsetest.modules.adapter.PhotoAdapter;
import com.vary.collapsetest.mvp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-20.
 */

public class LeftFragment extends Fragment {

    private FoodAdapter foodAdapter;

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
        View layout = inflater.inflate(R.layout.activity_food, container, false);
        //   textView = (TextView) layout.findViewById(R.id.position);
        setupRecyclerView((RecyclerView) layout.findViewById(R.id.recyclerview),layout);
        Bundle bundle = getArguments();
        if (bundle != null) {
            //         textView.setText("The page Selected is "+bundle.getInt("position"));
        }
        return layout;
    }

    private void setupRecyclerView(RecyclerView rv, View layout) {
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        foodAdapter = new FoodAdapter();
        rv.setAdapter(foodAdapter);

//        final TwinklingRefreshLayout refreshLayout = (TwinklingRefreshLayout) layout.findViewById(R.id.refresh);
////        ProgressLayout headerView = new ProgressLayout(getContext());
//        BezierLayout headerView = new BezierLayout(getActivity());
//        refreshLayout.setHeaderView(headerView);
////        refreshLayout.setFloatRefresh(false);
//        refreshLayout.setPureScrollModeOn();
//        refreshLayout.setEnableOverlayRefreshView(false);
//        refreshLayout.setAutoLoadMore(true);

        refreshCard();

    }

    void refreshCard() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Preparing Salmon Steak Close Up", "BY VIKTOR HANACEK", R.drawable.food1, R.drawable.avatar0));
        foods.add(new Food("Fresh & Healthy Fitness Broccoli Pie with Basil", "BY VIKTOR HANACEK", R.drawable.food2, R.drawable.avatar1));
        foods.add(new Food("Enjoying a Tasty Burger", "BY VIKTOR HANACEK", R.drawable.food3, R.drawable.avatar2));
        foods.add(new Food("Fresh Strawberries and Blackberries in Little Bowl", "BY VIKTOR HANACEK", R.drawable.food4, R.drawable.avatar3));
        foods.add(new Food("Baked Healthy Fitness Broccoli Pie with Basil", "BY VIKTOR HANACEK", R.drawable.food5, R.drawable.avatar4));
        foodAdapter.setDataList(foods);
    }

    void loadMoreCard() {
        List<Food> foods = new ArrayList<>();
//        foods.add(new Food(R.drawable.food3));
//        foods.add(new Food(R.drawable.food2));
//        foods.add(new Food(R.drawable.food1));
        foodAdapter.addItems(foods);
    }
}
