package tdd.configureWardrobe;

import java.util.*;

public class ConfigureWardrobe {

    private final int wallSize = 250;

    public Set<List<Integer>> getCombinationsOfElementsThatExactlyFillTheWallSize(List<Integer> elementList) {
        Set<List<Integer>> resultSet = new HashSet<>();

        if (elementList == null || elementList.size() == 0)
            return resultSet;

        int maxNumberOfElements = maxNumberOfElements(elementList);
        for (int i = 1; i <= maxNumberOfElements; i++)
            resultSet.addAll(getAllCombinations(elementList, i));
        Set<List<Integer>> copyOfResultList = new HashSet<>(resultSet);
        for (List<Integer> combination : copyOfResultList)
            if (combinationSum(combination) != wallSize)
                resultSet.remove(combination);
        return resultSet;
    }

    private int combinationSum(List<Integer> combination) {
        int sum = 0;
        for (Integer element : combination)
            sum += element;
        return sum;
    }

    public int maxNumberOfElements(List<Integer> elementList) {
        if (elementList == null)
            return 0;

        int minElement = Collections.min(elementList);

        int counter = 0;
        int sum = minElement;
        while (sum <= wallSize) {
            counter++;
            sum += minElement;
        }

        return counter;
    }

    public Set<List<Integer>> getAllCombinations(List<Integer> elementList, int combinationLength) {
        Set<List<Integer>> combinationSet = new HashSet<>();
        Integer[] combination = new Integer[combinationLength];

        generateCombinationsRecursively(elementList, combinationSet, combination, 0);

        System.out.println();
        System.out.println(combinationSet);
        return combinationSet;
    }

    private void generateCombinationsRecursively(
            List<Integer> elementList, Set<List<Integer>> combinationSet, Integer[] combination, int position) {

        if (position == combination.length) {
            System.out.println(Arrays.asList(combination));
            List<Integer> list = new ArrayList<>(Arrays.asList(combination));
            Collections.sort(list);
            combinationSet.add(list);
            return;
        }

        for (int i = 0; i < elementList.size(); i++) {
            combination[position] = elementList.get(i);
            generateCombinationsRecursively(elementList, combinationSet, combination, position + 1);
        }
    }
}
