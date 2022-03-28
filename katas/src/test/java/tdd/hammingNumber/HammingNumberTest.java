package tdd.hammingNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
