package tdd.bowling;

public class Bowling {

    private Integer score;
    private Frame[] frames = new Frame[10];

    private int rollCounter;

    public Bowling() {
        score = 0;
        frames[0] = new Frame();
        rollCounter = 0;
    }

    public void roll(Integer pins) {
        rollCounter++;
        pinInputValidation(pins);
        if (frames[0].roll2 > 0) {
            if (frames[1] == null)
                frames[1] = new Frame();
            frames[1].roll1 = pins;
        } else if (frames[0].roll1 > 0)
            if (Integer.valueOf(10).equals(frames[0].roll1)) {
                frames[0].roll2 = 0;
                if (frames[1] == null)
                    frames[1] = new Frame();
                frames[1].roll1 = pins;
            } else
                frames[0].roll2 = pins;
        else
            frames[0].roll1 = pins;
        System.out.println(rollCounter);
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
            return Integer.valueOf(10).equals(roll1 + roll2);
        }

        public Integer spareBonus(Frame nextFrame) {
            return nextFrame != null ? nextFrame.roll1 : 0;
        }

        public Integer strikeBonus(Frame nextFrame) {
            return nextFrame != null ? nextFrame.score() : 0;
        }

        public Integer scoreTotal(Frame nextFrame) {
            if (isSpare())
                return score() + spareBonus(nextFrame);
            else if (isStrike())
                return score() + strikeBonus(nextFrame);
            else
                return score();
        }

        public Boolean isStrike() {
            return Integer.valueOf(10).equals(roll1);
        }
    }
}
