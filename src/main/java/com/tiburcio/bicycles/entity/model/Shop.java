package com.tiburcio.bicycles.entity.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "shops")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String city;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private Set<ShopBicycle> bicyclesInShop = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<ShopBicycle> getBicyclesInShop() {
		return bicyclesInShop;
	}

	public void setBicyclesInShop(Set<ShopBicycle> bicyclesInShop) {
		this.bicyclesInShop = bicyclesInShop;
	}

	public Shop(String city) {
		super();
		this.city = city;
	}

	public Shop() {

	}
	
	@Override
    public String toString() {
        return "Shop [id=" + this.id + ", city=" + this.city + ", bicyclesInShop=" + this.bicyclesInShop + "]";
    }

}
