package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import controller.PlaceOrderController;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNameTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception{
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
    		", false",
    		"new String(), false",
            "abc@12, false",
            "NguyenVan!Thanh, false",
            "NguyenVanThanh1, false",
            "NguyenVanThanh, true",
            "Nguyen Van Thanh, true",


    })
    void validateName(String name, boolean expected) {
        boolean isValid = placeOrderController.validateName(name);
        assertEquals(expected, isValid);
    }
}
