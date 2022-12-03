package tdd.best.travel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class BestTravelTest {

    BestTravel bestTravel;
    private Integer[] ls;

    @BeforeEach
    void setUp() {
        bestTravel = new BestTravel();
    }

    @Test
    void shouldReturn163() {
        ls = new Integer[]{50, 55, 56, 57, 58};
        assertEquals(163, bestTravel.chooseBestSum(163, 3, ls));
    }

    @Test
    void shouldReturnNull() {
        ls = new Integer[]{50};
        assertNull(bestTravel.chooseBestSum(163, 3, ls));
    }

    @Test
    void shouldReturn228() {
        ls = new Integer[]{91, 74, 73, 85, 73, 81, 87};
        assertEquals(228, bestTravel.chooseBestSum(230, 3, ls));
    }

    @Test
    void shouldChooseBestSumFromAllDistances() {
        Map<Integer, List<Integer>> distancesMap = new HashMap<>();
        distancesMap.put(10, List.of(2, 5, 3));
        distancesMap.put(15, List.of(7, 5, 3));
        distancesMap.put(12, List.of(7, 5, 8));

        Integer distance = bestTravel.chooseBestSumOfAllSums(16, distancesMap);

        assertEquals(15, distance);
    }

    @Test
    void shouldReturnMapWithDistancesAndTuplesBasedOnTuplesList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(5);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(5);
        list2.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        Map<Integer, List<Integer>> distancesMap = bestTravel.getMapWithDistancesAndTuples(list);

        assertEquals(2, distancesMap.get(10).get(0));
        assertEquals(5, distancesMap.get(10).get(1));
        assertEquals(3, distancesMap.get(10).get(2));
    }

    @Test
    void shouldReturnListOfAllTuplesFromListOfCityDistances() {
        List<Integer> cityDistances = List.of(1, 2, 3, 4);

        List<List<Integer>> listOfDistances = bestTravel.getTuples(3, cityDistances);

        assertEquals(24, listOfDistances.size());
        assertEquals(3, listOfDistances.get(0).size());
        assertEquals(3, listOfDistances.get(5).size());
        assertEquals(3, listOfDistances.get(23).size());
    }

    @Test
    void shouldReturnListOfAllTuplesOfOneFromListOfOneCityDistances() {
        List<Integer> cityDistances = List.of(1);

        List<List<Integer>> listOfDistances = bestTravel.getTuples(1, cityDistances);

        assertEquals(1, listOfDistances.size());
        assertEquals(1, listOfDistances.get(0).size());
    }

    @Test
    void shouldReturnListOfAllTuplesOfOneFromListOfTwoCityDistances() {
        List<Integer> cityDistances = List.of(1, 2);

        List<List<Integer>> listOfDistances = bestTravel.getTuples(1, cityDistances);

        assertEquals(2, listOfDistances.size());
        assertEquals(1, listOfDistances.get(0).size());
        assertEquals(1, listOfDistances.get(1).size());
    }

    @Test
    void shouldReturnListOfAllTuplesOfTwoFromListOfTwoCityDistances() {
        List<Integer> cityDistances = List.of(1, 2);

        List<List<Integer>> listOfDistances = bestTravel.getTuples(2, cityDistances);

        assertEquals(1, listOfDistances.size());
        assertEquals(2, listOfDistances.get(0).size());
    }
}