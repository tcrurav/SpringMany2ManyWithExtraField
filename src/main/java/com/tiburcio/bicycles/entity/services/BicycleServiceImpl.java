package com.tiburcio.bicycles.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.IBicycleDao;
import com.tiburcio.bicycles.entity.dao.IShopDao;
import com.tiburcio.bicycles.entity.model.Bicycle;
import com.tiburcio.bicycles.entity.model.Shop;
import com.tiburcio.bicycles.entity.model.ShopBicycle;
import com.tiburcio.bicycles.exceptions.ValidationException;

@Service
public class BicycleServiceImpl implements IBicycleService {

	@Autowired
	private IBicycleDao bicycleDao;

	@Autowired
	private IShopDao shopDao;

	@Override
	public List<Bicycle> getAll() {
		return (List<Bicycle>) bicycleDao.findAll();
	}

	@Override
	public Bicycle get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Bicycle bicycle) {
		bicycleDao.save(bicycle);
	}

	@Override
	public void update(Bicycle bicycle, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addShopToBicycle(long shopId, long bicycleId) {
		Bicycle bicycle = bicycleDao.findById(bicycleId).get();
		Shop shop = shopDao.findById(shopId).get();
		ShopBicycle shopBicycle = new ShopBicycle(shop, bicycle, 1);
		bicycle.getShopsWithBicycle().add(shopBicycle);

		try {
			bicycleDao.save(bicycle);
		} catch (Exception e) {
			throw new ValidationException("this Shop already sells this Bicycle");
		}
	}

}
