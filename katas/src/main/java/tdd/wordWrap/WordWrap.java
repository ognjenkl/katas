package tdd.wordWrap;

public class WordWrap {
    public String wrap(String input, Integer limit) {
        validate(input, limit);
        String result = input.trim();
        if (result.contains(" "))
            result = result.replace(" ", "\\n");
        return result;
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
