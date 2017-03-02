package com.pcf.training.temperature.broker.model;

import java.io.Serializable;
import java.sql.Time;

public class TimelyTemperature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6319431109517740927L;

	private Integer id;

	private Time time;

	private Double temperature;

	public TimelyTemperature() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {

		return super.toString();
	}
}
