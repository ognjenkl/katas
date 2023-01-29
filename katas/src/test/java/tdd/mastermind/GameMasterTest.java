package tdd.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMasterTest {

    GameMaster gameMaster;
    private Mastermind mastermind;
    private MastermindPrinterPlusMinusSign mastermindPrinter;

    @BeforeEach
    void setUp() {
        mastermindPrinter = new MastermindPrinterPlusMinusSign();
        mastermind = new Mastermind(mastermindPrinter);
        mastermind.setScore("AABB");
        gameMaster = new GameMaster(mastermind, mastermindPrinter);
    }

    @Test
    void shouldReturnMatch() {
        assertEquals("++++", gameMaster.tryGuess("AABB"));
    }

    @Test
    void shouldReturnMismatch() {
        assertEquals("----", gameMaster.tryGuess("BBAA"));
    }

    // TODO: 12/6/2022 multiple guesses 
}
