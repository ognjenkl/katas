package tdd.wordWrap;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {

    public static final String NEW_LINE_CHARACTER = "\\n";
    public static final String WHITE_SPACE = " ";

    public String wrap(String input, Integer limit) {
        validate(input, limit);
        input = input.trim();
        StringBuilder result = new StringBuilder();
        while (input.length() > limit) {
            List<String> brokenLines = breakLines(input, " ", limit);
            result.append(brokenLines.get(0)).append(NEW_LINE_CHARACTER);
            input = brokenLines.get(1);
        }
        result.append(input);
        return result.toString();
    }

    private List<String> breakLines(String input, String breakingString, Integer limit) {
        int index = input.substring(0, limit + 1).lastIndexOf(breakingString);
        String first = input.substring(0, index);
        String second = input.substring(index + breakingString.length());
        return List.of(first, second);
    }

    private String replaceLastOccurrence(String input, String toReplace, String replacement) {
        int index = input.lastIndexOf(toReplace);
        StringBuilder result = new StringBuilder();
        result.append(input.substring(0, index));
        result.append(replacement);
        result.append(input.substring(index + toReplace.length()));
        return result.toString();
    }

    private void validate(String input, Integer limit) {
        validate(limit);
        validate(input);
    }

    private void validate(String input) {
        if (input == null)
            throw new InputException();
    }

    private static void validate(Integer limit) {
        if (limit == null || limit < 1) {
            throw new LimitException();
        }
    }

    static class LimitException extends RuntimeException {
    }

    static class InputException extends RuntimeException {
    }
}
