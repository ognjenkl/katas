package tdd.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Mastermind {

    private List<String> score = List.of("B", "C", "D", "E");
    private List<Integer> result = new ArrayList<>(List.of(0, 0));

    public String guess(String guess) {
        List<String> list = new ArrayList<>(List.of(guess.split("")));

        int counter = countCorrect(list);

        for (int i = 0,j = 0; i < list.size(); i++) {
            if (score.contains(list.get(i)) && score.get(i).equals(list.get(i))) {
                result.set(0, ++j);
                result.set(1, --counter);
            }
        }


        System.out.println(guess);
        System.out.println(result.get(0).toString() + result.get(1));
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

}
