package com.tiburcio.bicycles.entity.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShopBicycleKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "shop_id")
	private long shopId;

	@Column(name = "bicycle_id")
	private long bicycleId;

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(long bicycleId) {
		this.bicycleId = bicycleId;
	}

	public ShopBicycleKey(long shopId, long bicycleId) {
		super();
		this.shopId = shopId;
		this.bicycleId = bicycleId;
	}

	public ShopBicycleKey() {
	}

//	@Override
//    public String toString() {
//        return "ShopBicycleKey [shopId=" + this.shopId + ", bicycleId=" + this.bicycleId + "]";
//    }
}
