package tdd.bowling;

import java.util.HashMap;
import java.util.Map;

public class Bowling {

    private final Integer TEN = 10;

    private Integer score;
    private Map<Integer, Frame> frameMap;

    private int rollCounter;

    public Bowling() {
        score = 0;
        rollCounter = 0;
        frameMap = new HashMap<>();
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        rollCounter++;

        for (int i = 1; i <= TEN; i++) {
            if (existsFrame(i))
                frameMap.put(i, new Frame(i));

            if (hasNoRollsInFrame(i)) {
                processFirstRollInFrame(pins, i);
            } else if (hasOneRolleInFrame(i)) {
                processSecondRollInFrame(pins, i);
            } else if (hasTwoRollsInFrame(i))
                continue;

            break;
        }
    }

    private void processSecondRollInFrame(Integer pins, int i) {
        frameMap.get(i).setRoll2(pins);
        frameMap.get(i).incrementFrameRollCounter();
        if (TEN.compareTo(frameMap.get(i).getRoll1() + frameMap.get(i).getRoll2()) < 0)
            throw new IrregularFrameInputException();
    }

    private void processFirstRollInFrame(Integer pins, int i) {
        frameMap.get(i).setRoll1(pins);
        frameMap.get(i).incrementFrameRollCounter();
        if (TEN.equals(frameMap.get(i).getRoll1()))
            frameMap.get(i).incrementFrameRollCounter();
    }

    private boolean existsFrame(int i) {
        return frameMap.get(i) == null;
    }

    private boolean hasTwoRollsInFrame(int i) {
        return frameMap.get(i).getFrameFollCounter() == 2;
    }

    private boolean hasOneRolleInFrame(int i) {
        return frameMap.get(i).getFrameFollCounter() == 1;
    }

    private boolean hasNoRollsInFrame(int i) {
        return frameMap.get(i).getFrameFollCounter() == 0;
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || TEN.compareTo(pins) < 0)
            throw new IrregularInputException();
    }

    public Integer score() {
        for (int i = 1; i <= TEN; i++)
            if (frameMap.get(i) != null)
                score += frameMap.get(i).scoreTotal(i + 1);
        return score;
    }

    public Integer getRollCounter() {
        return rollCounter;
    }

    class Frame {
        private final Integer frameIndex;
        private Integer roll1;
        private Integer roll2;
        Integer frameFollCounter;

        Frame(Integer frameIndex) {
            roll1 = 0;
            roll2 = 0;
            frameFollCounter = 0;
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
                if (frameMap.get(nextFrameIndex) != null
                        && frameMap.get(nextFrameIndex).isStrike()) {
                    retVal = frameMap.get(nextFrameIndex).score();
                    retVal += getRoll1(nextFrameIndex + 1);
                } else
                    retVal = frameMap.get(nextFrameIndex) != null
                            ? frameMap.get(nextFrameIndex).score()
                            : 0;
            else
                retVal = 0;
            return retVal;
        }

        public Integer scoreTotal(Integer nextFrameIndex) {
            Integer scoreTotal;
            if (isSpare())
                scoreTotal = score() + spareBonus(nextFrameIndex);
            else if (isStrike())
                scoreTotal = score() + strikeBonus(nextFrameIndex);
            else
                scoreTotal = score();
            return scoreTotal;
        }

        public Integer getFrameIndex() {
            return frameIndex;
        }

        public Integer getRoll1() {
            return roll1;
        }

        private int getRoll1(Integer nextFrameIndex) {
            return nextFrameIndex <= TEN && frameMap.get(nextFrameIndex) != null
                    ? frameMap.get(nextFrameIndex).getRoll1()
                    : 0;
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

        public Integer getFrameFollCounter() {
            return frameFollCounter;
        }

        public void incrementFrameRollCounter() {
            frameFollCounter++;
        }
    }
}
