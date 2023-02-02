package tdd.wordWrap;

public class WordWrap {

    public static final String NEW_LINE_CHARACTER = "\\n";
    public static final String WHITE_SPACE = " ";

    public String wrap(String input, Integer limit) {
        validate(input, limit);
        input = input.trim();
        StringBuilder result = new StringBuilder();
        while (input.length() > limit) {
            String firstLineWithNewLine =
                    getFirstLineWithAppendedNewLineCharacter(input, limit);
            result.append(firstLineWithNewLine);
            input = getTheRestOfInputForFurtherProcessing(input, limit);
        }
        result.append(input);
        return result.toString();
    }

    private String getTheRestOfInputForFurtherProcessing(String input, Integer limit) {
        int breakPointIndex = getBreakPointIndex(input, limit);
        if (WHITE_SPACE.equals("" + input.charAt(breakPointIndex))) {
            return input.substring(breakPointIndex + WHITE_SPACE.length());
        } else {
            return input.substring(breakPointIndex);
        }
    }

    private String getFirstLineWithAppendedNewLineCharacter(String input, Integer limit) {
        int breakPointIndex = getBreakPointIndex(input, limit);
        return input.substring(0, breakPointIndex) + NEW_LINE_CHARACTER;
    }

    private int getBreakPointIndex(String input, Integer limit) {
        String potentialFirstLine = input.substring(0, limit + 1);
        if (potentialFirstLine.contains(WHITE_SPACE)) {
            return getIndexOfLastSpaceOccurrence(potentialFirstLine, limit);
        } else {
            return limit;
        }
    }

    private static int getIndexOfLastSpaceOccurrence(String input, Integer limit) {
        return input.substring(0, limit + 1).lastIndexOf(WHITE_SPACE);
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
