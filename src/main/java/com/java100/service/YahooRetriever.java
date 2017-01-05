package com.java100.service;




import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by may on 12/14/16.
 */

@Service
public class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class) ;

    public InputStream retrieve (int zip) throws Exception
    {
        String line = null;


        log.info("retrieve weather information from yahoo");

        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D" + zip + ")&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        URLConnection conn= new URL(url).openConnection();

        /*
        //print out the response
        System.out.println("response contents  **********");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line=reader.readLine()) !=null) {
            System.out.println(line);
        }
        reader.close();
  */
        return conn.getInputStream();
    }
}
