package com.pcf.training.temperature.broker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcf.training.temperature.broker.entities.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

}
