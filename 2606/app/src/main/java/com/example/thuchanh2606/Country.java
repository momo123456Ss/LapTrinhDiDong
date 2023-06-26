package com.example.thuchanh2606;

public class Country {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    int flag;
    public Country(String name,int flag){
        this.name = name;
        this.flag = flag;
    }
}
