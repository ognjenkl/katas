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

        for (int i = 1; i <= TEN; i++) {
            if (existsFrame(i))
                frameMap.put(i, new Frame(frameMap, i));

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

    public Map<Integer, Frame> getFrameMap() {
        return frameMap;
    }

}
