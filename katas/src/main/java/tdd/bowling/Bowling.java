package tdd.bowling;

public class Bowling {

    private final Integer TEN = 10;

    private Integer score;
    private Frame[] frames;

    private int rollCounter;

    public Bowling() {
        score = 0;
        rollCounter = 0;
        frames = new Frame[TEN + 1];
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        rollCounter++;

        for (int i = 1; i <= TEN; i++) {
            if (frames[i] == null)
                frames[i] = new Frame(i);
            else if (frames[i].rollCount == 2)
                continue;

            if (frames[i].rollCount == 0) {
                frames[i].setRoll1(pins);
                frames[i].rollCount++;
                if (TEN.equals(frames[i].getRoll1()))
                    frames[i].rollCount++;
            } else if (frames[i].rollCount == 1) {
                frames[i].setRoll2(pins);
                frames[i].rollCount++;
                if (TEN.compareTo(frames[i].getRoll1() + frames[i].getRoll2()) < 0)
                    throw new IrregularFrameInputException();
            }
            break;
        }
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || TEN.compareTo(pins) < 0)
            throw new IrregularInputException();
    }

    public Integer score() {
        for (int i = 1; i <= TEN; i++)
            if (frames[i] != null)
                score += frames[i].scoreTotal(i + 1);
        return score;
    }

    public Integer getRollCounter() {
        return rollCounter;
    }

    class Frame {
        private final Integer frameIndex;
        private Integer roll1;
        private Integer roll2;
        Integer rollCount;

        Frame(Integer frameIndex) {
            roll1 = 0;
            roll2 = 0;
            rollCount = 0;
            this.frameIndex = frameIndex;
        }

        Integer score() {
            return roll1 + roll2;
        }

        Boolean isSpare() {
            return !TEN.equals(roll1) && TEN.equals(roll1 + roll2);
        }

        public Boolean isStrike() {
            return TEN.equals(roll1);
        }

        public Integer spareBonus(Integer nextFrameIndex) {
            return getRoll1(nextFrameIndex);
        }

        public Integer strikeBonus(Integer nextFrameIndex) {
            Integer retVal;
            if (nextFrameIndex <= TEN)
                if (frames[nextFrameIndex].isStrike()) {
                    retVal = frames[nextFrameIndex].score();
                    retVal += getRoll1(nextFrameIndex + 1);
                } else
                    retVal = frames[nextFrameIndex].score();
            else
                retVal = 0;
            return retVal;
        }

        public Integer scoreTotal(Integer nextFrameIndex) {
            if (isSpare())
                return score() + spareBonus(nextFrameIndex);
            else if (isStrike())
                return score() + strikeBonus(nextFrameIndex);
            else
                return score();
        }

        public Integer getFrameIndex() {
            return frameIndex;
        }

        public Integer getRoll1() {
            return roll1;
        }

        private int getRoll1(Integer nextFrameIndex) {
            return nextFrameIndex <= TEN ? frames[nextFrameIndex].getRoll1() : 0;
        }

        public void setRoll1(Integer roll1) {
            this.roll1 = roll1;
        }

        public Integer getRoll2() {
            return roll2;
        }

        public void setRoll2(Integer roll2) {
            this.roll2 = roll2;
        }
    }
}
