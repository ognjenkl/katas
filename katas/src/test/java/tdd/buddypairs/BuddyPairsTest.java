package tdd.buddypairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuddyPairsTest {


    BuddyPairs buddyPairs;
    List<Integer> divisorList;

    @BeforeEach
    void setUp() {
        buddyPairs = new BuddyPairs();
        divisorList = new ArrayList<>();

    }

    @Test
    void getProperDivisors_oneArgument2Test() {
        divisorList.add(1);
        for (int i = 0; i < divisorList.size(); i++)
            assertEquals(divisorList.get(0), buddyPairs.getPropperDivisors(2).get(i));
    }

    @Test
    void getProperDivisors_oneArgument3Test() {
        divisorList.add(1);
        for (int i = 0; i < divisorList.size(); i++)
            assertEquals(divisorList.get(0), buddyPairs.getPropperDivisors(3).get(i));
    }

    @Test
    void getProperDivisors_oneArgument4Test() {
        divisorList.add(1);
        divisorList.add(2);
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(4);
        for (int i = 0; i < divisorList.size(); i++)
            assertEquals(divisorList.get(i), divisorsGot.get(i));
    }

    @Test
    void getProperDivisors_argument25Test() {
        divisorList.add(1);
        divisorList.add(5);
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(25);
        for (int i = 0; i < divisorList.size(); i++)
            assertEquals(divisorList.get(i), divisorsGot.get(i));
    }

    @Test
    void getProperDivisors_75Test() {
        divisorList.add(1);
        divisorList.add(3);
        divisorList.add(5);
        divisorList.add(15);
        divisorList.add(25);
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(75);
        for (int i = 0; i < divisorsGot.size(); i++)
            System.out.println(divisorsGot.get(i));
        for (int i = 0; i < divisorList.size(); i++) {
            assertEquals(divisorList.get(i), divisorsGot.get(i));
        }
    }

    @Test
    void sumProperDivisorsOf4Test() {
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(4);
        Integer sum = buddyPairs.sumProperDivisors(divisorsGot);
        assertEquals(3, sum);
    }

    @Test
    void sumProperDivisorsOf25Test() {
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(25);
        Integer sum = buddyPairs.sumProperDivisors(divisorsGot);
        assertEquals(6, sum);
    }

    @Test
    void sumProperDivisorsOf75Test() {
        List<Integer> divisorsGot = buddyPairs.getPropperDivisors(75);
        for(Integer num : divisorsGot)
            System.out.println(num);
        Integer sum = buddyPairs.sumProperDivisors(divisorsGot);
        assertEquals(49, sum);
    }


}
