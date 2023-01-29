package tdd.mastermind;

import java.util.List;

public interface MastermindPrinter {
    String print(String guess, List<Integer> result);

    String printResult(List<Integer> result);
}
