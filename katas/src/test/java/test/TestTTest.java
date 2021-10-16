package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTTest {
    @Test
    void test() {
        TestT test = new TestT();
        assertEquals("Hello world", test.get());
    }
}