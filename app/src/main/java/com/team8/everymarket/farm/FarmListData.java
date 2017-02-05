package com.team8.everymarket.farm;

import java.util.Date;

/**
 * Created by ichaeeun on 2017. 2. 5..
 */

public class FarmListData {
    public String _id;
    public String seller_id;
    public String seller_name;
    public String product_name;
    public String feature;
    public String price;
    public String product_image;


    public FarmListData(String _id, String feature, String price, String product_image, String product_name, String seller_id, String seller_name) {
        this._id = _id;
        this.feature = feature;
        this.price = price;
        this.product_image = product_image;
        this.product_name = product_name;
        this.seller_id = seller_id;
        this.seller_name = seller_name;
    }
}
