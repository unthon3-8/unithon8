package com.team8.everymarket.main;

/**
 * Created by ichaeeun on 2017. 2. 4..
 */

public class MainListData {

    private int id;
    private String name;
    private int photo;

    public MainListData(int id, String name, int photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
