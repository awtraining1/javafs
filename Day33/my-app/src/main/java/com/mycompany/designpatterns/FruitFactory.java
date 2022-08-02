package com.mycompany.designpatterns;

public class FruitFactory {

	static Fruit createFruit(String fruitType, int price ) {

		switch (fruitType) {
		case "Mango":
			return new Mango();
		case "Apple":
			return new Apple();
		default:
			return null;
		}

	}

}
