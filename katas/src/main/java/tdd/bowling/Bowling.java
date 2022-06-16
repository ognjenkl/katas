package tdd.bowling;

public class Bowling {

    private Integer score;
    private Frame[] frames = new Frame[10];

    public Bowling() {
        score = 0;
        frames[0] = new Frame();
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        if (frames[0].roll2 > 0) {
            frames[1] = new Frame();
            frames[1].roll1 = pins;
        } else if (frames[0].roll1 > 0)
            frames[0].roll2 = pins;
        else
            frames[0].roll1 = pins;
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || pins > 10)
            throw new IrregularInputException();
    }

    public Integer score() {
        frameInputValidation();

        for (int i = 0; i < 10; i++)
            if (frames[i] != null)
                score += frames[i].scoreTotal(frames[i + 1]);

        return score;
    }

    private void frameInputValidation() {
        if (frames[0].score() > 10 && frames[0].roll1 < 10)
            throw new IrregularFrameInputException();
    }


    class Frame {
        Integer roll1;
        Integer roll2;

        Frame() {
            roll1 = 0;
            roll2 = 0;
        }

        Integer score() {
            return roll1 + roll2;
        }

        Boolean isSpare() {
            return roll1 + roll2 == 10;
        }

        public Integer bonus(Frame nextFrame) {
            return nextFrame != null ? nextFrame.score() : 0;
        }

        public Integer scoreTotal(Frame nextFrame) {
            return score() + bonus(nextFrame);
        }
    }
}
