package com.example.a27445.myapplication;

import java.util.ArrayList;

import Bean.Data;

public class Mass {
    public ArrayList<Data.ResultsEntity>  list;

    public ArrayList<Data.ResultsEntity> getList(Mass mass) {
        return list;
    }

    public void setList(ArrayList<Data.ResultsEntity> list) {
        this.list = list;
    }
}
