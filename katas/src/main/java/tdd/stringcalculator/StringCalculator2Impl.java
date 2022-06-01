package tdd.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator2Impl implements StringCalculator2 {

    @Override
    public Integer add(String numbers) {
        List<Integer> numberList = parse(numbers);
        return sum(numberList);
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
        List<Integer> numberList = new ArrayList<>();
        if (numbers.isBlank())
            numberList.add(DEFAULT_VALUE);
        else
            Arrays.stream(numbers.split(delimiterRegex)).forEach(n -> numberList.add(Integer.valueOf(n)));
        return numberList;
    }
}
