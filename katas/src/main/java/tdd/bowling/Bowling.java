package tdd.bowling;

import java.util.HashMap;
import java.util.Map;

class Bowling {

    static final Integer TEN = 10;

    private Integer score = 0;
    private final Map<Integer, Frame> frameMap = new HashMap<>();

    public void roll(Integer pins) {
        pinInputValidation(pins);

        for (int frameNo = 1; frameNo <= TEN; frameNo++) {
            addNewFrameIfDoesNotExist(frameNo, new Frame(frameNo));

            if (hasNoRollsInFrame(frameNo)) {
                getFrame(frameNo).roll1(pins);
            } else if (hasOneRollInFrame(frameNo)) {
                getFrame(frameNo).roll2(pins);
            } else if (hasTwoRollsInFrame(frameNo) && TEN.equals(frameNo)) {
                getFrame(TEN).roll3(pins);
            } else {
                continue;
            }

            break;
        }
    }

    private void addNewFrameIfDoesNotExist(int frameNo, Frame frame) {
        if (!existsFrame(frameNo)) {
            frameMap.put(frameNo, frame);
        }
    }

    public Integer score() {
        for (int frameNo = 1; frameNo <= TEN; frameNo++) {
            if (existsFrame(frameNo)) {
                score += getFrame(frameNo).scoreTotal(
                        getFrame(frameNo + 1), getFrame(frameNo + 2));
            }
        }
        return score;
    }

    private Frame getFrame(int frameNo) {
        return frameMap.get(frameNo);
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

    Map<Integer, Frame> getFrameMap() {
        return frameMap;
    }
}
