package com.tiburcio.bicycles.entity.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity(name = "shop_bicycle")
public class ShopBicycle implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShopBicycleKey id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("shopId")
	@JoinColumn(name = "shop_id")
	Shop shop;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("bicycleId")
	@JoinColumn(name = "bicycle_id")
	Bicycle bicycle;

	int stock;

	public ShopBicycleKey getId() {
		return id;
	}

	public void setId(ShopBicycleKey id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public ShopBicycle(Shop shop, Bicycle bicycle, int stock) {
		this.id = new ShopBicycleKey(shop.getId(), bicycle.getId());
		this.shop = shop;
		this.bicycle = bicycle;
		this.stock = stock;
	}

	public ShopBicycle() {
	}

//	@Override
//	public String toString() {
//		return "ShopBicycle [id=" + this.id + ", shop=" + this.shop + ", bicycle=" + this.bicycle + "]";
//	}
}
