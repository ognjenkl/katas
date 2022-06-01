package tdd.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator2Impl implements StringCalculator2 {

    @Override
    public Integer add(String numbers) {
        Integer retVal = DEFAULT_VALUE;
        String delimiterComma = ",";
        String delimiterNewLine = "\n";
        String delimiterRegex = getDelimiterRegex(delimiterComma, delimiterNewLine);

        boolean containsDelimiters = containsDelimiters(numbers, delimiterComma, delimiterNewLine);
        if (containsDelimiters) {
            List<Integer> numbersList = parseNumbers(numbers, delimiterRegex);
            retVal = sum(numbersList);
        } else if (numbers.isBlank()) {
            retVal = DEFAULT_VALUE;
        } else
            retVal = Integer.valueOf(numbers);

        return retVal;
    }

    private Integer sum(List<Integer> numbersList) {
        int sum = 0;
        for (int number : numbersList)
            sum += number;
        return sum;
    }

    private List<Integer> parseNumbers(String numbers, String delimiterRegex) {
        List<Integer> numberList = new ArrayList<>();
        Arrays.stream(numbers.split(delimiterRegex)).forEach(n -> numberList.add(Integer.valueOf(n)));
        return numberList;
    }

    private boolean containsDelimiters(String numbers, String delimiterComma, String delimiterNewLine) {
        return numbers.contains(delimiterComma) | numbers.contains(delimiterNewLine);
    }

    private String getDelimiterRegex(String delimiterComma, String delimiterNewLine) {
        return delimiterComma + "|" + delimiterNewLine;
    }
}
