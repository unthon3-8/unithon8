package com.team8.everymarket.farm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team8.everymarket.R;


/**
 * Created by ichaeeun on 2017. 2. 5..
 */

public class ViewHolder extends RecyclerView.ViewHolder {


    public TextView tv_product_name;
    public TextView tv_product_price;
    public TextView tv_content;
    public ImageView iv_product;


    public ViewHolder(View itemView) {
        super(itemView);


        tv_product_name = (TextView)itemView.findViewById(R.id.tv_product_name);
        tv_product_price =(TextView)itemView.findViewById(R.id.tv_product_price);
        tv_content =(TextView)itemView.findViewById(R.id.tv_content);
        iv_product =(ImageView)itemView.findViewById(R.id.iv_product);
    }
}
