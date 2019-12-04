package com.bawei.day4;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day4.base.BaseActivity;
import com.bawei.day4.base.BasePresenter;
import com.bawei.day4.bean.ShopBean;
import com.bawei.day4.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ArrayList<ShopBean.ResultBean> list = new ArrayList<>();
    private String url="http://172.17.8.100/small/commodity/v1/bannerShow";
    private RecyclerView recy;
    private MyAdapter myAdapter;

    @Override
    protected void startCoding() {

        mPresenter.start(url);
        myAdapter = new MyAdapter(this,list);
        recy.setAdapter(myAdapter);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recy = findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(String json) {
        ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
        list.clear();
        list.addAll(shopBean.getResult());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {

    }
}
