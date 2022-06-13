package tdd.bowling;

public class Bowling {

    private Integer score;
    private Integer roll1;
    private Integer roll2;

    public Bowling() {
        score = 0;
        roll1 = 0;
        roll2 = 0;
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        if (roll1 > 0)
            roll2 = pins;
        else
            roll1 = pins;
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || pins > 10)
            throw new IrregularInputException();
    }

    public Integer score() {
        score = roll1 + roll2;

        if (score > 10 && roll1 < 10)
            throw new IrregularFrameInputException();

        return score;
    }
}
