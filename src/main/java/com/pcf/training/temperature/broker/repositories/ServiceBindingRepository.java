package com.pcf.training.temperature.broker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcf.training.temperature.broker.entities.ServiceBinding;

@Repository
public interface ServiceBindingRepository extends CrudRepository<ServiceBinding, String> {

}
