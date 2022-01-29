package tdd.romanNumeralsHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @Test
    void intToRoman_whenIrregularInput_thenException() {
        assertThrows(Exception.class, () -> romanNumerals.intToRoman(0));
        assertThrows(Exception.class, () -> romanNumerals.intToRoman(-1));
        assertThrows(Exception.class, () -> romanNumerals.intToRoman(4000));
        assertThrows(Exception.class, () -> romanNumerals.intToRoman(40001));
    }

    @Test
    void intToRoman_when1_thenI() throws Exception {
        assertEquals("I", romanNumerals.intToRoman(1));
    }

    @Test
    void intToRoman_when2_thenII() throws Exception {
        assertEquals("II", romanNumerals.intToRoman(2));
    }

    @Test
    void intToRoman_when3_thenIII() throws Exception {
        assertEquals("III", romanNumerals.intToRoman(3));
    }

    @Test
    void intToRoman_when4_thenIV() throws Exception {
        assertEquals("IV", romanNumerals.intToRoman(4));
    }

    @Test
    void intToRoman_when5_thenV() throws Exception {
        assertEquals("V", romanNumerals.intToRoman(5));
    }

    @Test
    void intToRoman_when6_thenVI() throws Exception {
        assertEquals("VI", romanNumerals.intToRoman(6));
    }

    @Test
    void intToRoman_when7_thenVII() throws Exception {
        assertEquals("VII", romanNumerals.intToRoman(7));
    }

    @Test
    void intToRoman_when8_thenVIII() throws Exception {
        assertEquals("VIII", romanNumerals.intToRoman(8));
    }

    @Test
    void intToRoman_when9_thenIX() throws Exception {
        assertEquals("IX", romanNumerals.intToRoman(9));
    }

    @Test
    void intToRoman_when10_thenX() throws Exception {
        assertEquals("X", romanNumerals.intToRoman(10));
    }

    @Test
    void intToRoman_when11_thenXI() throws Exception {
        assertEquals("XI", romanNumerals.intToRoman(11));
    }

    @Test
    void intToRoman_when12_thenXII() throws Exception {
        assertEquals("XII", romanNumerals.intToRoman(12));
    }

    @Test
    void intToRoman_when19_thenXIX() throws Exception {
        assertEquals("XIX", romanNumerals.intToRoman(19));
    }

    @Test
    void intToRoman_when20_thenXX() throws Exception {
        assertEquals("XX", romanNumerals.intToRoman(20));
    }

    @Test
    void intToRoman_when40_thenXL() throws Exception {
        assertEquals("XL", romanNumerals.intToRoman(40));
    }

    @Test
    void intToRoman_when49_thenXLIX() throws Exception {
        assertEquals("XLIX", romanNumerals.intToRoman(49));
    }

    @Test
    void intToRoman_when90_thenXC() throws Exception {
        assertEquals("XC", romanNumerals.intToRoman(90));
    }

    @Test
    void intToRoman_when99_thenXCIX() throws Exception {
        assertEquals("XCIX", romanNumerals.intToRoman(99));
    }

    @Test
    void intToRoman_when100_thenC() throws Exception {
        assertEquals("C", romanNumerals.intToRoman(100));
    }

    @Test
    void intToRoman_when199_thenCXCIX() throws Exception {
        assertEquals("CXCIX", romanNumerals.intToRoman(199));
    }

    @Test
    void intToRoman_when499_thenCDXCIX() throws Exception {
        assertEquals("CDXCIX", romanNumerals.intToRoman(499));
    }

    @Test
    void intToRoman_when500_thenD() throws Exception {
        assertEquals("D", romanNumerals.intToRoman(500));
    }

    @Test
    void intToRoman_when999_thenCMXCIX() throws Exception {
        assertEquals("CMXCIX", romanNumerals.intToRoman(999));
    }

    @Test
    void intToRoman_when3999_thenMMMCMXCIX() throws Exception {
        assertEquals("MMMCMXCIX", romanNumerals.intToRoman(3999));
    }
}
