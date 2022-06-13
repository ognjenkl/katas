package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


/*
Credits
Inspired by Uncle Bob

Bowling Rules
    The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins.
    The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

    A spare is when the player knocks down all 10 pins in two rolls.
    The bonus for that frame is the number of pins knocked down by the next roll.

    A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll.
    The bonus for that frame is the value of the next two rolls.

    In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame.
    However no more than three balls can be rolled in tenth frame.

Requirements
    Write a class Game that has two methods:
        - void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
        - int score() returns the total score for that game.
 */

@ExtendWith(SpringExtension.class)
class BowlingTest {

    private Bowling bowling;

    @BeforeEach
    void setUp() {
        bowling = new Bowling();
    }

    @Test
    void score_oneRollZeroPins_scoreZeroTest() {
        bowling.roll(0);
        Integer score = bowling.score();

        assertEquals(0, score);
    }

    @Test
    void score_oneRollOnePin_score1Test() {
        bowling.roll(1);
        Integer score = bowling.score();

        assertEquals(1, score);
    }

    @Test
    void score_oneRollTwoPins_score2Test() {
        bowling.roll(2);
        Integer score = bowling.score();

        assertEquals(2, score);
    }

    @Test
    void score_oneRoll10Pins_score10Test() {
        bowling.roll(10);
        Integer score = bowling.score();

        assertEquals(10, score);
    }

    @Test
    void score_twoRollsZeroAndZeroPins_scoreZeroTest() {
        bowling.roll(0);
        bowling.roll(0);
        Integer score = bowling.score();

        assertEquals(0, score);
    }

    @Test
    void score_twoRolls0And1Pins_score1Test() {
        bowling.roll(0);
        bowling.roll(1);
        Integer score = bowling.score();

        assertEquals(1, score);
    }

    @Test
    void score_twoRolls1And0Pins_score1Test() {
        bowling.roll(1);
        bowling.roll(0);
        Integer score = bowling.score();

        assertEquals(1, score);
    }

    @Test
    void score_twoRolls1And1Pins_score2Test() {
        bowling.roll(1);
        bowling.roll(1);
        Integer score = bowling.score();

        assertEquals(2, score);
    }

    @Test
    void roll_inputNullPins_shouldThrowIrregularInputExceptionTest() {
        assertThrows(IrregularInputException.class, () -> bowling.roll(null));
    }

    @Test
    void roll_inputNegativeNumberPins_shouldThrowIrregularInputExceptionTest() {
        assertThrows(IrregularInputException.class, () -> bowling.roll(-1));
    }

    @Test
    void roll_inputGT10Pins_shouldThrowIrregularInputExceptionTest() {
        assertThrows(IrregularInputException.class, () -> bowling.roll(11));
    }

    @Test
    void score_twoRolls5And4Pins_scoreTest() {
        bowling.roll(5);
        bowling.roll(4);
        Integer score = bowling.score();

        assertEquals(9, score);
    }

    @Test
    void score_twoRolls5And5Pins_score10Test() {
        bowling.roll(5);
        bowling.roll(5);
        Integer score = bowling.score();

        assertEquals(10, score);
    }

    @Test
    void score_twoRolls9And1Pins_score10Test() {
        bowling.roll(9);
        bowling.roll(1);
        Integer score = bowling.score();

        assertEquals(10, score);
    }

    @Test
    void score_twoRolls10And1Pins_score11Test() {
        bowling.roll(10);
        bowling.roll(1);
        Integer score = bowling.score();

        assertEquals(11, score);
    }

    @Test
    void score_twoRolls10And9Pins_score19Test() {
        bowling.roll(10);
        bowling.roll(9);
        Integer score = bowling.score();

        assertEquals(19, score);
    }

    @Test
    void score_twoRolls10And10Pins_score20Test() {
        bowling.roll(10);
        bowling.roll(10);
        Integer score = bowling.score();

        assertEquals(20, score);
    }

    @Test
    void score_twoRolls1And10Pins_throwIrregularFrameInputExceptionTest() {
        bowling.roll(1);
        bowling.roll(10);
        assertThrows(IrregularFrameInputException.class, () -> bowling.score());
    }

    @Test
    void score_twoRolls9And2Pins_throwIrregularFrameInputExceptionTest() {
        bowling.roll(9);
        bowling.roll(2);
        assertThrows(IrregularFrameInputException.class, () -> bowling.score());
    }

}
