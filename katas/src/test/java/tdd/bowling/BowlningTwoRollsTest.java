package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class BowlningTwoRollsTest {

    private Bowling bowling;

    @BeforeEach
    void setUp() {
        bowling = new Bowling();
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

    @ParameterizedTest
    @CsvSource({
            "5,4,9",
            "5,5,10",
            "9,1,10",
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
            "10,6,22",
            "10,7,24",
            "10,1,12",
            "10,9,28",
            "10,10,30"
    })
    void score_twoRollsStrike_scoreTest(Integer r1, Integer r2, Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

}
