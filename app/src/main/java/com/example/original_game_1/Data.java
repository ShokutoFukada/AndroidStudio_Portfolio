package com.example.original_game_1;

import android.app.Application;

public class Data extends Application {

    //経過時間
    private String time ="";
    //経過時間(秒数)
    private int seconds_time;

    @Override
    public void onCreate(){
        super.onCreate();
    }

    //経過時間の保存
    public  String getTime(){
        return this.time;
    }
    public void setTime(String set_time){
        this.time = set_time;
    }

    //経過時間(秒数)の保存
    public  int getSeconds_time(){
        return this.seconds_time;
    }
    public void setSeconds_time(int set_seconds_time){
        this.seconds_time = set_seconds_time;
    }
}
