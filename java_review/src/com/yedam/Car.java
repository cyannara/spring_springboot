package com.yedam;

public class Car {

	String model;

	void drive() {
		System.out.println(model + "운행중");
	}
	
	// 1. 자기 자신을 저장할 정적 변수
	private static Car instance;
	
	// 2. private 생성자 (외부에서 new 금지)
	public Car(String model) {
		this.model = model;
	}

	// 3. 유일한 객체 반환 (필요할 때 생성)
	public static Car getInstance(String model) {
		if (instance == null) {
			instance = new Car(model);
		}
		return instance;
	}
}
