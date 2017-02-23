package com.pcf.training.temperature.broker;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(value = "com.pcf.training.temperature.broker.entities")
@ComponentScan(value = "com.pcf.training.temperature.broker")
public class TemperatureBrokerApplication {

	@Bean
	public Cloud cloud() {
		return new CloudFactory().getCloud();
	}

	@Bean
	public DataSource dataSource() {
		return cloud().getSingletonServiceConnector(DataSource.class, null);
	}

	public static void main(String[] args) {
		SpringApplication.run(TemperatureBrokerApplication.class, args);
	}
}
