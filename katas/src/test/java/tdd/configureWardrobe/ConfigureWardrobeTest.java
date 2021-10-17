package tdd.configureWardrobe;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigureWardrobeTest {

    private final ConfigureWardrobe configureWardrobe = new ConfigureWardrobe();

    @Test
    void fillExactlyEmptyTest() {
        List<Integer> elementList = new ArrayList<>();

        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);
        assertEquals(0, resultSet.size());
    }

    @Test
    void fillExactlyOneElement50Test() {
        int element = 50;
        List<Integer> elementList = List.of(element);

        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        Set<List<Integer>> expectedSet = new HashSet<>();
        expectedSet.add(List.of(element, element, element, element, element));

        assertNotNull(resultSet);
        assertEquals(expectedSet, resultSet);
    }

    @Test
    void fillExactlyOneElement75Test() {
        int element = 75;
        List<Integer> elementList = List.of(element);
        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertEquals(0, resultSet.size());
    }

    @Test
    void fillExactlyOneElement100Test() {
        int element = 100;
        List<Integer> elementList = List.of(element);
        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertEquals(0, resultSet.size());
    }

    @Test
    void fillExactlyOneElement120Test() {
        int element = 120;
        List<Integer> elementList = List.of(element);
        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertEquals(0, resultSet.size());
    }

    @Test
    void maxNumberOfElementsZeroTest() {
        assertEquals(0, configureWardrobe.maxNumberOfElements(null));
    }

    @Test
    void maxNumberOfElements50Test() {
        int element = 50;
        List<Integer> elementList = List.of(element);

        assertEquals(5, configureWardrobe.maxNumberOfElements(elementList));
    }

    @Test
    void maxNumberOfElements5Test() {
        int element = 5;
        List<Integer> elementList = List.of(element);

        assertEquals(50, configureWardrobe.maxNumberOfElements(elementList));
    }

    @Test
    void maxNumberOfElements75Test() {
        int element = 75;
        List<Integer> elementList = List.of(element);

        assertEquals(3, configureWardrobe.maxNumberOfElements(elementList));
    }

    @Test
    void maxNumberOfElements100Test() {
        int element = 100;
        List<Integer> elementList = List.of(element);

        assertEquals(2, configureWardrobe.maxNumberOfElements(elementList));
    }

    @Test
    void maxNumberOfElements120Test() {
        int element = 120;
        List<Integer> elementList = List.of(element);

        assertEquals(2, configureWardrobe.maxNumberOfElements(elementList));
    }

    @Test
    void allCombinationsWithOneElementLengthOne() {
        List<Integer> elementList = List.of(50);
        Set<List<Integer>> resultSet = configureWardrobe.getAllCombinations(elementList, 1);

        assertEquals(1, resultSet.size());
        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(List.of(50), it.next());
    }

    @Test
    void allCombinationsWithOneElementLengthTwo() {
        List<Integer> elementList = List.of(50);
        Set<List<Integer>> resultSet = configureWardrobe.getAllCombinations(elementList, 2);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(1, resultSet.size());
        assertEquals(List.of(50, 50), it.next());
    }

    @Test
    void allCombinationsWithOneElementLengthFive() {
        List<Integer> elementList = List.of(50);
        Set<List<Integer>> resultSet = configureWardrobe.getAllCombinations(elementList, 5);
        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(1, resultSet.size());
        assertEquals(List.of(50, 50, 50, 50, 50), it.next());
    }

    @Test
    void allCombinationsWithTwoElementsLengthOne() {
        List<Integer> elementList = List.of(50, 75);
        Set<List<Integer>> resultSet = configureWardrobe.getAllCombinations(elementList, 1);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(2, resultSet.size());
        assertEquals(List.of(50), it.next());
        assertEquals(List.of(75), it.next());
    }

    @Test
    void allCombinationsWithTwoElementsLengthTwo() {
        List<Integer> elementList = List.of(50, 75);
        int combinationLength = 2;
        Set<List<Integer>> resultSet =
                configureWardrobe.getAllCombinations(elementList, combinationLength);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(3, resultSet.size());
        assertEquals(List.of(50, 50), it.next());
        assertEquals(List.of(75, 75), it.next());
        assertEquals(List.of(50, 75), it.next());
    }

    @Test
    void allCombinationsWithTwoElementsLengthThree() {
        List<Integer> elementList = List.of(50, 75);
        int combinationLength = 3;
        Set<List<Integer>> resultSet =
                configureWardrobe.getAllCombinations(elementList, combinationLength);
        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(4, resultSet.size());

        assertEquals(List.of(50, 50, 50), it.next());
        assertEquals(List.of(50, 75, 75), it.next());
        assertEquals(List.of(50, 50, 75), it.next());
        assertEquals(List.of(75, 75, 75), it.next());
    }

    @Test
    void allCombinationsWithThreeElementsLengthTwo() {
        List<Integer> elementList = List.of(50, 75, 100);
        int combinationLength = 2;
        Set<List<Integer>> resultSet =
                configureWardrobe.getAllCombinations(elementList, combinationLength);
        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(6, resultSet.size());

        assertEquals(List.of(50, 50), it.next());
        assertEquals(List.of(75, 75), it.next());
        assertEquals(List.of(100, 100), it.next());
        assertEquals(List.of(50, 100), it.next());
        assertEquals(List.of(50, 75), it.next());
        assertEquals(List.of(75, 100), it.next());
    }

    @Test
    void allCombinationsWithFourElementsLengthTwo() {
        List<Integer> elementList = List.of(50, 75, 100, 120);
        int combinationLength = 2;
        Set<List<Integer>> resultSet =
                configureWardrobe.getAllCombinations(elementList, combinationLength);
        Iterator<List<Integer>> it = resultSet.iterator();


        assertEquals(10, resultSet.size());

        assertEquals(List.of(50, 50), it.next());
        assertEquals(List.of(75, 75), it.next());
        assertEquals(List.of(100, 100), it.next());
        assertEquals(List.of(120, 120), it.next());
        assertEquals(List.of(50, 100), it.next());
        assertEquals(List.of(100, 120), it.next());
        assertEquals(List.of(50, 120), it.next());
        assertEquals(List.of(50, 75), it.next());
        assertEquals(List.of(75, 100), it.next());
        assertEquals(List.of(75, 120), it.next());
    }

    @Test
    void allCombinationsWithTwoElementsAndLengthThreeBinary() {
        List<Integer> elementList = List.of(0, 1);
        int combinationLength = 3;

        Set<List<Integer>> resultSet =
                configureWardrobe.getAllCombinations(elementList, combinationLength);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(4, resultSet.size());
        assertEquals(List.of(0, 0, 1), it.next());
        assertEquals(List.of(1, 1, 1), it.next());
        assertEquals(List.of(0, 0, 0), it.next());
        assertEquals(List.of(0, 1, 1), it.next());
    }

    @Test
    void testSet() {
        Set<List<Integer>> resultSet = new HashSet<>();
        resultSet.add(new ArrayList<>(Arrays.asList(50, 50, 75, 75)));
        resultSet.add(new ArrayList<>(Arrays.asList(50, 50, 75, 75)));
        List<Integer> list = Arrays.asList(75, 50, 75, 50);
        Collections.sort(list);
        resultSet.add(new ArrayList<>(list));

        System.out.println(resultSet);
    }

    @Test
    void fillExactlyTwoElementTest() {
        List<Integer> elementList = List.of(50, 75);

        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertNotNull(resultSet);
        for (List<Integer> list : resultSet)
            System.out.println(list);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(List.of(50, 50, 75, 75), it.next());
        assertEquals(List.of(50, 50, 50, 50, 50), it.next());
    }

    @Test
    void fillExactlyThreeElementTest() {
        List<Integer> elementList = List.of(50, 75, 100);

        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertNotNull(resultSet);
        for (List<Integer> list : resultSet)
            System.out.println(list);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(5, resultSet.size());

        assertEquals(List.of(50, 50, 75, 75), it.next());
        assertEquals(List.of(50, 100, 100), it.next());
        assertEquals(List.of(50, 50, 50, 100), it.next());
        assertEquals(List.of(50, 50, 50, 50, 50), it.next());
        assertEquals(List.of(75, 75, 100), it.next());
    }

    @Test
    void fillExactlyFourElementTest() {
        List<Integer> elementList = List.of(50, 75, 100, 120);

        Set<List<Integer>> resultSet = configureWardrobe.getCombinationsOfElementsThatExactlyFillTheWallSize(elementList);

        assertNotNull(resultSet);
        for (List<Integer> list : resultSet)
            System.out.println(list);

        Iterator<List<Integer>> it = resultSet.iterator();

        assertEquals(5, resultSet.size());

        assertEquals(List.of(50, 50, 75, 75), it.next());
        assertEquals(List.of(50, 50, 50, 100), it.next());
        assertEquals(List.of(75, 75, 100), it.next());
        assertEquals(List.of(50, 100, 100), it.next());
        assertEquals(List.of(50, 50, 50, 50, 50), it.next());
    }
}
