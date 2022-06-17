package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingThreeRollsTest {

    private Bowling bowling;

    @BeforeEach
    void setUp() {
        bowling = new Bowling();
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

    @ParameterizedTest
    @CsvSource({
            "4,6,3,16",
            "3,7,9,28",
            "9,1,10,30"
    })
    void score_threeRollsSpare_scoreTest(Integer i1, Integer i2, Integer i3, Integer s) {
        bowling.roll(i1);
        bowling.roll(i2);
        bowling.roll(i3);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @ParameterizedTest
    @CsvSource({
            "10,1,2,16",
            "10,4,5,28",
            "10,5,5,30"
    })
    void score_threeRollsStrike_scoreTest(Integer i1, Integer i2, Integer i3, Integer s) {
        bowling.roll(i1);
        bowling.roll(i2);
        bowling.roll(i3);
        Integer score = bowling.score();

        assertEquals(s, score);
    }
}
