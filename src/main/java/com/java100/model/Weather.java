package com.java100.model;

import lombok.Data;

/**
 * Created by may on 12/14/16.
 */

@Data
public class Weather {

    private  String  city;
    private  String  region;
    private  String  country;
    private  String  condition;
    private  String  temp;
    private  String  chill;
    private  String  humidity;

    public Weather () {}
}
