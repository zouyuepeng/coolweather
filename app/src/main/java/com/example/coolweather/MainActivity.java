package com.example.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather",null) !=null){
            Intent intent=new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
            //时间设置为当前时间，不要一键返回，在标题栏上在加入一个返回按钮
            //系统自带返回按钮要先判断，如果在县和国的界面就直接返回，如果在市的界面则返回到国这个层次
        }
    }
}
