package com.tiburcio.bicycles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiburcio.bicycles.entity.model.Bicycle;
import com.tiburcio.bicycles.entity.services.IBicycleService;
import com.tiburcio.bicycles.exceptions.ErrorMessage;
import com.tiburcio.bicycles.exceptions.ValidationException;

@RestController
public class BicycleController {

	@Autowired
	private IBicycleService bicycleService;

	@GetMapping("/bicycles")
	public ResponseEntity<?> getAll() {

		List<Bicycle> bicycles;
		try {
			bicycles = bicycleService.getAll();
		} catch (Exception e) {
			throw new ValidationException("Could not get list of bicycles");
		}

		return ResponseEntity.ok(bicycles);
	}

	@PostMapping("/bicycles")
	public ResponseEntity<?> post(Bicycle bicycle) {
		try {
			bicycleService.add(bicycle);
		} catch (Exception e) {
			throw new ValidationException("Could not add new bicycle");
		}

		return ResponseEntity.ok(new ErrorMessage("Bicycle added"));
	}

	@PostMapping("/bicycles/add_shop/{shop_id}/to_bicycle/{bicycle_id}")
	public ResponseEntity<?> addShopToBicycle(@PathVariable(value = "shop_id") long shop_id,
			@PathVariable(value = "bicycle_id") long bicycle_id) {
		try {
			bicycleService.addShopToBicycle(shop_id, bicycle_id);
		} catch (ValidationException e) {
			throw new ValidationException(e.getMsg());
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new ValidationException("Could not add stock");
		}
		return ResponseEntity.ok(new ErrorMessage("This shop now has a bicycle in stock"));
	}
	
	
}
