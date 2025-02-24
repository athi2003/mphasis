package com.project.junit1;


import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator(); // Create a new instance before each test
    }

    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        Assertions.assertEquals(8, result, "2 + 3 should equal 5");
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        Assertions.assertEquals(2, result, "5 - 3 should equal 2");
    }
}
