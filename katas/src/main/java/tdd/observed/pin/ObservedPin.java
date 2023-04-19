package tdd.observed.pin;

import java.util.ArrayList;
import java.util.List;

public class ObservedPin {
    public static List<String> getPINs(String observed) {
        List<String> list = new ArrayList<>();
        getPINList(observed, "", list);
        return list;
    }

    private static void getPINList(String observed, String prefix, List<String> list) {
        if (observed.length() == 0) {
            list.add(prefix);
        } else {
            String first = observed.substring(0, 1);
            String rest = observed.substring(1);

            for (String firstPIN : getPINLengthOne(first)) {
                getPINList(rest, prefix + firstPIN, list);
            }
        }
    }

    private static List<String> getPINLengthOne(String observed) {
        switch (observed) {
            case "1":
                return List.of("1", "2", "4");
            case "2":
                return List.of("1", "2", "3", "5");
            case "3":
                return List.of("2", "3", "6");
            case "4":
                return List.of("1", "4", "5", "7");
            case "5":
                return List.of("2", "4", "5", "6", "8");
            case "6":
                return List.of("3", "5", "6", "9");
            case "7":
                return List.of("4", "7", "8");
            case "8":
                return List.of("5", "7", "8", "9", "0");
            case "9":
                return List.of("6", "8", "9");
            case "0":
                return List.of("8", "0");
        }
        throw new RuntimeException("Not a good observed PIN is entered");
    }
}
