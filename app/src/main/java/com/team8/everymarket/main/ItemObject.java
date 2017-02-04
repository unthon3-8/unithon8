package com.team8.everymarket.main;

public class ItemObject {

    private int id;
    private String name;
    private int photo;

    public ItemObject(int id, String name, int photo) {
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
