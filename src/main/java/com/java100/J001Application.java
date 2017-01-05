package com.java100;

import com.java100.model.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.java100.service.WeatherFormatter;
import com.java100.service.XmlParser;
import com.java100.service.YahooRetriever;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
@EnableAutoConfiguration
public class J001Application  implements CommandLineRunner {

	@Autowired
	private WeatherFormatter weatherFormatter;
	@Autowired
	private YahooRetriever yahooRetriever;
	@Autowired
	private XmlParser xmlParser;


	@Override
	 public void run (String...args) throws Exception {



		String zip = "97201";
			try {
				zip = args[0];

			} catch (Exception e) {
			}

			System.out.println("---------------------------------");
			System.out.println("start");
			System.out.println("zip =" +zip);


	 		InputStream dataIn =this.yahooRetriever.retrieve(Integer.parseInt(zip));

			Weather weather =this.xmlParser.parser(dataIn);

		    System.out.print(this.weatherFormatter.format(weather));



	}
     public static void main(String[] args) throws Exception{


		 SpringApplication.run(J001Application.class, args);
	}



}

