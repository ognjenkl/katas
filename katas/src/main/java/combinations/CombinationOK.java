package combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationOK {
    public List<List<Integer>> getAllCombinations(List<Integer> elementList,
                                                  int combinationLength) {
        List<List<Integer>> combinationList = new ArrayList<>();
        Integer[] combination = new Integer[combinationLength];

        generateCombinationsRecursively(elementList, combinationList, combination, 0);

        System.out.println();
        System.out.println(combinationList);
        return combinationList;
    }

    /**
     *
     * Magic is done in this recursive method <code>generateCombinationsRecursively</code>.
     *
     * Parameter <code>position</code> is variable, depending on how deep recursive function goes.
     * Max value for <code>position</code> parameter is the <code>combination</code> list size (k).
     * If the max value (k) is reached (first block of the method <code>generateCombinationsRecursively</code>),
     * new <code>combination</code> is added to the resulting <code>combinationList</code> list and recursion finishes.
     *
     * Second block of the method <code>generateCombinationsRecursively</code> is the <code>for</code> loop
     * which iterates throughout all elements in the list <code>elementList</code>.
     * Depending on <code>position</code> value, <code>combination</code> list is populated with element
     * from <code>elementList</code> (T). Then the recursive method <code>generateCombinationsRecursively</code>
     * is called with accent on the <code>position</code> argument, which is incremented so it points to the
     * next position in the <code>combination</code>, that recursive method will populate.
     *
     * @param elementList elements that combinations are made of (T)
     * @param combinationList is resulting list of combinations as a result of recursive method
     * @param combination is array of elements, single combination with variable length (k)
     * @param position of one element from the list <code>elementList</code> in the <code>combination</code> array
     *
     */
    private void generateCombinationsRecursively(List<Integer> elementList,
                                                 List<List<Integer>> combinationList,
                                                 Integer[] combination,
                                                 int position) {
        if (position == combination.length) {
            System.out.println(Arrays.asList(combination));
            combinationList.add(new ArrayList<>(Arrays.asList(combination)));
            return;
        }

        for (int i = 0; i < elementList.size(); i++) {
            combination[position] = elementList.get(i);
            generateCombinationsRecursively(
                    elementList, combinationList, combination, position + 1);
        }
    }
}
