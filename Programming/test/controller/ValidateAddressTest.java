package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateAddressTest {
	
	private PlaceOrderController placeOrderController;
	
	@BeforeEach
	void TestSetup() {
		placeOrderController = new PlaceOrderController();
	}

	@ParameterizedTest
	@CsvSource({
		",false",
		"01 Dai Co Viet,true",
		"Bach Khoa Ha Noi,true",
		"abc #xyz,false",
		"truong t$tt,false",
		"lab01*,false"
	})
	void test(String address, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateAddress(address);
		
		//then
		assertEquals(expected, isValid);
	}

}
