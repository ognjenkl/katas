package tdd.human.readable.duration.format;

public class TimeFormatter {

    public static final String SECOND = "second";
    public static final String SECONDS = "seconds";
    public static final String SPACE = " ";

    public static String formatDuration(int seconds) {
        String prostfix;
        if (seconds == 1) {
            prostfix = SECOND;
        } else {
            prostfix = SECONDS;
        }
        return seconds + SPACE + prostfix;
    }
}
