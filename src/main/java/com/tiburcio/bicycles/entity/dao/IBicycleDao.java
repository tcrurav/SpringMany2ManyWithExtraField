package com.tiburcio.bicycles.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.bicycles.entity.model.Bicycle;

public interface IBicycleDao extends CrudRepository<Bicycle, Long>{

}
