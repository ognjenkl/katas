package tdd.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void whenEmpty_thenTrueTest() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void whenPush_thenReturnElementTest() {
        assertEquals(5, stack.push(5));
    }

    @Test
    void givenEmpty_whenPop_thenExceptionTest() {
        assertThrows(Stack.UnderflowException.class, () -> stack.pop());
    }

    @Test
    void whenPustAndPop_thenStackIsEmptyTest() {
        stack.push(6);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void when1PustAnd2Pop_thenThrowUnderflowException() {
        stack.push(6);
        stack.pop();
        assertThrows(Stack.UnderflowException.class, () -> stack.pop());
    }

    @Test
    void when1PushAnd1Pop_thenReturnPushedValueTest() {
        int value = 7;
        stack.push(value);
        assertEquals(value, stack.pop());
    }

    @Test
    void whenPushPopPushPop_thenIsEmptyTest() {
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void when2Push2PopP_thenIsEmptyTest() {
        stack.push(2);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void when3Push3Pop_thenIsEmptyTest() {
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertEquals(15, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
