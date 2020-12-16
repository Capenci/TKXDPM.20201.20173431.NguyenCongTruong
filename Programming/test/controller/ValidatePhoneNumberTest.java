package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import junit.extensions.TestSetup;

class ValidatePhoneNumberTest {
	
	private PlaceOrderController placeOrderController;
	
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"1234567890,false",
		"012354756,false",
		"a123456789,false",
		"0123456789,true",
		"0214ag5623,false"
	})
	void test(String phone, boolean expected) {
		//when
		boolean isValid = placeOrderController.validatePhoneNumber(phone);
		
		//then
		assertEquals(expected, isValid);
	}

}
