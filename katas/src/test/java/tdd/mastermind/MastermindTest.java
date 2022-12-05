package tdd.mastermind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
Mastermind
Difficulty: medium

This game where one player, a codemaker, has to choose a secret combination of colored pegs
and then make it guess to someone else, a codebreaker.
The codemaker is answering to each guess attempt of the codebreaker
by indicating only the number of well placed colors and the number of correct but misplaced colors.

If you remember playing the game, being the one who guesses is very brain demanding,
whereas the other player get bored rapidly.

Problem Description
The idea of this Kata is to code an algorithm capable of playing this boring role:
answering the number of well placed and misplaced colors.

Therefore, your function should return, for a secret and a guessing combination:
    the number of well placed colors
    the number of correct but misplaced colors

A combination can contain any number of pegs but you’d better give the same number
for the secret and the guessing. You can use any number of colors.

Clues
It’s better to start by detecting well placed colors.
Detecting misplaced colors is about counting them…

Suggested Test Cases
For a secret [blue, red, green, pink] and
a guess [yellow, red, blue, purple]
the answer should be :
1 well placed and 1 misplaced.
 */

public class MastermindTest {

    @ParameterizedTest
    @CsvSource({
            "AAAA,00",
            "AAAB,01",
            "AABC,02",
            "DABC,03",
            "DEBC,04",
            "BAAA,10",
            "BCAA,20",
            "BCDA,30",
            "BCDE,40",
            "BCED,22",
            "BDEC,13",
            "ADEC,03",
            "DECA,03",
            "DEAA,02",
    })
    void shouldGuessWellPlacedAndMisplaced(String guess, String expected) {
        Mastermind mastermind = new Mastermind();
        String guesses = mastermind.guess(guess);
        assertEquals(expected, guesses);
    }
}
