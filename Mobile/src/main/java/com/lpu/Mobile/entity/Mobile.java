package com.lpu.Mobile.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Mobile {
	@Id
	private int id;
	
	@NotBlank(message = "Brand name should not be blank.")
	private String brandName;
	
	@Positive(message="phone number should be positive")
	private double price;
	
	private int ram;
	
	@Min(value=50, message="storage must be more than 50")
	private int storage;
	private String color;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	private Image image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Mobile() {
		super();
	}
//	public Image getImage() {
//		return image;
//	}
//	public void setImage(Image image) {
//		this.image = image;
//	}
	
	
	
	

}
