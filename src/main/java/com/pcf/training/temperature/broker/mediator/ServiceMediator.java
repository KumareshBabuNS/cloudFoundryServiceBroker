package com.pcf.training.temperature.broker.mediator;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.pcf.training.temperature.broker.config.Env;

public class ServiceMediator {

	private static final String TEMPERATURE_SERVICE_PATH = "/city";

	// @Autowired
	private RestTemplate restTemplate;

	private String baseServiceURL;
	private String temperatureServiceURL;

	@Autowired
	public ServiceMediator(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;

		String helloworldServiceURLTemplate = "http://%s:%s";
		baseServiceURL = String.format(helloworldServiceURLTemplate, Env.serviceHost);

		temperatureServiceURL = baseServiceURL + TEMPERATURE_SERVICE_PATH;

		// provide Basic Auth capability
		/*
		 * List<ClientHttpRequestInterceptor> interceptors = new
		 * ArrayList<ClientHttpRequestInterceptor>(); interceptors.add(new
		 * BasicAuthInterceptor(Env.serviceAdminUserName,
		 * Env.serviceAdminPassword));
		 * restTemplate.setInterceptors(interceptors);
		 */
	}

	public void createCityTemperature(String hwInstanceId) {

		String url = temperatureServiceURL + "/add";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Map<String, Object> urlVars = new HashMap<String, Object>();
		urlVars.put("hwInstanceId", hwInstanceId);

		urlVars.put("date", new Date(System.currentTimeMillis()));
		urlVars.put("city", "Pune");

		Map<String, Object> timelyTemperatureMap = new HashMap<String, Object>();
		timelyTemperatureMap.put("time", new Time(System.currentTimeMillis()));
		timelyTemperatureMap.put("temperature", 10);

		urlVars.put("timelyTemperatures", timelyTemperatureMap);

		restTemplate.put(url, entity, urlVars);
	}

	/*
	 * public Object getAllCityTemperatures(String hwInstanceId) {
	 * 
	 * Map<String, String> urlVars = new HashMap<String, String>();
	 * 
	 * String url = temperatureServiceURL + "/getAll"; ResponseEntity
	 * responseEntity = restTemplate.getForEntity(url, urlVars);
	 * 
	 * return responseEntity.getBody(); }
	 */
}
