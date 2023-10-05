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

@Entity(name = "bicycles")
public class Bicycle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String model;

	private int year;

	@OneToMany(mappedBy = "bicycle", cascade = CascadeType.ALL)
	private Set<ShopBicycle> shopsWithBicycle = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set<ShopBicycle> getShopsWithBicycle() {
		return shopsWithBicycle;
	}

	public void setShopsWithBicycle(Set<ShopBicycle> shopsWithBicycle) {
		this.shopsWithBicycle = shopsWithBicycle;
	}

	public Bicycle(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}

	public Bicycle() {
	}
	
	@Override
    public String toString() {
        return "Bicycle [id=" + this.id + ", model=" + this.model + ", year=" + this.year + ", shopsWithBicycle=" + this.shopsWithBicycle + "]";
    } 

}
