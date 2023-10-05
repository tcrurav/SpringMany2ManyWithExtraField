package com.tiburcio.bicycles.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.bicycles.entity.model.Shop;

public interface IShopDao extends CrudRepository<Shop, Long>{

}
