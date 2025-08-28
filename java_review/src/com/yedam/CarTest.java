package com.yedam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

//	public static void main(String[] args) {
//		Car car = Car.getInstance("카니발");
//		car.drive();
//	}

	@DisplayName("객체생성")
	@Test
	public void test() {
		Car car1 = new Car("테슬라");
		Car car2 = new Car("테슬라");
		assertEquals(car1, car2);

	}

	@DisplayName("싱글톤")
	@Test
	public void test2() {
		Car car1 = Car.getInstance("카니발");
		Car car2 = Car.getInstance("카니발");
		assertEquals(car1, car2);
	}
}
