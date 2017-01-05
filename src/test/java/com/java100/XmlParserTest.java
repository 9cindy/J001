package com.java100;

import com.java100.model.Weather;
import com.java100.service.XmlParser;
import com.java100.service.YahooRetriever;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

/**
 * Created by may on 12/15/16.
 */
public class XmlParserTest extends TestCase{

    @Test
    public void testxmlParser() throws Exception
    {
        //open the xml file in the test/resources/

        InputStream in = getClass().getClassLoader().getResourceAsStream("test.xml");

        Weather weather= new XmlParser().parser(in);
        assertEquals("Nome", weather.getCity());
        assertEquals("United States", weather.getCountry());
        assertEquals("AK", weather.getRegion());
        assertEquals("1", weather.getChill());
        assertEquals("Cloudy", weather.getCondition());
        assertEquals("90", weather.getHumidity());
        assertEquals("12", weather.getTemp());

    }
}
