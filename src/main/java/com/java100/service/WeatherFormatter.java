package com.java100.service;

import com.java100.model.Weather;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

/**
 * Created by may on 12/14/16.
 */
@Service
public class WeatherFormatter {
    private static Logger log = Logger.getLogger(WeatherFormatter.class) ;

    public String format(Weather weather) throws Exception
    {
        log.info ("Formatting weather Data");
        Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("output.vm"));

        VelocityContext context= new VelocityContext();
        context.put ("weather" , weather);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer , "", reader);
        return writer.toString() ;





    }
}
