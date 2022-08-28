package tdd.bowling;

import java.util.Map;

class Frame {

    private static final Integer TEN = 10;

    private final Integer frameIndex;

    private final Map<Integer, Frame> frameMap;
    private Integer roll1;
    private Integer roll2;
    private Integer roll3;
    private Integer rollCounter;

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

    Boolean isStrike() {
        return Bowling.TEN.equals(roll1);
    }

    Integer spareBonus(Frame nextFrame) {
        Integer bonus;

        if (getFrameIndex() < TEN)
            bonus = getRoll1OfFrame(nextFrame);
        else
            bonus = getRoll3();

        return bonus;
    }

    Integer strikeBonus(Frame nextFrame) {
        Integer retVal;
        if (getFrameIndex() < Bowling.TEN) {
            if (existsFrame(nextFrame) && nextFrame.isStrike()) {
                retVal = nextFrame.sumFirstAndSecondRoll();
                retVal += getRoll1OfFrame(getFrame(nextFrame.getFrameIndex() + 1));
            } else
                retVal = existsFrame(nextFrame)
                        ? nextFrame.sumFirstAndSecondRoll()
                        : 0;
        } else {
            retVal = getRoll3();
        }

        return retVal;
    }

    private Frame getFrame(Integer nextFrameIndex) {
        return frameMap.get(nextFrameIndex);
    }

    private boolean existsFrame(Frame nextFrame) {
        return nextFrame != null;
    }

    Integer scoreTotal(Frame nextFrame) {
        Integer scoreTotal;

        if (isSpare())
            scoreTotal = sumFirstAndSecondRoll() + spareBonus(nextFrame);
        else if (isStrike())
            scoreTotal = sumFirstAndSecondRoll() + strikeBonus(nextFrame);
        else
            scoreTotal = sumFirstAndSecondRoll();

        return scoreTotal;
    }

    Integer getFrameIndex() {
        return frameIndex;
    }

    private Integer getRoll1() {
        return roll1;
    }

    private int getRoll1OfFrame(Frame nextFrame) {
        return existsFrame(nextFrame) && nextFrame.getFrameIndex() <= Bowling.TEN
                ? nextFrame.getRoll1()
                : 0;
    }

    void roll1(Integer roll1) {
        this.roll1 = roll1;
        incrementRollCounter();
        if (TEN.equals(getRoll1()) && !TEN.equals(frameIndex))
            incrementRollCounter();
    }

    private Integer getRoll2() {
        return roll2;
    }

    void roll2(Integer roll2) {
        this.roll2 = roll2;
        incrementRollCounter();
        validateAfterRoll2();
    }

    void roll3(Integer roll3) {
        this.roll3 = roll3;
    }

    Integer getRollCounter() {
        return rollCounter;
    }

    private void incrementRollCounter() {
        rollCounter++;
    }

    private void validateAfterRoll2() {
        System.out.println(frameIndex);
        System.out.println(getRoll1());
        System.out.println(getRoll2());
        System.out.println();
        if (!TEN.equals(frameIndex) && TEN.compareTo(getRoll1() + getRoll2()) < 0)
            throw new IrregularFrameInputException();
    }

    private Integer getRoll3() {
        return roll3;
    }
}
