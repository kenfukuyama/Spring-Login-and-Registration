package com.kenfukuyama.examples.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kenfukuyama.examples.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();

}
