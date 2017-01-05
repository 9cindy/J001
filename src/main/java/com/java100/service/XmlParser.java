package com.java100.service;

import com.java100.model.Weather;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by may on 12/14/16.
 */

@Service
public class XmlParser {
    private static Logger log = Logger.getLogger(XmlParser.class) ;

    public Weather parser (InputStream inputStream) throws Exception
    {
       Weather weather = new Weather();
       log.info("create xml reader") ;

        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);
        log.info( "parsing xml Response");

        weather.setCity(doc.valueOf("/query/results/channel/y:location/@city"));
        System.out.println("city value:" + weather.getCity());

        weather.setRegion(doc.valueOf("/query/results/channel/y:location/@region"));
        weather.setCountry(doc.valueOf("/query/results/channel/y:location/@country"));
        weather.setCondition(doc.valueOf("/query/results/channel/item/y:condition/@text"));
        weather.setTemp(doc.valueOf("/query/results/channel/item/y:condition/@temp"));
     //   System.out.println("temp value:" + weather.getTemp());
        weather.setChill(doc.valueOf("/query/results/channel/y:wind/@chill"));
        weather.setHumidity(doc.valueOf("/query/results/channel/y:atmosphere/@humidity"));

        return weather;

    }

    private SAXReader createXmlReader()
    {
        Map<String, String > uris= new HashMap<String, String>();
        uris.put ("y" ,"http://xml.weather.yahoo.com/ns/rss/1.0");

        DocumentFactory factory = new DocumentFactory() ;
        factory.setXPathNamespaceURIs(uris);

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);

        return xmlReader;
    }
}

