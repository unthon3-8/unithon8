package com.team8.everymarket.database;

import android.provider.BaseColumns;


public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String _PRODUCT_ID = "_productId";
        public static final String PRODUCT_NAME = "productName";
        public static final String PRODUCT_PRICE = "productPrice";
        public static final String FARM_NAME = "farmName";
        public static final String FARM_ADDRESS = "farmAddress";
        public static final String CONTRACT = "contract";
        public static final String PROFILE = "profile";
        public static final String IMAGE_RESOURCE = "imageResource";
        public static final String ISCHECKED = "isChecked";
        public static final String _TABLENAME = "farminfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_PRODUCT_ID+" integer primary key, "
                        + FARM_ADDRESS +" text not null,"
                        + PRODUCT_NAME +" text , "
                        + PRODUCT_PRICE +" text , "
                        + PROFILE +" text , "
                        + ISCHECKED + " text ,"
                        + IMAGE_RESOURCE +" integer , "
                        + FARM_NAME +" text , "
                        + CONTRACT +" text)";
    }


    //productId, productName, productPrice, farm_name, farm_address, contract, profile, imageResource

}
