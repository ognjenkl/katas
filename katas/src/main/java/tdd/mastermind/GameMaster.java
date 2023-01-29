package tdd.mastermind;

public class GameMaster {

        private final Mastermind mastermind;
        private final MastermindPrinterPlusMinusSign mastermindPrinter;

    public GameMaster(Mastermind mastermind,
                      MastermindPrinterPlusMinusSign mastermindPrinter) {
        this.mastermind = mastermind;
        this.mastermindPrinter = mastermindPrinter;
    }

    public String tryGuess(String guess) {
        mastermind.guess(guess);
        return mastermind.printGuessResult();
    }
}
