package com.yedam;

import org.junit.jupiter.api.Test;

public class AnimalTest {

	@Test
	public void test() {
        Animal a1 = new Dog();  // Dog 객체를 인터페이스 타입으로 참조
        Animal a2 = new Cat();  // Cat 객체를 인터페이스 타입으로 참조

        a1.sound(); // 멍멍!
        a2.sound(); // 야옹~
	}
}
