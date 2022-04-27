package com.example.jamjam;

import java.util.ArrayList;

public class Data {
    public ArrayList<Result> ResultMode;
    private String title;
    private String content;
    //private int resld;


    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}