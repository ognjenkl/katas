package tdd.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

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

    Mastermind mastermind;
    MastermindPrinter mastermindPrinter;

    @BeforeEach
    void setUp() {
        mastermindPrinter = new MastermindPrinterPlusMinusSign();
        mastermind = new Mastermind(mastermindPrinter);
    }

    @ParameterizedTest
    @CsvSource({
            "BCDE,AAAA,00",
            "BCDE,AAAB,01",
            "BCDE,AABC,02",
            "BCDE,DABC,03",
            "BCDE,DEBC,04",
            "BCDE,BAAA,10",
            "BCDE,BCAA,20",
            "BCDE,BCDA,30",
            "BCDE,BCDE,40",
            "BCDE,BCED,22",
            "BCDE,BDEC,13",
            "BCDE,ADEC,03",
            "BCDE,DECA,03",
            "BCDE,DEAA,02",
    })
    void shouldGuessWellPlacedAndMisplaced(String score, String guess, String expected) {
        mastermind.setScore(score);
        String guesses = mastermind.guess(guess);
        assertEquals(expected, guesses);
    }

    @Test
    void shoudScoreHaveAllWellPlacedPegs() {
        mastermind.setScore("AAAA");
        String guesses = mastermind.guess("AAAA");
        assertEquals("40", guesses);
    }

    @Test
    void shouldScoreNotHaveAllWellPlacedPegs() {
        mastermind.setScore("AAAA");
        String guesses = mastermind.guess("BAAA");
        assertNotEquals("40", guesses);
    }

    @ParameterizedTest
    @CsvSource({
            "AAAA,AAAA,4",
            "AAAA,BAAA,3",
            "AAAA,BBAA,2",
            "AAAA,BBBA,1",
            "AAAA,BBBB,0",
    })
    void shouldReturnWellPlacedPegs(String score, String guess, Integer expected) {
        mastermind.setScore(score);
        mastermind.guess(guess);
        assertEquals(expected, mastermind.getWellPlacedPegs());
    }

    @ParameterizedTest
    @CsvSource({
            "ABCD,EEEE,0",
            "ABCD,EEEA,1",
            "ABCD,EEAB,2",
            "ABCD,EABC,3",
            "ABCD,DABC,4",
    })
    void shouldReturnMisplacedPegsNumber(String score, String guess, Integer expected) {
        mastermind.setScore(score);
        mastermind.guess(guess);
        assertEquals(expected, mastermind.getMisplacedPegs());
    }

    @Test
    void givenGuess_whenZeroCorrectPegs_thenPrintEmptyString() {
        mastermind.setScore("BBBB");
        String guess = "AAAA";
        mastermind.guess(guess);
        assertEquals(guess + "\n", mastermind.print());
    }

    @Test
    void givenGuess_when1WellPlaced_thenPrintPlusSign() {
        mastermind.setScore("ABBB");
        String guess = "AAAA";
        mastermind.guess(guess);
        assertEquals(guess + "\n" + "+", mastermind.print());
    }

    @ParameterizedTest
    @CsvSource({
            "BCDE,AAAB,-",
            "BCDE,AABC,--",
            "BCDE,DABC,---",
            "BCDE,DEBC,----",
            "BCDE,BAAA,+",
            "BCDE,BCAA,++",
            "BCDE,BCDA,+++",
            "BCDE,BCDE,++++",
            "BCDE,BCED,++--",
            "BCDE,BDEC,+---",
            "BCDE,ADEC,---",
            "BCDE,DECA,---",
            "BCDE,DEAA,--",
    })
    void givenGuess_when1WellPlaced_thenPrintPlusMinusSigns(String score, String guess, String expected) {
        mastermind.setScore(score);
        mastermind.guess(guess);
        assertEquals(guess + "\n" + expected, mastermind.print());
    }

    @ParameterizedTest
    @CsvSource(delimiterString = ":", value = {
            "BCDE:AAAB:[0,1]",
            "BCDE:AABC:[0,2]",
            "BCDE:DABC:[0,3]",
            "BCDE:DEBC:[0,4]",
            "BCDE:BAAA:[1,0]",
            "BCDE:BCAA:[2,0]",
            "BCDE:BCDA:[3,0]",
            "BCDE:BCDE:[4,0]",
            "BCDE:BCED:[2,2]",
            "BCDE:BDEC:[1,3]",
            "BCDE:ADEC:[0,3]",
            "BCDE:DECA:[0,3]",
            "BCDE:DEAA:[0,2]",
    })
    void givenGuess_when1WellPlaced_thenPrintNumberList(String score, String guess, String expected) {
        mastermind = new Mastermind(new MastermindPrinterNumberList());
        mastermind.setScore(score);
        mastermind.guess(guess);
        assertEquals(guess + "\n" + expected, mastermind.print());
    }
}
