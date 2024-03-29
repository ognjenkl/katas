package tdd.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Mastermind {

    private List<String> score = List.of("B", "C", "D", "E");
    private List<Integer> result = new ArrayList<>(List.of(0, 0));
    private String guess;
    private final MastermindPrinter mastermindPrinter;

    public Mastermind(MastermindPrinter mastermindPrinter) {
        this.mastermindPrinter = mastermindPrinter;
    }

    public String guess(String guessInput) {
        this.guess = guessInput;
        List<String> list = new ArrayList<>(List.of(guess.split("")));

        int counter = countCorrect(list);

        for (int i = 0, j = 0; i < list.size(); i++) {
            if (score.contains(list.get(i)) && score.get(i).equals(list.get(i))) {
                result.set(0, ++j);
                result.set(1, --counter);
            }
        }


//        System.out.println(guess);
//        System.out.println(result.get(0).toString() + result.get(1));
        return result.get(0).toString() + result.get(1);
    }

    private int countCorrect(List<String> list) {
        int counter = 0;
        for (String s : score) {
            if (list.contains(s)) {
                counter++;
            }
        }
        result.set(1, counter);
        return counter;
    }

    public void setScore(String scoreString) {
        score = new ArrayList<>(List.of(scoreString.split("")));
    }

    public Integer getWellPlacedPegs() {
        return result.get(0);
    }

    public Integer getMisplacedPegs() {
        return result.get(1);
    }

    public String print() {
        return mastermindPrinter.print(guess, result);
    }

    public String printGuessResult() {
        return mastermindPrinter.printResult(result);
    }
}
