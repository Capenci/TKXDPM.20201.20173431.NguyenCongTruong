package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import junit.extensions.TestSetup;

class ValidateNameTest {
	
	private PlaceOrderController placeOrderController;
	
	@BeforeEach
	void TestSetup() {
		placeOrderController = new PlaceOrderController();
	}

	@ParameterizedTest
	@CsvSource({
		",false",
		".Truong, false",
		"Nguyen Cong Truong, true",
		"Nguyen&Cong&Truong,false",
		"Truong*,false"
	})
	void test(String name, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateName(name);
		
		//then
		assertEquals(expected, isValid);
	}

}
