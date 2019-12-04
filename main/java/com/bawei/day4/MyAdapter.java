package com.bawei.day4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day4.bean.ShopBean;
import com.bawei.day4.glide.GlideUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainActivity mainActivity;
    private ArrayList<ShopBean.ResultBean> list;


    public MyAdapter(MainActivity mainActivity, ArrayList<ShopBean.ResultBean> list) {

        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item, null);
        holder = new oneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof oneHolder){
            ((oneHolder) holder).rank.setText(list.get(position).getRank());
            ((oneHolder) holder).title.setText(list.get(position).getTitle());
            GlideUtil.Loadimage(list.get(position).getImageUrl(),((oneHolder) holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class oneHolder extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView title;
       TextView rank;
        public oneHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.image);
            title=view.findViewById(R.id.title);
            rank=view.findViewById(R.id.rank);
        }
    }
}
