package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingFourRollsTest {

    private Bowling bowling;

    @BeforeEach
    void setUp() {
        bowling = new Bowling();
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,10",
            "4,5,4,5,18",
            "5,5,4,5,23",
            "5,5,5,5,25",
            "10,1,2,3,19",
            "10,4,5,1,29",
            "10,5,5,1,32",
            "10,10,1,2,37"
    })
    void score_fourRolls_scoreTest(Integer r1, Integer r2, Integer r3, Integer r4, Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        bowling.roll(r3);
        bowling.roll(r4);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

}
