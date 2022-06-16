package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
            "5,4,9",
            "5,5,10",
            "9,1,10",
            "10,1,11",
            "10,9,19",
            "10,10,20",
            "0,2,2"})
    void score_twoRolls_score(Integer i1, Integer i2, Integer s) {
        bowling.roll(i1);
        bowling.roll(i2);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @ParameterizedTest
    @CsvSource({"9,2", "1,10"})
    void score_twoRolls_throwIrregularFrameInputExceptionTest(Integer i1, Integer i2) {
        bowling.roll(i1);
        bowling.roll(i2);
        assertThrows(IrregularFrameInputException.class, () -> bowling.score());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0,0",
            "0,0,1,1",
            "0,1,2,3",
            "1,2,3,6",
            "1,0,2,3",
            "1,2,0,3",
            "2,3,4,9",
            "4,5,6,15",
            "4,5,10,19"
    })
    void score_threeRolls_scoreTest(Integer i1, Integer i2, Integer i3, Integer s) {
        bowling.roll(i1);
        bowling.roll(i2);
        bowling.roll(i3);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @Test
    void isSpare_frameRolls5And5Spare_true() {
        Bowling.Frame frame = bowling.new Frame();
        frame.roll1 = 5;
        frame.roll2 = 5;
        assertTrue(frame.isSpare());
    }

    @Test
    void isSpare_frameRollsSpare_false() {
        Bowling.Frame frame = bowling.new Frame();
        frame.roll1 = 5;
        frame.roll2 = 4;
        assertFalse(frame.isSpare());
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,5,9",
            "5,5,10",
            "10, 5, 15",
            "10, 10, 20"})
    void bonus_setNextFrameToCalculateBonus_bonusCalculated(Integer r1, Integer r2, Integer bonus) {
        Bowling.Frame frame = bowling.new Frame();
        Bowling.Frame nextFrame = bowling.new Frame();
        nextFrame.roll1 = r1;
        nextFrame.roll2 = r2;

        assertEquals(bonus, frame.bonus(nextFrame));

    }

    @ParameterizedTest
    @CsvSource({
            "4,6,3,16"
    })
    void score_threeRollsSpare_scoreTest(Integer i1, Integer i2, Integer i3, Integer s) {
        bowling.roll(i1);
        bowling.roll(i2);
        bowling.roll(i3);
        Integer score = bowling.score();

        assertEquals(s, score);
    }
}
