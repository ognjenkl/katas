package tdd.bowling;

import java.util.HashMap;
import java.util.Map;

public class Bowling {

    public static final Integer TEN = 10;

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

        for (int frameNo = 1; frameNo <= TEN; frameNo++) {
            if (!existsFrame(frameNo)) {
                addToMapFrame(frameNo);
            }

            if (hasNoRollsInFrame(frameNo)) {
                getFrame(frameNo).roll1(pins);
            } else if (hasOneRollInFrame(frameNo)) {
                getFrame(frameNo).roll2(pins);
            } else if (hasTwoRollsInFrame(frameNo) && TEN.equals(frameNo)) {
                getFrame(TEN).roll3(pins);
            } else
                continue;

            break;
        }
    }

    public Integer score() {
        for (int frameNo = 1; frameNo <= TEN; frameNo++)
            if (getFrame(frameNo) != null)
                score += getFrame(frameNo).scoreTotal(frameNo + 1);
        return score;
    }

    private void addToMapFrame(int i) {
        frameMap.put(i, new Frame(frameMap, i));
    }

    private Frame getFrame(int i) {
        return frameMap.get(i);
    }

    private boolean existsFrame(int i) {
        return getFrame(i) != null;
    }

    private boolean hasTwoRollsInFrame(int i) {
        return getFrame(i).getRollCounter() == 2;
    }

    private boolean hasOneRollInFrame(int i) {
        return getFrame(i).getRollCounter() == 1;
    }

    private boolean hasNoRollsInFrame(int ordinalFrameNumber) {
        return getFrame(ordinalFrameNumber).getRollCounter() == 0;
    }

    private void pinInputValidation(Integer pins) {
        if (pins == null || pins < 0 || TEN.compareTo(pins) < 0)
            throw new IrregularInputException();
    }

    public Integer getRollCounter() {
        return rollCounter;
    }

    public Map<Integer, Frame> getFrameMap() {
        return frameMap;
    }

}
