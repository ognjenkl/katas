package tdd.bowling;

import java.util.Map;

class Frame {

    private Map<Integer, Frame> frameMap;
    private final Integer frameIndex;
    private Integer roll1;
    private Integer roll2;
    Integer frameFollCounter;

    Frame(Map<Integer, Frame> frameMap, Integer frameIndex) {
        this.frameMap = frameMap;
        roll1 = 0;
        roll2 = 0;
        frameFollCounter = 0;
        this.frameIndex = frameIndex;
    }

    Integer score() {
        return roll1 + roll2;
    }

    Boolean isSpare() {
        return !Bowling.TEN.equals(roll1) && Bowling.TEN.equals(roll1 + roll2);
    }

    public Boolean isStrike() {
        return Bowling.TEN.equals(roll1);
    }

    public Integer spareBonus(Integer nextFrameIndex) {
        return getRoll1(nextFrameIndex);
    }

    public Integer strikeBonus(Integer nextFrameIndex) {
        Integer retVal = 0;
        if (nextFrameIndex <= Bowling.TEN) {
            if (frameMap.get(nextFrameIndex) != null
                    && frameMap.get(nextFrameIndex).isStrike()) {
                retVal = frameMap.get(nextFrameIndex).score();
                retVal += getRoll1(nextFrameIndex + 1);
            } else
                retVal = frameMap.get(nextFrameIndex) != null
                        ? frameMap.get(nextFrameIndex).score()
                        : 0;
        }
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
        return nextFrameIndex <= Bowling.TEN && frameMap.get(nextFrameIndex) != null
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
