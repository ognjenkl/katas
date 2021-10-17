package combinations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationOKTest {

    CombinationOK combinationOK;

    @BeforeEach
    void setUp() {
        combinationOK = new CombinationOK();
    }

    @Test
    void allCombinationsWithTwoElementsAndLengthThreeBinary() {
        List<Integer> elementList = List.of(0, 1);
        int combinationLength = 3;

        List<List<Integer>> combinationList =
                combinationOK.getAllCombinations(elementList, combinationLength);

        assertEquals(8, combinationList.size());
        assertEquals(List.of(
                        List.of(0, 0, 0),
                        List.of(0, 0, 1),
                        List.of(0, 1, 0),
                        List.of(0, 1, 1),
                        List.of(1, 0, 0),
                        List.of(1, 0, 1),
                        List.of(1, 1, 0),
                        List.of(1, 1, 1)),
                combinationList);
    }
}
