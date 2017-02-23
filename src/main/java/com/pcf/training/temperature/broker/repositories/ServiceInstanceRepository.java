package com.pcf.training.temperature.broker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcf.training.temperature.broker.entities.ServiceInstance;

@Repository
public interface ServiceInstanceRepository extends CrudRepository<ServiceInstance, String> {

}
