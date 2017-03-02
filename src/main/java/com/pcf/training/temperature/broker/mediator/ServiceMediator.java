package com.pcf.training.temperature.broker.mediator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pcf.training.temperature.broker.config.Env;
import com.pcf.training.temperature.broker.model.CityWithDate;

@Component
public class ServiceMediator {

	private static final String TEMPERATURE_SERVICE_PATH = "/city";

	// @Autowired
	private RestTemplate restTemplate;

	private String baseServiceURL;
	private String temperatureServiceURL;

	@Autowired
	public ServiceMediator(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;

		baseServiceURL = "http://" + Env.serviceHost;

		temperatureServiceURL = baseServiceURL + TEMPERATURE_SERVICE_PATH;

	}

	public CityWithDate create(CityWithDate cityWithDate) throws JsonProcessingException {

		String url = temperatureServiceURL + "/add";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writeValueAsString(cityWithDate);

		HttpEntity<String> request = new HttpEntity<String>(jsonInString, headers);

		ResponseEntity<CityWithDate> response = restTemplate.exchange(url, HttpMethod.POST, request,
				CityWithDate.class);

		return response.getBody();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CityWithDate> readAll() {

		String url = temperatureServiceURL + "/getAll";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);

		return (List<CityWithDate>) response.getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CityWithDate getDummyObject() {

		String url = temperatureServiceURL + "/getDummyObject";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<CityWithDate> response = restTemplate.exchange(url, HttpMethod.GET, request, CityWithDate.class);

		return response.getBody();
	}

}
