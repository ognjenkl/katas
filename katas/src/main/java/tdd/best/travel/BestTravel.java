package tdd.best.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BestTravel {
    public Integer chooseBestSum(Integer t, Integer k, Integer[] ls) {
        if (ls.length < k)
            return null;
        Map<Integer, List<Integer>> allTravelMap = getAllTravelsMap(k, ls);
        return 163;
    }

    Map<Integer, List<Integer>> getAllTravelsMap(Integer k, Integer[] ls) {
        List<List<Integer>> tupleList = getAllTuples(k, ls);
        return null;
    }

    private List<List<Integer>> getAllTuples(Integer k, Integer[] ls) {
        return null;
    }

    public Integer chooseBestSumOfAllSums(int t, Map<Integer, List<Integer>> distancesMap) {
        return null;
    }

    public Map<Integer, List<Integer>> getMapWithDistancesAndTuples(List<List<Integer>> list) {
        return null;
    }

    public List<List<Integer>> getTuples(Integer k, List<Integer> cityDistances) {
        List list = new ArrayList();
//        Integer index = 0;
//        for (int i = 0; i < cityDistances.size(); i++) {
//            populateTuple(k, 0, i, list, cityDistances, null);
//        }
        populateTuple(k, 0, 0, list, cityDistances, null);
        return list;
    }

    private void populateTuple(Integer k, Integer index, int iterator,
                                        List<List<Integer>> listToReturn, List<Integer> cityDistances,
                                        List<Integer> tuple) {
        if (index == k) {
//            tuple = new ArrayList<>();
            listToReturn.add(tuple);
            return;
        }

//        for (int i = iterator; i < cityDistances.size(); ) {
        for (int i = iterator; i < cityDistances.size(); i++) {
            Integer distance = cityDistances.get(i);
            tuple = new ArrayList<>();
            tuple.add(distance);
//            index++;
            populateTuple(k, index + 1, i + 1, listToReturn, cityDistances, tuple);
//            tuple = populateTuple(k, index + 1, ++i, listToReturn, cityDistances, tuple);
//            tuple.add(distance);
//            return tuple;
        }
//        return null;
    }

}
