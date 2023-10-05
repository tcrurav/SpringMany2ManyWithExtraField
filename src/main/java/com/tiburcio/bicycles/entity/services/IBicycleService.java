package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.model.Bicycle;

public interface IBicycleService {
	public List<Bicycle> getAll();
	public Bicycle get(long id);
	public void add(Bicycle bicycle);
	public void update(Bicycle bicycle, long id);
	public void delete(long id);
	
	public void addShopToBicycle(long shopId, long bicycleId);
}
