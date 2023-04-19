package tdd.observed.pin;

import java.util.ArrayList;
import java.util.List;

public class ObservedPin {
    public static List<String> getPINs(String observed) {
        return getPINList(observed);
    }

    private static List<String> getPINList(String observed) {
        if (observed.length() == 1) {
            return getPINLengthOne(observed);
        } else if (observed.length() == 2) {
            String[] ob = observed.split("");
            List<String> list = new ArrayList<>();
            for (String first : getPINLengthOne(ob[0])) {
                for (String second : getPINLengthOne(ob[1])) {
                    list.add(first + second);
                }
            }
            return list;
        } else {
            String[] pins = observed.split("");
            System.out.println(List.of(pins));
            return new ArrayList<>();
        }
    }

    private static List<String> getPINLengthOne(String observed) {
        switch (observed) {
            case "1":
                return List.of("1", "2", "4");
            case "2":
                return List.of("1", "2", "3", "5");
            case "3":
                return List.of("2", "6");
            case "4":
                return List.of("1", "4", "5", "7");
            case "5":
                return List.of("2", "4", "5", "6", "8");
            case "6":
                return List.of("3", "5", "9");
            case "7":
                return List.of("4", "8");
            case "8":
                return List.of("5", "7", "9", "0");
            case "9":
                return List.of("6", "8");
            case "0":
                return List.of("8");
        }
        throw new RuntimeException("Not a good observed PIN is entered");
    }
}
