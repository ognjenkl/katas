package tdd.bowling;

public class Bowling {

    private Integer score;
    private Frame[] frames = new Frame[10];

    private int rollCounter;

    public Bowling() {
        score = 0;
        frames[0] = new Frame();
        rollCounter = 1;
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        for (int i = 0; i < 10; i++) {
            if (frames[i] == null)
                frames[i] = new Frame();
            else if (frames[i].rollCount == 2)
                continue;
            if (frames[i].rollCount == 0) {
                frames[i].roll1 = pins;
                frames[i].rollCount++;
                if (frames[i].roll1 == 10)
                    frames[i].rollCount++;
            } else if (frames[i].rollCount == 1) {
                frames[i].roll2 = pins;
                frames[i].rollCount++;
                if (frames[i].roll1 + frames[i].roll2 > 10)
                    throw new IrregularFrameInputException();
            }
            break;
        }
        System.out.println(rollCounter);
        rollCounter++;
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || pins > 10)
            throw new IrregularInputException();
    }

    public Integer score() {
        for (int i = 0; i < 10; i++)
            if (frames[i] != null)
                score += frames[i].scoreTotal(frames[i + 1], frames[i + 2]);

        return score;
    }

    class Frame {
        Integer roll1;
        Integer roll2;
        Integer rollCount;

        Frame() {
            roll1 = 0;
            roll2 = 0;
            rollCount = 0;
        }

        Integer score() {
            return roll1 + roll2;
        }

        Boolean isSpare() {
            return roll1 != 10 && Integer.valueOf(10).equals(roll1 + roll2);
        }

        public Boolean isStrike() {
            return Integer.valueOf(10).equals(roll1);
        }

        public Integer spareBonus(Frame nextFrame) {
            return nextFrame != null ? nextFrame.roll1 : 0;
        }

        public Integer strikeBonus(Frame nextFrame, Frame secondNextFrame) {
            Integer retVal = nextFrame != null
                    ? nextFrame.score() : 0;
            if (nextFrame != null && nextFrame.isStrike() && secondNextFrame != null)
                retVal = nextFrame.scoreTotal(secondNextFrame, null);
            return retVal;
        }

        public Integer scoreTotal(Frame nextFrame, Frame secondNextFrame) {
            if (isSpare())
                return score() + spareBonus(nextFrame);
            else if (isStrike())
                return score() + strikeBonus(nextFrame, secondNextFrame);
            else
                return score();
        }
    }
}
