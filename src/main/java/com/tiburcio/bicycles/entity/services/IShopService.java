package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.model.Shop;

public interface IShopService {
	public List<Shop> getAll();
	public Shop get(long id);
	public void add(Shop shop);
	public void update(Shop shop, long id);
	public void delete(long id);
}
