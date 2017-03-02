package com.pcf.training.temperature.broker.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class CityWithDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6359733402881139493L;

	private Integer id;

	private Date date;

	private String city;

	private List<TimelyTemperature> timelyTemperatures;

	public CityWithDate() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<TimelyTemperature> getTimelyTemperatures() {
		return timelyTemperatures;
	}

	public void setTimelyTemperatures(List<TimelyTemperature> timelyTemperatures) {
		this.timelyTemperatures = timelyTemperatures;
	}

	@Override
	public String toString() {

		return super.toString();
	}
}
