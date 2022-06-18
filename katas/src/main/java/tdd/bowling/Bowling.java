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
                frames[i].roll1 = pins;
                frames[i].rollCount++;
                if (TEN.equals(frames[i].roll1))
                    frames[i].rollCount++;
            } else if (frames[i].rollCount == 1) {
                frames[i].roll2 = pins;
                frames[i].rollCount++;
                if (TEN.compareTo(frames[i].roll1 + frames[i].roll2) < 0)
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
        Integer roll1;
        Integer roll2;
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

        public Integer getFrameIndex() {
            return frameIndex;
        }
    }
}
