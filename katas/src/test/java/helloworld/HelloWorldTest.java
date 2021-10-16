package helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {
    @Test
    void helloWorldTest() {
        HelloWorld test = new HelloWorld();
        assertEquals("Hello world", test.get());
    }
}