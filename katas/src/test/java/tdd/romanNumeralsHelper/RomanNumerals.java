package tdd.romanNumeralsHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumerals {
    public String intToRoman(int number) throws Exception {
        if (number < 1 || number >= 4000)
            throw new Exception("Number not in range 1 to 3999");

        List<String> romanNumberList = new ArrayList<>();

        String[] one = {"I", "X", "C", "M"};
        String[] five = {"V", "L", "D", ":)"};
        String[] ten = {"X", "C", "M", ":)"};

        int divide = number;
        for (int i = 0; divide != 0; i++) {
            romanNumberList.add(oneCharacterIntToRoman(divide % 10, one[i], five[i], ten[i]));
            divide /= 10;
        }

        Collections.reverse(romanNumberList);
        return String.join("", romanNumberList);
    }

    private String oneCharacterIntToRoman(int number, String one, String five, String ten) {
        String romanNumber;

        romanNumber = upToThreeOnesRomanBuilder(one, number);

        if (number == 4)
            romanNumber = one + five;

        if (number == 5)
            romanNumber = five;

        if (number > 5) {
            romanNumber = five + upToThreeOnesRomanBuilder(one, number - 5);
        }

        if (number == 9)
            romanNumber = one + ten;

        if (number == 10)
            romanNumber = ten;

        return romanNumber;
    }

    private String upToThreeOnesRomanBuilder(String one, int repeatCount) {
        return IntStream
                .range(0, repeatCount)
                .mapToObj(i -> one)
                .collect(Collectors.joining());
    }
}
