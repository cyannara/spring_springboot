package com.yedam.ex01;

public class Restaurant {
	
	private Chef chef;

	public Restaurant() { }
	public Restaurant(Chef chef) {
		super();
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
}
