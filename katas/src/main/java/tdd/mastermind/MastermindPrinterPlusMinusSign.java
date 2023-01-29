package tdd.mastermind;

import java.util.List;

public class MastermindPrinterPlusMinusSign implements MastermindPrinter {

    @Override
    public String print(String guess, List<Integer> result) {
        String retVal =  guess + "\n" + resultToString(result);
        System.out.println(retVal);
        return retVal;
    }

    @Override
    public String printResult(List<Integer> result) {
        String retVal = resultToString(result);
        System.out.println(retVal);
        return retVal;
    }

    private String resultToString(List<Integer> result) {
        return "+".repeat(Math.max(0, result.get(0)))
                + "-".repeat(Math.max(0, result.get(1)));
    }
}
