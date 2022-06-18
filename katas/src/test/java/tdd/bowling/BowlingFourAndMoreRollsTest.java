package tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingFourAndMoreRollsTest {

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
            "10,10,1,2,37",
            "10,10,4,5,52",
            "10,10,5,5,55",
            "10,10,10,1,63",
            "10,10,10,9,87",
            "10,10,10,10,90",
            "10,1,2,10,26",
            "10,1,9,10,50",
    })
    void score_fourRolls_scoreTest(Integer r1, Integer r2, Integer r3, Integer r4, Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        bowling.roll(r3);
        bowling.roll(r4);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,15",
            "1,9,2,3,4,21",
            "1,9,2,8,4,30",
            "10,7,2,8,1,37",
            "10,7,2,8,2,38",
            "10,7,3,8,1,47",
            "10,7,3,8,2,48",
            "10,10,1,2,3,40",
            "10,10,8,2,3,64",
            "10,10,10,1,2,67",
            "10,10,10,9,1,89",
            "10,10,10,10,1,93",
            "10,10,10,10,5,105",
            "10,10,10,10,10,120",
    })
    void score_fiveRolls_scoreTest(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        bowling.roll(r3);
        bowling.roll(r4);
        bowling.roll(r5);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,4,3,2,1,0,25",
            "1,2,3,4,5,4,3,2,1,2,27",
            "8,2,1,2,3,4,5,4,3,2,35",
            "8,2,1,2,6,4,5,4,3,2,43",
    })
    void score_tenRolls_scoreTest(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5,
                                  Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        bowling.roll(r3);
        bowling.roll(r4);
        bowling.roll(r5);
        bowling.roll(r6);
        bowling.roll(r7);
        bowling.roll(r8);
        bowling.roll(r9);
        bowling.roll(r10);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2, 3,4, 5,4, 3,2, 1,0, 1,2, 3,4, 5,4, 3,2, 1,0, 50",
    })
    void score_tenthFrame_scoreTest(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5,
                                  Integer r6, Integer r7, Integer r8, Integer r9, Integer r10,
                                  Integer r11, Integer r12, Integer r13, Integer r14, Integer r15,
                                  Integer r16, Integer r17, Integer r18, Integer r19, Integer r20,
                                    Integer s) {
        bowling.roll(r1);
        bowling.roll(r2);
        bowling.roll(r3);
        bowling.roll(r4);
        bowling.roll(r5);
        bowling.roll(r6);
        bowling.roll(r7);
        bowling.roll(r8);
        bowling.roll(r9);
        bowling.roll(r10);
        bowling.roll(r11);
        bowling.roll(r12);
        bowling.roll(r13);
        bowling.roll(r14);
        bowling.roll(r15);
        bowling.roll(r16);
        bowling.roll(r17);
        bowling.roll(r18);
        bowling.roll(r19);
        bowling.roll(r20);
        Integer score = bowling.score();

        assertEquals(s, score);
    }

}
