package tdd.bowling;

import java.util.Map;

class Frame {

    private static final Integer TEN = 10;
    private Map<Integer, Frame> frameMap;
    private final Integer frameIndex;
    private Integer roll1;
    private Integer roll2;
    private Integer roll3;
    Integer rollCounter;
    private Integer frameNo;

    Frame(Map<Integer, Frame> frameMap, Integer frameIndex) {
        this.frameMap = frameMap;
        roll1 = 0;
        roll2 = 0;
        roll3 = 0;
        rollCounter = 0;
        this.frameIndex = frameIndex;
    }

    private Integer sumFirstAndSecondRoll() {
        return roll1 + roll2;
    }

    Boolean isSpare() {
        return !Bowling.TEN.equals(roll1) && Bowling.TEN.equals(roll1 + roll2);
    }

    public Boolean isStrike() {
        return Bowling.TEN.equals(roll1);
    }

    public Integer spareBonus(Integer nextFrameIndex) {
        Integer bonus;

        if (getFrameIndex() < TEN)
            bonus = getRoll1OfFrame(nextFrameIndex);
        else
            bonus = getRoll3();

        return bonus;
    }

    public Integer strikeBonus(Integer nextFrameIndex) {
        Integer retVal = 0;
        if (getFrameIndex() < Bowling.TEN) {
            if (existsFrame(nextFrameIndex) && getFrame(nextFrameIndex).isStrike()) {
                retVal = getFrame(nextFrameIndex).sumFirstAndSecondRoll();
                retVal += getRoll1OfFrame(nextFrameIndex + 1);
            } else
                retVal = existsFrame(nextFrameIndex)
                        ? getFrame(nextFrameIndex).sumFirstAndSecondRoll()
                        : 0;
        } else {
            retVal = getRoll3();
//            retVal = getRoll2() + getRoll3();
        }
//        if (nextFrameIndex == Bowling.TEN + 1)
//            retVal += roll2;
        return retVal;
    }

    private Frame getFrame(Integer nextFrameIndex) {
        return frameMap.get(nextFrameIndex);
    }

    private boolean existsFrame(Integer nextFrameIndex) {
        return getFrame(nextFrameIndex) != null;
    }

    public Integer scoreTotal(Integer nextFrameIndex) {
        Integer scoreTotal;

        if (isSpare())
            scoreTotal = sumFirstAndSecondRoll() + spareBonus(nextFrameIndex);
        else if (isStrike())
            scoreTotal = sumFirstAndSecondRoll() + strikeBonus(nextFrameIndex);
        else
            scoreTotal = sumFirstAndSecondRoll();

        return scoreTotal;
    }

    public Integer getFrameIndex() {
        return frameIndex;
    }

    public Integer getRoll1() {
        return roll1;
    }

    private int getRoll1OfFrame(Integer nextFrameIndex) {
        return nextFrameIndex <= Bowling.TEN && existsFrame(nextFrameIndex)
                ? getFrame(nextFrameIndex).getRoll1()
                : 0;
    }

    public void roll1(Integer roll1) {
        this.roll1 = roll1;
        incrementRollCounter();
        if (TEN.equals(getRoll1()) && !TEN.equals(frameIndex))
//        if (TEN.equals(getRoll1()) && !TEN.equals(rollCounter))
            incrementRollCounter();
    }

    public Integer getRoll2() {
        return roll2;
    }

    public void roll2(Integer roll2) {
        this.roll2 = roll2;
        incrementRollCounter();
        validateAfterRoll2();
    }

    public void roll3(Integer roll3) {
        this.roll3 = roll3;
    }

    public Integer getRollCounter() {
        return rollCounter;
    }

    public void incrementRollCounter() {
        rollCounter++;
    }

    public void validateAfterRoll2() {
        System.out.println(frameIndex);
        System.out.println(getRoll1());
        System.out.println(getRoll2());
        System.out.println();
        if (!TEN.equals(frameIndex) && TEN.compareTo(getRoll1() + getRoll2()) < 0)
//                && !TEN.equals(rollCounter))
            throw new IrregularFrameInputException();
    }

    public Integer getRoll3() {
        return roll3;
    }
}
