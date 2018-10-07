package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Now {
    public class More{
        @SerializedName("txt")
        public String info;
    }

    @SerializedName("cond")
    public More more;

    @SerializedName("tmp")
    public String temperature;

}
