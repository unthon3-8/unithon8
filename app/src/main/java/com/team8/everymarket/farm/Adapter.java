package com.team8.everymarket.farm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.team8.everymarket.R;

import java.util.ArrayList;

/**
 * Created by ichaeeun on 2017. 2. 5..
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList mDatas;
    Context context;
    private ArrayList<FarmListData> farmListDataList;

    public Adapter(ArrayList mDatas, Context context) {
        farmListDataList = new ArrayList<>();
        this.mDatas = mDatas;
        this.context = context;

    }

    public void setAdapter(ArrayList<FarmListData> mDatas){
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public void addCardItem(ArrayList items) {

        for(Object item : items) {
            farmListDataList.add((FarmListData) item);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.farm_info_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(context)
                .load(farmListDataList.get(position).product_image)
                .into(holder.iv_product);
        holder.tv_product_name.setText(farmListDataList.get(position).product_name);
        holder.tv_product_price.setText(String.valueOf(farmListDataList.get(position).price));
        holder.tv_content.setText(String.valueOf(farmListDataList.get(position).feature));

    }

    @Override
    public int getItemCount() {
        return (mDatas != null) ? mDatas.size() : 0;
    }
}
