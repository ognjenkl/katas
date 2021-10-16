package tdd.ChristmasLights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasLightsTest {

    ChristmasLights christmasLights = new ChristmasLights();

    @Test
    void showInitLights() {
        christmasLights.printLights(0, 0, 3, 3);
    }

    @Test
    void turnOnStartingLight() throws Exception {
        christmasLights.turnOn(0, 0, 0, 0);
        christmasLights.countLights();

        assertEquals(1, christmasLights.getCounterOns());
        assertEquals(999999, christmasLights.getCounterOffs());

        christmasLights.printLights(0, 0, 3, 3);
    }

    @Test
    void countLights() throws Exception {
        christmasLights.countLights();
        assertEquals(0, christmasLights.getCounterOns());
        assertEquals(1000000, christmasLights.getCounterOffs());
    }

    @Test
    void turnOnStarting4Lights() throws Exception {
        christmasLights.turnOn(0, 0, 1, 1);
        christmasLights.countLights();

        assertEquals(4, christmasLights.getCounterOns());
        assertEquals(999996, christmasLights.getCounterOffs());

        christmasLights.printLights(0, 0, 3, 3);
    }

    @Test
    void turnOffStarting4Lights() throws Exception {
        christmasLights.printLights(0, 0, 3, 3);
        christmasLights.turnOff(0, 0, 1, 1);
        christmasLights.countLights();

        assertEquals(1000000, christmasLights.getCounterOffs());
        assertEquals(0, christmasLights.getCounterOns());

        christmasLights.printLights(0, 0, 3, 3);
    }

    @Test
    void turnOn4ThenTurnOff1Lights() throws Exception {
        christmasLights.turnOn(0, 0, 1, 1);
        christmasLights.printLights(0, 0, 3, 3);
        christmasLights.turnOff(0, 0, 0, 0);
        christmasLights.countLights();

        assertEquals(999997, christmasLights.getCounterOffs());
        assertEquals(3, christmasLights.getCounterOns());

        christmasLights.printLights(0, 0, 3, 3);
    }

    @Test
    void turnOn4ThenToggleTheSame4() throws Exception {
        christmasLights.turnOn(0, 0, 1, 1);
        christmasLights.printLights(0, 0, 3, 3);
        christmasLights.toggle(0, 0, 1, 1);
        christmasLights.countLights();

        assertEquals(12, christmasLights.calculateBrightness());

        christmasLights.printLights(0, 0, 3, 3);

    }

    @Test
    void togglePartlyFirstColumn() throws Exception {
        christmasLights.turnOn(0, 0, 9, 0);
        christmasLights.turnOn(20, 0, 29, 0);
        christmasLights.printLights(0, 0, 30, 3);

        christmasLights.toggle(0, 0, 29, 0);
        christmasLights.countLights();

        assertEquals(80, christmasLights.calculateBrightness());

        christmasLights.printLights(0, 0, 30, 3);
    }

    @Test
    void turnOn_toggleFirtColumn_turnOffCenter() throws Exception {
        christmasLights.turnOn(0, 0, 999, 999);
        christmasLights.printLights(0, 0, 3, 3);

        christmasLights.toggle(0, 0, 999, 0);
        christmasLights.printLights(0, 0, 30, 3);

        christmasLights.turnOff(499, 499, 500, 500);
        christmasLights.printLights(498, 498, 501, 501);

        christmasLights.countLights();

        assertEquals(1001996, christmasLights.calculateBrightness());
    }

    @Test
    void santasInstructions() throws Exception {
        christmasLights.turnOn(887, 9, 959, 629);
        christmasLights.turnOn(454, 398, 844, 448);
        christmasLights.turnOff(539, 243, 559, 965);
        christmasLights.turnOff(370, 819, 676, 868);
        christmasLights.turnOff(145, 40, 370, 997);
        christmasLights.turnOff(301, 3, 808, 453);
        christmasLights.turnOn(351, 678, 951, 908);
        christmasLights.toggle(720, 196, 897, 994);
        christmasLights.toggle(831, 394, 904, 860);

        christmasLights.countLights();
        christmasLights.printLights(610,610,800, 800);
        christmasLights.calculateBrightness();
    }

    @Test
    void countBrightnessOfOne() {
        assertEquals(0, christmasLights.calculateBrightness());
    }

    @Test
    void countBrightnessOfOneTurnOn() {
        christmasLights.turnOn(0,0,0,0);
        assertEquals(1, christmasLights.calculateBrightness());
    }

}
