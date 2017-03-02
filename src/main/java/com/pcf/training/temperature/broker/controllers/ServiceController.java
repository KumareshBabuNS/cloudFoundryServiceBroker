package com.pcf.training.temperature.broker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcf.training.temperature.broker.mediator.ServiceMediator;
import com.pcf.training.temperature.broker.model.CityWithDate;

@RestController
@RequestMapping(value = "/mediator")
public class ServiceController {

	@Autowired
	ServiceMediator serviceMediator;

	@RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.POST)
	public CityWithDate add(@RequestBody CityWithDate cityWithDate) throws JsonProcessingException {

		cityWithDate = serviceMediator.create(cityWithDate);

		return cityWithDate;
	}

	@RequestMapping(value = "/getAll", produces = "application/json", method = RequestMethod.GET)
	public List<CityWithDate> getAll() {

		return serviceMediator.readAll();
	}

	@RequestMapping(value = "/getDummyObject", produces = "application/json", method = RequestMethod.GET)
	public CityWithDate getDummyObject() {

		return serviceMediator.getDummyObject();
	}
}
