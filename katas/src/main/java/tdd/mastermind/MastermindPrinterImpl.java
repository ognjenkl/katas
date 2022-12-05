package tdd.mastermind;

import java.util.List;

public class MastermindPrinterImpl implements MastermindPrinter {

    @Override
    public String print(String guess, List<Integer> result) {
        return guess + "\n" + resultToString(result);
    }

    private String resultToString(List<Integer> result) {
        return "+".repeat(Math.max(0, result.get(0)))
                + "-".repeat(Math.max(0, result.get(1)));
    }
}
