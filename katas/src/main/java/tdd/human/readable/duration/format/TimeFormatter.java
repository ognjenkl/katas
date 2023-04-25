package tdd.human.readable.duration.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeFormatter {

    public static final String SECOND = "second";
    public static final String SECONDS = "seconds";
    public static final String SPACE = " ";
    public static final String MINUTE = "minute";
    public static final String AND = "and";
    public static final String DELIMITER = SPACE + AND + SPACE;
    public static final String MINUTES = "minutes";
    public static final String EMPTY_STRING = "";
    public static final String NOW = "now";
    public static final String YEARS = "years";
    public static final String YEAR = "year";
    public static final String DAYS = "days";
    public static final String DAY = "day";
    public static final String HOURS = "hours";
    public static final String HOUR = "hour";
    private static String retVal;

    public static String formatDuration(int seconds) {
        return process(seconds);
    }

    private static String process(int seconds) {

        if (seconds == 0) {
            return NOW;
        }

        retVal = EMPTY_STRING;

        int years = seconds / (60 * 60 * 24 * 365);
        int yearsMod = seconds % (60 * 60 * 24 * 365);
        int days = yearsMod / (60 * 60 * 24);
        int daysMod = yearsMod % (60 * 60 * 24);
        int hours = daysMod / (60 * 60);
        int hoursMod = daysMod % (60 * 60);
        int minutes = hoursMod / 60;
        int minutesMod = hoursMod % 60;
        int secs = minutesMod % 60;

        String yearsFormatted = formatUnits(years, YEARS, YEAR);
        processUnits(yearsFormatted, false);

        String daysFormatted = formatUnits(days, DAYS, DAY);
        processUnits(daysFormatted, yearsNeedDelimiter(yearsFormatted));

        String hoursFormatted = formatUnits(hours, HOURS, HOUR);
        processUnits(hoursFormatted, hoursNeedDelimiter(yearsFormatted, daysFormatted));

        String minutesFormatted = formatUnits(minutes, MINUTES, MINUTE);
        processUnits(minutesFormatted, minutesNeedDelimiter(
                yearsFormatted, daysFormatted, hoursFormatted));

        String secondsFormatted = formatUnits(secs, SECONDS, SECOND);
        processUnits(secondsFormatted, secondsNeedDelimiter(
                yearsFormatted, daysFormatted, hoursFormatted, minutesFormatted));

        formantResult();
        return retVal;
    }

    private static boolean yearsNeedDelimiter(String yearsFormatted) {
        return !yearsFormatted.isEmpty();
    }

    private static void formantResult() {
        int countAnd = countAll(retVal, AND);
        if (countAnd > 1) {
            retVal = replaceByCount(
                    retVal, SPACE + AND, ",", countAnd - 1);
        }
    }

    private static void processUnits(String unitsFormatted, boolean isDelimiterNeeded) {
        if (!unitsFormatted.isEmpty()) {
            if (isDelimiterNeeded) {
                retVal += DELIMITER;
            }
            retVal += unitsFormatted;
        }
    }

    private static String formatUnits(int unit, String unitPlural, String unitSingular) {
        String daysFormatted = EMPTY_STRING;
        if (unit > 1) {
            daysFormatted += unit + SPACE + unitPlural;
        } else if (unit == 1) {
            daysFormatted += unit + SPACE + unitSingular;
        }
        return daysFormatted;
    }

    private static boolean hoursNeedDelimiter(
            String yearsFormatted, String daysFormatted) {
        return !yearsFormatted.isEmpty() || !daysFormatted.isEmpty();
    }

    private static boolean minutesNeedDelimiter(
            String yearsFormatted, String daysFormatted, String hoursFormatted) {
        return !yearsFormatted.isEmpty()
                || !daysFormatted.isEmpty()
                || !hoursFormatted.isEmpty();
    }

    private static boolean secondsNeedDelimiter(
            String yearsFormatted, String daysFormatted,
            String hoursFormatted, String minutesFormatted) {
        return !yearsFormatted.isEmpty()
                || !daysFormatted.isEmpty()
                || !hoursFormatted.isEmpty()
                || !minutesFormatted.isEmpty();
    }

    private static String replaceByCount(
            String text, String subString, String replaceWith, int count) {
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(text);
        while (count > 0 && matcher.find()) {
            text = text.replaceFirst(subString, replaceWith);
            count--;
        }
        return text;
    }

    private static int countAll(String text, String subString) {
        int count = 0;
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
