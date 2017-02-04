package com.team8.everymarket.main;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ichaeeun on 2017. 2. 4..
 */

public class MainResult {


    ArrayList<MainListData> result;

    public class MainListData {
        public int id;
        public String title;
        public String contents;
        public String image_url;
        public Date write_day;
        public String owner;
        int view;


        public MainListData(int id, String title, String contents, String image_url, Date write_day, String owner, int view) {
            this.contents = contents;
            this.id = id;
            this.image_url = image_url;
            this.owner = owner;
            this.title = title;
            this.view = view;
            this.write_day = write_day;
        }
    }
}

