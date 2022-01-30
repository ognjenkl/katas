package tdd.romanNumeralsHelper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

Roman Numerals Helper
Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Input range : 1 <= n < 4000

In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").

Examples
RomanNumerals.toRoman(1000) // should return 'M'
RomanNumerals.fromRoman("M") // should return 1000
Help
Symbol	Value
I	1
IV	4
V	5
X	10
L	50
C	100
D	500
M	1000
 */
public class RomanNumerals {

    public String toRoman(int number) throws Exception {
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
        String romanNumber = "";

        if (number < 4)
            romanNumber = upToThreeOnesRomanBuilder(one, number);
        else if (number == 4)
            romanNumber = one + five;
        else if (number == 5)
            romanNumber = five;
        else if (number < 9)
            romanNumber = five + upToThreeOnesRomanBuilder(one, number - 5);
        else if (number == 9)
            romanNumber = one + ten;

        return romanNumber;
    }

    private String upToThreeOnesRomanBuilder(String one, int repeatCount) {
        return IntStream
                .range(0, repeatCount)
                .mapToObj(i -> one)
                .collect(Collectors.joining());
    }

    public int fromRoman(String roman) {

        int number = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        StringBuilder sb = new StringBuilder(roman);

        for(int i = 0; i < sb.length(); i++) {
            if (i + 1 <= sb.length() - 1 && map.get(sb.charAt(i + 1)) > map.get(sb.charAt(i))) {
                number += map.get(sb.charAt(i + 1)) - map.get(sb.charAt(i));
                i++;
            } else
                number += map.get(sb.charAt(i));
        }

        return number;
    }
}
