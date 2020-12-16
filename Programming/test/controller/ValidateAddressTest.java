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
		"Dai hoc Bach Khoa Ha Noi,true",
		"Nguyen@VanSon,false",
		"Van&Son,false",
		"Son*,false"
	})
	void test(String address, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateAddress(address);
		
		//then
		assertEquals(expected, isValid);
	}

}
