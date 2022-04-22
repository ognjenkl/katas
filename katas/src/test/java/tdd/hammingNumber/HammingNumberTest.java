package tdd.hammingNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HammingNumberTest {

    HammingNumber hammingNumber;

    @BeforeEach
    void setUp() {
        hammingNumber = new HammingNumber();
    }

    @Test
    void hammingTest() {
        assertEquals(1, hammingNumber.hamming(1));
        assertEquals(2, hammingNumber.hamming(2));
        assertEquals(3, hammingNumber.hamming(3));
        assertEquals(4, hammingNumber.hamming(4));
        assertEquals(5, hammingNumber.hamming(5));
        assertEquals(6, hammingNumber.hamming(6));

        assertEquals(8, hammingNumber.hamming(7));
        assertEquals(9, hammingNumber.hamming(8));
        assertEquals(10, hammingNumber.hamming(9));
        assertEquals(12, hammingNumber.hamming(10));

        assertEquals(15, hammingNumber.hamming(11));
        assertEquals(16, hammingNumber.hamming(12));
        assertEquals(18, hammingNumber.hamming(13));
        assertEquals(20, hammingNumber.hamming(14));
        assertEquals(24, hammingNumber.hamming(15));
        assertEquals(25, hammingNumber.hamming(16));
        assertEquals(27, hammingNumber.hamming(17));
        assertEquals(30, hammingNumber.hamming(18));
        assertEquals(32, hammingNumber.hamming(19));
    }

    @Test
    void given7_whenNThSmallestHammingNumber_then8() {
        assertEquals(8, hammingNumber.hamming(7));
    }

    @Test
    void given8_whenNThSmallestHammingNumber_then9() {
        assertEquals(9, hammingNumber.hamming(8));
    }

    @Test
    void given600_whenNThSmallestHammingNumber_then2460375() {
        assertEquals(2460375, hammingNumber.hamming(600));
    }

    @Test
    void given1000_whenNThSmallestHammingNumber_then51200000() {
        assertEquals(51200000, hammingNumber.hamming(1000));
    }

    @Test
    void given2000_whenNThSmallestHammingNumber_then8062156800() {
        assertEquals(8062156800L, hammingNumber.hamming(2000));
    }

    @Test
    void given3000_whenNThSmallestHammingNumber_then2460375() {
        assertEquals(2460375, hammingNumber.hamming(3000));
    }

    @Test
    void given4000_whenNThSmallestHammingNumber_then2460375() {
        assertEquals(2460375, hammingNumber.hamming(4000));
    }

    @Test
    void given5000_whenNThSmallestHammingNumber_then2460375() {
        assertEquals(2460375, hammingNumber.hamming(5000));
    }


    @Test
    void given1To5000_whenNThSmallestHammingNumber_thenPrint() {
//        for(int i = 1; i <= 600; i++)
        for(int i = 1; i <= 5000; i++)
//        for(int i = 1; i <= 300; i++)
            System.out.println(i + ". " + hammingNumber.hamming(i));
    }

//    @Test
//    void given1To6_whenIsHummingNumber_thenTure() {
//        for (long i = 1; i < 7; i++)
//            assertTrue(hammingNumber.isHammingNumber(i));
//    }
//
//    @Test
//    void given7_whenIsHummingNumber_thenFalse() {
//        assertFalse(hammingNumber.isHammingNumber(7));
//    }
//
//    @Test
//    void given8To10_whenIsHummingNumber_thenTure() {
//        for (long i = 8; i <= 10; i++)
//            assertTrue(hammingNumber.isHammingNumber(i));
//    }
//
//    @Test
//    void given11_whenIsHummingNumber_thenFalse() {
//        assertFalse(hammingNumber.isHammingNumber(11));
//    }
//
//    @Test
//    void given12_whenIsHummingNumber_thenFalse() {
//        assertTrue(hammingNumber.isHammingNumber(12));
//    }
//
//    @Test
//    void given13_whenIsHummingNumber_thenFalse() {
//        assertFalse(hammingNumber.isHammingNumber(13));
//    }
}
