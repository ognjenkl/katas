package tdd.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator2Impl implements StringCalculator2 {

    private Integer countAddMethodCalls = 0;

    @Override
    public Integer add(String numbers) {
        countAddMethodCalls++;
        List<Integer> numberList = parse(numbers);
        return sum(numberList);
    }

    @Override
    public Integer getCalledCount() {
        return countAddMethodCalls;
    }

    private List<Integer> parse(String numbers) {
        String commaDelimiter = ",";
        String newLineDelimiter = "\n";
        String delimiterRegex = commaDelimiter + "|" + newLineDelimiter;

        if (numbers.startsWith("//")) {
            String[] numbersArray = splitNumbers(numbers.substring(2), newLineDelimiter);
            delimiterRegex = Pattern.quote(parseDelimiter(numbersArray[0]));
            numbers = numbersArray[1];
        }

        return parseNumbers(numbers, delimiterRegex);
    }

    private String parseDelimiter(String input) {
        if (input.contains("["))
            return input.substring(1, input.length() - 1);
        else
            return input;
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
        else
            numberList = getNumberList(numbers, delimiterRegex);

        precessNegativeNumbers(numberList);

        numberList = ignoreNumbersGreaterThanThousand(numberList);
        return numberList;
    }

    private void precessNegativeNumbers(List<Integer> numberList) {
        List<Integer> negatives = getNegativeNumbers(numberList);
        if (!negatives.isEmpty())
            throw new NegativeNumberException("negatives not allowed: " + negatives);
    }

    private List<Integer> getNumberList(String numbers, String delimiterRegex) {
        String[] numbersArray = splitNumbers(numbers, delimiterRegex);
        return Arrays.stream(numbersArray).map(Integer::valueOf).collect(Collectors.toList());
    }

    private String[] splitNumbers(String numbers, String delimiterRegex) {
        return numbers.split(delimiterRegex);
    }

    private List<Integer> ignoreNumbersGreaterThanThousand(List<Integer> numberList) {
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
