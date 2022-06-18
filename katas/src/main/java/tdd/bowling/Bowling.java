package tdd.bowling;

import java.util.HashMap;
import java.util.Map;

public class Bowling {

    private final Integer TEN = 10;

    private Integer score;
    private Frame[] frames;
    private Map<Integer, Integer> rollMap;

    private int rollCounter;

    public Bowling() {
        score = 0;
        rollCounter = 0;
        frames = new Frame[TEN];
        rollMap = new HashMap<>();
    }

    public void roll(Integer pins) {
        pinInputValidation(pins);
        System.out.println(rollCounter);
        rollCounter++;
        rollMap.put(rollCounter, pins);

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
        for (int i = 0; i < TEN; i++)
            if (frames[i] != null)
                score += frames[i].scoreTotal(frames[i + 1], frames[i + 2]);

        return score;
    }

    public Integer getRollCounter() {
        return rollCounter;
    }

    public Integer getPinsByRoll(Integer rollIndex) {
        return rollMap.get(rollIndex);
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

        public Integer spareBonus(Frame nextFrame) {
            return nextFrame != null ? nextFrame.getRoll1() : 0;
        }

        public Integer strikeBonus(Frame nextFrame, Frame secondNextFrame) {
            Integer retVal;
            if (nextFrame != null)
                if (nextFrame.isStrike())
                    retVal = nextFrame.score() + (secondNextFrame != null
                            ? secondNextFrame.getRoll1()
                            : 0);
                else
                    retVal = nextFrame.score();
            else
                retVal = 0;
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

        public Integer getFrameIndex() {
            return frameIndex;
        }

        public Integer getRoll1() {
            return roll1;
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
