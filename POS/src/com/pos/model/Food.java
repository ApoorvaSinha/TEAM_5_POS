package com.pos.model;

public class Food {

	private String FoodId;
	private String name;
	private String type;
	private String FoodSize;
	private int quantity;
	private int Price;
	
	public Food()
	{}
	
	public Food(String foodId, String name, String type, String foodSize,
			int quantity, int price) {
		super();
		FoodId = foodId;
		this.name = name;
		this.type = type;
		FoodSize = foodSize;
		this.quantity = quantity;
		Price = price;
	}

	public String getFoodId() {
		return FoodId;
	}

	public void setFoodId(String foodId) {
		FoodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFoodSize() {
		return FoodSize;
	}

	public void setFoodSize(String foodSize) {
		FoodSize = foodSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String toString() {
		return "Food [FoodId=" + FoodId + ", name=" + name + ", type=" + type
				+ ", FoodSize=" + FoodSize + ", quantity=" + quantity
				+ ", Price=" + Price + "]\n";
	}
	
	
	
	
	
}
