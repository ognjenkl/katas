package tdd.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add_ZeroParams() throws Exception {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void add_OneParam_Valid() throws Exception {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void add_OneParam_Invalid() {
        assertThrows(Exception.class, () -> {
            stringCalculator.add("sdr");
        });
    }

    @Test
    void add_OneParam_Invalid2() {
        assertThrows(Exception.class, () -> {
            stringCalculator.add("3,d");
        });
    }

    @Test
    void add_TwoParams_Valid() throws Exception {
        assertEquals(4, stringCalculator.add("3,1"));
    }

    @Test
    void add_ThreeParams_Invalid() {
        assertThrows(Exception.class, () -> {
            stringCalculator.add("3,1,s");
        });
    }

    @Test
    void add_ThreeParams_Valid() throws Exception {
        assertEquals(9, stringCalculator.add("3,1,5"));
    }

    @Test
    void add_FourParams_Invalid() {
        assertThrows(Exception.class, () -> {
            stringCalculator.add("1, 2, 3, s");
        });
    }

    @Test
    void add_FourParams_Valid() throws Exception {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }

    @Test
    void add_10Params_Valid() throws Exception {
        assertEquals(55, stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    void add_ParamsWithNewLine_Valid() throws Exception {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    void add_ParamsWithNewLine_Valid2() throws Exception {
        assertEquals(1, stringCalculator.add("1,\n"));
    }

    @Test
    void add_ParamsWithNewLine_Valid3() throws Exception {
        assertEquals(4, stringCalculator.add("1,\n,3"));
    }

    @Test
    void add_variableDelimiterSemicolon() throws Exception {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void add_variableDelimiterSemicolonWithNewLine() throws Exception {
        assertEquals(6, stringCalculator.add("//;\n1;2\n3"));
    }

    @Test
    void add_1NegativeNumberThrowsException() {
        Exception e = assertThrows(Exception.class, () -> {
            stringCalculator.add("//;\n1;2;-3");
        });
        assertTrue(e.getMessage().equals("Negatives not allowed -3"));
    }

    @Test
    void add_AFewNegativeNumberThrowsException() {
        Exception e = assertThrows(Exception.class, () -> {
            stringCalculator.add("//;\n1;2;-3;-6;5;-7");
        });
        assertTrue(e.getMessage().equals("Negatives not allowed -3 -6 -7"));
    }

    @Test
    void add_IgnoreNumberGreatherThan1000() throws Exception {
        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    void add_variableDelimiterMoreThanOneChar() throws Exception {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    void add_variableDelimiterMoreThanOneChar2() throws Exception {
        assertEquals(6, stringCalculator.add("//[***ee]\n1***ee2***ee3"));
    }

    @Test
    void add_variableMultipleDelimiters() throws Exception {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void add_variableMultipleDelimitersWithMultipleChars() throws Exception {
        assertEquals(6, stringCalculator.add("//[***][%%]\n1***2%%3"));
    }
}
