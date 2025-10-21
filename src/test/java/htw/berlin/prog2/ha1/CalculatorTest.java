package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display an integer for perfect square")
    void testMulipleSquareRoots(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressDigitKey(2);
        calc.pressDigitKey(5);

        calc.pressUnaryOperationKey("√");
        String expected="25";
        String actual= calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display percentage when mulitplied")
    void testPercentageOf(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected="1";
        String actual= calc.readScreen();
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("should display percentage")
    void testPercentage(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");

        String expected="0.05";
        String actual= calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 1/x")
    void testOneDividedByAnyNumber(){
        Calculator calc =new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected="0.5";
        String actual= calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should be able to calculate 1/x with anything else")
    void testOneDividedByAnyNumberWithOtherOperations(){
        Calculator calc= new Calculator();
        
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected= "3.5";
        String actual= calc.readScreen();
        assertEquals(expected, actual);
    }
}
