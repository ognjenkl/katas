package tdd.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
String Calculator

Create a simple String calculator with a method signature:
———————————————
int Add(string numbers)
———————————————
The method can take up to two numbers, separated by commas, and will return their sum.
for example “” or “1” or “1,2” as inputs.
(for an empty string it will return 0)
Hints:
——————
 - Start with the simplest test case of an empty string and move to one and two numbers
 - Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
 - Remember to refactor after each passing test
———————————————————————————————
Allow the Add method to handle an unknown amount of numbers
————————————————————————————————
Allow the Add method to handle new lines between numbers (instead of commas).
the following input is ok: “1\n2,3” (will equal 6)
the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)
——————————————————————————————-
Support different delimiters
to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
the first line is optional. all existing scenarios should still be supported
————————————————————————————————
Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.
if there are multiple negatives, show all of them in the exception message.
————————————————————————————————
STOP HERE if you are a beginner. Continue if you can finish the steps so far in less than 30 minutes.
————————————————————————————————
Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
————————————————————————————————
Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
————————————————————————————————
Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
————————————————————————————————
make sure you can also handle multiple delimiters with length longer than one char
 */
public class StringCalculator {
    public int add(String numbers) throws Exception {
        List<String> delimiterList = new ArrayList<>();
        delimiterList.add(",");

        if (numbers.startsWith("//")) {
            delimiterList = extractDelimiter(numbers);
            numbers = extractNumbersString(numbers);
        }

        List<Integer> parsedNumberList = parseNumbersToList(delimiterList, numbers);
        List<Integer> naturalNumberList = checkForNegativeOrGreaterThan1000Numbers(parsedNumberList);

        return sumNumbers(naturalNumberList);
    }

    private int sumNumbers(List<Integer> numberList) {
        int sum = 0;
        for (int number : numberList)
            sum += number;
        return sum;
    }

    private List<Integer> checkForNegativeOrGreaterThan1000Numbers(List<Integer> numberList) throws Exception {
        List<Integer> negativeNumberList = new ArrayList<>();
        List<Integer> naturalNumberList = new ArrayList<>();

        for (Integer number : numberList)
            if (number < 0)
                negativeNumberList.add(number);
            else if (number > 1000)
                continue;
            else
                naturalNumberList.add(number);

        if (!negativeNumberList.isEmpty())
            throwExceptionWithMessage(negativeNumberList);

        return naturalNumberList;
    }

    private void throwExceptionWithMessage(List<Integer> negativeNumberList) throws Exception {
        StringBuilder message = new StringBuilder("Negatives not allowed");
        negativeNumberList.stream().forEach(number -> message.append(" " + number));
        throw new Exception(message.toString());
    }

    private List<Integer> parseNumbersToList(List<String> delimiterList, String numbers) {
        String delimiter = getDelimiterString(delimiterList);

        String[] numberArray = numbers.split(delimiter);
        List<String> numberList = List.of(numberArray);

        List<Integer> parsedNumbers = !numberList.isEmpty()
                ? numberList.stream().map(s -> s.isEmpty() ? 0 : Integer.parseInt(s)).collect(Collectors.toList())
                : List.of(numbers.isEmpty() ? 0 : Integer.parseInt(numbers));

        return parsedNumbers;
    }

    private String getDelimiterString(List<String> delimiterList) {
        String delimiter = "";
        for (String d : delimiterList)
            delimiter += Pattern.quote(d) + "|";
        delimiter += "\n";

        return delimiter;
    }

    List<String> extractDelimiter(String input) {
        String delimiter = input.split("\n", 2)[0].substring(2);
        return getDelimiterList(delimiter);
    }

    private List<String> getDelimiterList(String delimiter) {
        return delimiter.startsWith("[") ? getDelimiterListByRegex(delimiter) : List.of(delimiter);
    }

    private List<String> getDelimiterListByRegex(String delimiter) {
        List<String> delimiterList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\[([^]]+)\\]").matcher(delimiter);

        while (matcher.find())
            delimiterList.add(matcher.group(1));

        return delimiterList;
    }

    String extractNumbersString(String input) {
        return input.split("\n", 2)[1];
    }
}
