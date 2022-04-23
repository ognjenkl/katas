package tdd.hammingNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HammingNumber2Test {


    HammingNumber2 hammingNumber;

    @BeforeEach
    void setUp() {
        hammingNumber = new HammingNumber2();
    }

    @Test
    void give1_whenHamming_then1() {
        Assertions.assertEquals(1L, hammingNumber.hamming(1L));
    }

    @Test
    void give2_whenHamming_then2() {
        Assertions.assertEquals(2L, hammingNumber.hamming(2L));
    }

    @Test
    void give3_whenHamming_then3() {
        Assertions.assertEquals(3L, hammingNumber.hamming(3L));
    }

    @Test
    void give4_whenHamming_then4() {
        Assertions.assertEquals(4L, hammingNumber.hamming(4L));
    }

    @Test
    void give5_whenHamming_then5() {
        Assertions.assertEquals(5L, hammingNumber.hamming(5L));
    }

    @Test
    void give6_whenHamming_then6() {
        Assertions.assertEquals(6L, hammingNumber.hamming(6L));
    }

    @Test
    void give7_whenHamming_then8() {
        Assertions.assertEquals(8L, hammingNumber.hamming(7L));
    }

    @Test
    void give159_whenHamming_then5832() {
        Assertions.assertEquals(5832L, hammingNumber.hamming(150L));
    }
}
