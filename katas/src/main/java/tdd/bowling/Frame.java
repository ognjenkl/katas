package tdd.bowling;

class Frame {

    private static final Integer TEN = 10;

    private Integer roll1 = 0;
    private Integer roll2 = 0;
    private Integer roll3 = 0;
    private Integer rollCounter = 0;

    private final Integer frameIndex;

    Frame(Integer frameIndex) {
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

        if (!isTenthFrame())
            bonus = getRoll1OfFrame(nextFrame);
        else
            bonus = getRoll3();

        return bonus;
    }

    private boolean isTenthFrame() {
        return TEN.equals(frameIndex);
    }

    Integer strikeBonus(Frame nextFrame, Frame nextAfterNextFrame) {
        if (isTenthFrame()) {
            return getRoll3();
        }
        if (!existsFrame(nextFrame)) {
            return 0;
        }

        Integer retVal = nextFrame.sumFirstAndSecondRoll();

        if (nextFrame.isStrike()) {
            retVal += getRoll1OfFrame(nextAfterNextFrame);
        }

        return retVal;
    }

    private boolean existsFrame(Frame nextFrame) {
        return nextFrame != null;
    }

    Integer scoreTotal(Frame nextFrame, Frame nextAfterNextFrame) {
        Integer scoreTotal;

        if (isSpare())
            scoreTotal = sumFirstAndSecondRoll() + spareBonus(nextFrame);
        else if (isStrike())
            scoreTotal = sumFirstAndSecondRoll() + strikeBonus(nextFrame, nextAfterNextFrame);
        else
            scoreTotal = sumFirstAndSecondRoll();

        return scoreTotal;
    }

    private Integer getRoll1() {
        return roll1;
    }

    private int getRoll1OfFrame(Frame nextFrame) {
        return existsFrame(nextFrame)
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
        if (!TEN.equals(frameIndex) && TEN.compareTo(getRoll1() + getRoll2()) < 0)
            throw new IrregularFrameInputException();
    }

    private Integer getRoll3() {
        return roll3;
    }
}
