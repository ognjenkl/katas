package tdd.human.readable.duration.format;

public class TimeFormatter {

    public static final String SECOND = "second";
    public static final String SECONDS = "seconds";
    public static final String SPACE = " ";
    public static final String MINUTE = "minute";
    public static final String AND = "and";
    public static final String MINUTES = "minutes";

    public static String formatDuration(int seconds) {
//        if (seconds < 60) {
//            return processSeconds(seconds);
//        } else {
        return process(seconds);
//        }
    }

    private static String process(int seconds) {
        String retVal = "";

        int minutes = seconds / 60;
        if (minutes > 0) {
            retVal = processMinutes(minutes);
        }

        int secs = seconds % 60;
        if (secs > 0) {
            if (minutes > 0) {
                retVal += SPACE + AND + SPACE;
            }
            retVal += processSeconds(secs);
        }
        return retVal;
    }

    private static String processMinutes(int minutes) {
        String retVal;
        String postfix = minutes == 1 ? MINUTE : MINUTES;
        retVal = minutes + SPACE + postfix;
        return retVal;
    }

    private static String processSeconds(int seconds) {
        String postfix = seconds == 1 ? SECOND : SECONDS;
        return seconds + SPACE + postfix;
    }
}
