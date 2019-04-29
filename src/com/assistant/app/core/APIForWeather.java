package com.assistant.app.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weatherapi")
public class APIForWeather {

	@GetMapping(value = "/{city}", produces = "application/json")
	public String getCurrentStatus(@PathVariable String city) {
		return getCurrentWeatherByCity(city);
	}

	private String getCurrentWeatherByCity(String city) {
		String weatherurl = "api.openweathermap.org/data/2.5/weather?q=" + city;
		String weatherOut;
		StringBuilder response = new StringBuilder();
		try {
			URL weatherUrl = new URL(weatherurl);
			HttpURLConnection conn = (HttpURLConnection) weatherUrl.openConnection();
			conn.setRequestMethod("GET");
			int responsecode = conn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responsecode) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((weatherOut = in.readLine()) != null) {
					response.append(weatherOut);
				}
				in.close();
			}
		} catch (Exception er) {
			System.err.println(er.getMessage());
		}
		return response.toString();
	}

}
