package com.tiburcio.bicycles.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.IShopDao;
import com.tiburcio.bicycles.entity.model.Shop;

@Service
public class ShopServiceImpl implements IShopService{
	
	@Autowired
	private IShopDao shopDao;

	@Override
	public List<Shop> getAll() {
		return (List<Shop>) shopDao.findAll();
	}

	@Override
	public Shop get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Shop shop) {
		shopDao.save(shop);
		
	}

	@Override
	public void update(Shop shop, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
