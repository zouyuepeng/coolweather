package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    //解析和处理服务器返回的省级数据
    public static boolean handleProvince(String respone){
        if (!TextUtils.isEmpty(respone)){
            try{
                JSONArray allProvinces=new JSONArray(respone);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCity(String respone,int provinceId){
        if(!TextUtils.isEmpty(respone)){
            try {
                JSONArray allCitys=new JSONArray(respone);
                for(int i=0;i<allCitys.length();i++){
                    JSONObject cityObject=allCitys.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    public static boolean handleCounty(String respone,int cityId){
        if(!TextUtils.isEmpty(respone)){
            try {
                JSONArray allCountys=new JSONArray(respone);
                for(int i=0;i<allCountys.length();i++){
                    JSONObject countyObject=allCountys.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
