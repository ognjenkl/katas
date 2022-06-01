package tdd.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator2Impl implements StringCalculator2 {

    private Integer addCallCount = 0;

    @Override
    public Integer add(String numbers) {
        addCallCount++;
        List<Integer> numberList = parse(numbers);
        return sum(numberList);
    }

    @Override
    public Integer getCalledCount() {
        return addCallCount;
    }

    private List<Integer> parse(String numbers) {
        String delimiterRegex = "," + "|" + "\n";

        if (numbers.startsWith("//")) {
            delimiterRegex = numbers.charAt(2) + "";
            numbers = numbers.substring(4);
        }

        return parseNumbers(numbers, delimiterRegex);
    }

    private Integer sum(List<Integer> numbersList) {
        int sum = 0;
        for (int number : numbersList)
            sum += number;
        return sum;
    }

    private List<Integer> parseNumbers(String numbers, String delimiterRegex) {
        List<Integer> numberList;

        if (numbers.isBlank())
            numberList = new ArrayList<>(DEFAULT_VALUE);
        else {
            numberList = getNumberList(numbers, delimiterRegex);
        }

        List<Integer> negatives = getNegativeNumbers(numberList);
        if (!negatives.isEmpty())
            throw new NegativeNumberException("negatives not allowed: " + negatives);

        numberList = ignoreGreaterThanThousand(numberList);
        return numberList;
    }

    private List<Integer> getNumberList(String numbers, String delimiterRegex) {
        return Arrays.stream(numbers.split(delimiterRegex)).map(Integer::valueOf).collect(Collectors.toList());
    }

    private List<Integer> ignoreGreaterThanThousand(List<Integer> numberList) {
        return numberList.stream().filter(n -> n <= 1000).collect(Collectors.toList());
    }

    private List<Integer> getNegativeNumbers(List<Integer> numberList) {
        return numberList.stream().filter(n -> n < 0).collect(Collectors.toList());
    }


    class NegativeNumberException extends RuntimeException {
        NegativeNumberException(String message) {
            super(message);
        }
    }
}
