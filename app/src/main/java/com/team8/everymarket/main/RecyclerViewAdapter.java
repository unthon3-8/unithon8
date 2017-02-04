package com.team8.everymarket.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team8.everymarket.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;
    View.OnClickListener mOnClickListener;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList, View.OnClickListener OnClickListener) {
        this.itemList = itemList;
        this.context = context;
        this.mOnClickListener = OnClickListener;
    }

    public void setAdapter(ArrayList<ItemObject> itemList){
        this.itemList = itemList;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.farm_list_item, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(mOnClickListener);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.farmName.setText(itemList.get(position).getName());
        holder.farmPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}