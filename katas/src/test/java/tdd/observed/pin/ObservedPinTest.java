package tdd.observed.pin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

/*
Alright, detective, one of our colleagues successfully observed
our target person, Robby the robber. We followed him to a secret warehouse,
where we assume to find all the stolen stuff.
The door to this warehouse is secured by an electronic combination lock.
Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.

The keypad has the following layout:

┌───┬───┬───┐
│ 1 │ 2 │ 3 │
├───┼───┼───┤
│ 4 │ 5 │ 6 │
├───┼───┼───┤
│ 7 │ 8 │ 9 │
└───┼───┼───┘
    │ 0 │
    └───┘
He noted the PIN 1357, but he also said, it is possible that each of
the digits he saw could actually be another adjacent digit
(horizontally or vertically, but not diagonally).
E.g. instead of the 1 it could also be the 2 or 4.
And instead of the 5 it could also be the 2, 4, 6 or 8.

He also mentioned, he knows this kind of locks.
You can enter an unlimited amount of wrong PINs,
they never finally lock the system or sound the alarm.
That's why we can try out all possible (*) variations.

* possible in sense of: the observed PIN itself and all variations
considering the adjacent digits

Can you help us to find all those variations?
It would be nice to have a function, that returns an array
(or a list in Java/Kotlin and C#) of all variations for an
observed PIN with a length of 1 to 8 digits.
We could name the function getPINs (get_pins in python, GetPINs in C#).
But please note that all PINs, the observed one and also the results,
must be strings, because of potentially leading '0's.
We already prepared some test cases for you.

Detective, we are counting on you!
 */
public class ObservedPinTest {

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of("1", List.of("1", "2", "4")),
            Arguments.of("2", List.of("1", "2", "3", "5")),
            Arguments.of("3", List.of("2", "6")),
            Arguments.of("4", List.of("1", "4", "5", "7")),
            Arguments.of("5", List.of("2", "4", "5", "6", "8")),
            Arguments.of("6", List.of("3", "5", "9")),
            Arguments.of("7", List.of("4", "8")),
            Arguments.of("8", List.of("5", "7", "9", "0")),
            Arguments.of("9", List.of("6", "8")),
            Arguments.of("0", List.of("8")),
            Arguments.of("11", List.of("11", "12", "14", "21", "22", "24", "41", "42", "44"))
    );

    @ParameterizedTest
    @VariableSource("arguments")
    void givenOnePin_whenGetPINs_thenReturnListOfPins(String input, List<String> expected) {
        List<String> list = ObservedPin.getPINs(input);

        Assertions.assertEquals(expected, list);
    }
}
