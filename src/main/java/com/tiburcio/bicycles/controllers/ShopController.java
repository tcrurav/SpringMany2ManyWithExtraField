package com.tiburcio.bicycles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiburcio.bicycles.entity.model.Shop;
import com.tiburcio.bicycles.entity.services.IShopService;
import com.tiburcio.bicycles.exceptions.ErrorMessage;
import com.tiburcio.bicycles.exceptions.ValidationException;

@RestController
public class ShopController {
	
	@Autowired
	private IShopService shopService;
	
	@GetMapping("/shops")
	public ResponseEntity<?> getAll(){
		List<Shop> shops;
		try {
			shops = shopService.getAll();
		} catch (Exception e) {
			throw new ValidationException("Could not get list of shops");
		}

		return ResponseEntity.ok(shops);
	}
	
	@PostMapping("/shops")
	public ResponseEntity<?> post(Shop shop){
		try {
			shopService.add(shop);
		} catch (Exception e) {
			throw new ValidationException("Could not add new shop");
		}

		return ResponseEntity.ok(new ErrorMessage("shop added"));
	}

}
