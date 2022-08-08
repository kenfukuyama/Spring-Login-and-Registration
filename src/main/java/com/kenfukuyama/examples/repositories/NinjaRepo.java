package com.kenfukuyama.examples.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kenfukuyama.examples.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();

}
