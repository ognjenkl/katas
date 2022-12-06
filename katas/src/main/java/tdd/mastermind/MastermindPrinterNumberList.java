package tdd.mastermind;

import java.util.List;

public class MastermindPrinterNumberList implements MastermindPrinter {

    @Override
    public String print(String guess, List<Integer> result) {
        String retVal = guess + "\n" + resultToString(result);
        System.out.println(retVal);
        return retVal;
    }

    private String resultToString(List<Integer> result) {
        return "[" + result.get(0) + "," + result.get(1) + "]";
    }
}
