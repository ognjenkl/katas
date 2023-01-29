package tdd.wordWrap;

public class WordWrap {
    public String wrap(String input, Integer limit) {
        validate(limit);
        return input;
    }

    private void validate(Integer limit) {
        if (limit == null || limit < 1) {
            throw new LimitException();
        }
    }

    static class LimitException extends RuntimeException {
    }
}
