package tdd.human.readable.duration.format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Your task in order to complete this Kata is to write
a function which formats a duration, given as a number
of seconds, in a human-friendly way.

The function must accept a non-negative integer.
If it is zero, it just returns "now".
Otherwise, the duration is expressed as a combination
of years, days, hours, minutes and seconds.

It is much easier to understand with an example:

* For seconds = 62, your function should return
    "1 minute and 2 seconds"
* For seconds = 3662, your function should return
    "1 hour, 1 minute and 2 seconds"
For the purpose of this Kata, a year is 365 days and a day is 24 hours.

Note that spaces are important.

Detailed rules
The resulting expression is made of components like
4 seconds, 1 year, etc.
In general, a positive integer and one of the
valid units of time, separated by a space.
The unit of time is used in plural if the integer
is greater than 1.

The components are separated by a comma and
a space (", "). Except the last component,
which is separated by " and ", just like it would be
written in English.

A more significant units of time will occur before
than a least significant one.
Therefore, 1 second and 1 year is not correct,
but 1 year and 1 second is.

Different components have different unit of times.
So there is not repeated units like in
5 seconds and 1 second.

A component will not appear at all if its value
happens to be zero.
Hence, 1 minute and 0 seconds is not valid,
but it should be just 1 minute.

A unit of time must be used "as much as possible".
It means that the function should not return 61 seconds,
but 1 minute and 1 second instead.
Formally, the duration specified by of a component
must not be greater than any valid more significant
unit of time.
 */
public class TimeFormatterTest {

    @Test
    void shouldReturnNow() {
        String result = TimeFormatter.formatDuration(0);
        Assertions.assertEquals("now", result);
    }

    @Test
    void shouldReturn1Second() {
        String result = TimeFormatter.formatDuration(1);
        Assertions.assertEquals("1 second", result);
    }

    @Test
    void shouldReturn2Seconds() {
        String result = TimeFormatter.formatDuration(2);
        Assertions.assertEquals("2 seconds", result);
    }

    @Test
    void shouldReturn3Seconds() {
        String result = TimeFormatter.formatDuration(3);
        Assertions.assertEquals("3 seconds", result);
    }

    @Test
    void shouldReturn59Seconds() {
        String result = TimeFormatter.formatDuration(59);
        Assertions.assertEquals("59 seconds", result);
    }

    @Test
    void shouldReturn60Seconds() {
        String result = TimeFormatter.formatDuration(60);
        Assertions.assertEquals("1 minute", result);
    }

    @Test
    void shouldReturn1Minute1Second() {
        String result = TimeFormatter.formatDuration(61);
        Assertions.assertEquals("1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Minute2Seconds() {
        String result = TimeFormatter.formatDuration(62);
        Assertions.assertEquals("1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn1Minute59Seconds() {
        String result = TimeFormatter.formatDuration(119);
        Assertions.assertEquals("1 minute and 59 seconds", result);
    }

    @Test
    void shouldReturn2Minutes() {
        String result = TimeFormatter.formatDuration(120);
        Assertions.assertEquals("2 minutes", result);
    }

    @Test
    void shouldReturn2Minutes1Second() {
        String result = TimeFormatter.formatDuration(121);
        Assertions.assertEquals("2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn2Minutes2Seconds() {
        String result = TimeFormatter.formatDuration(122);
        Assertions.assertEquals("2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn2Minutes3Seconds() {
        String result = TimeFormatter.formatDuration(123);
        Assertions.assertEquals("2 minutes and 3 seconds", result);
    }

    @Test
    void shouldReturn59Minutes59Seconds() {
        String result = TimeFormatter.formatDuration(3599);
        Assertions.assertEquals("59 minutes and 59 seconds", result);
    }

    @Test
    void shouldReturn2Years() {
        String result = TimeFormatter.formatDuration(63072000);
        Assertions.assertEquals("2 years", result);
    }

    @Test
    void shouldReturn1Years() {
        String result = TimeFormatter.formatDuration(31536000);
        Assertions.assertEquals("1 year", result);
    }

    @Test
    void shouldReturn2Days() {
        String result = TimeFormatter.formatDuration(172800);
        Assertions.assertEquals("2 days", result);
    }

    @Test
    void shouldReturn1Day() {
        String result = TimeFormatter.formatDuration(86400);
        Assertions.assertEquals("1 day", result);
    }

    @Test
    void shouldReturn2Hours() {
        String result = TimeFormatter.formatDuration(7200);
        Assertions.assertEquals("2 hours", result);
    }

    @Test
    void shouldReturn1Hour() {
        String result = TimeFormatter.formatDuration(3600);
        Assertions.assertEquals("1 hour", result);
    }

    @Test
    void shouldReturn1HourAnd1Second() {
        String result = TimeFormatter.formatDuration(3601);
        Assertions.assertEquals("1 hour and 1 second", result);
    }

    @Test
    void shouldReturn1HourAnd2Seconds() {
        String result = TimeFormatter.formatDuration(3602);
        Assertions.assertEquals("1 hour and 2 seconds", result);
    }

    @Test
    void shouldReturn1HourAnd59Seconds() {
        String result = TimeFormatter.formatDuration(3659);
        Assertions.assertEquals("1 hour and 59 seconds", result);
    }

    @Test
    void shouldReturn1HourAnd1Minute() {
        String result = TimeFormatter.formatDuration(3660);
        Assertions.assertEquals("1 hour and 1 minute", result);
    }

    @Test
    void shouldReturn1Hour1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(3661);
        Assertions.assertEquals("1 hour, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Hour1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(3662);
        Assertions.assertEquals("1 hour, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn1HourMinuteAnd59Seconds() {
        String result = TimeFormatter.formatDuration(3719);
        Assertions.assertEquals("1 hour, 1 minute and 59 seconds", result);
    }

    @Test
    void shouldReturn1HourAnd2Minutes() {
        String result = TimeFormatter.formatDuration(3720);
        Assertions.assertEquals("1 hour and 2 minutes", result);
    }

    @Test
    void shouldReturn1Hour2MinutesAnd1Second() {
        String result = TimeFormatter.formatDuration(3721);
        Assertions.assertEquals("1 hour, 2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn1Hour2MinutesAnd2Seconds() {
        String result = TimeFormatter.formatDuration(3722);
        Assertions.assertEquals("1 hour, 2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn1Hour59Minutes59Seconds() {
        String result = TimeFormatter.formatDuration(7199);
        Assertions.assertEquals("1 hour, 59 minutes and 59 seconds", result);
    }

    @Test
    void shouldReturn2HoursAnd1Second() {
        String result = TimeFormatter.formatDuration(7201);
        Assertions.assertEquals("2 hours and 1 second", result);
    }

    @Test
    void shouldReturn2HoursAnd2Seconds() {
        String result = TimeFormatter.formatDuration(7202);
        Assertions.assertEquals("2 hours and 2 seconds", result);
    }

    @Test
    void shouldREturn2HoursAnd59Seconds() {
        String result = TimeFormatter.formatDuration(7259);
        Assertions.assertEquals("2 hours and 59 seconds", result);
    }

    @Test
    void shouldReturn2Hours1Minute() {
        String result = TimeFormatter.formatDuration(7260);
        Assertions.assertEquals("2 hours and 1 minute", result);
    }

    @Test
    void shouldReturn2Hours1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(7261);
        Assertions.assertEquals("2 hours, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn2Hours1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(7262);
        Assertions.assertEquals("2 hours, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn2Hours2MinutesAnd1Second() {
        String result = TimeFormatter.formatDuration(7321);
        Assertions.assertEquals("2 hours, 2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn2Hours2MinutesAnd2Seconds() {
        String result = TimeFormatter.formatDuration(7322);
        Assertions.assertEquals("2 hours, 2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn23Hours59Minutes59Seconds() {
        String result = TimeFormatter.formatDuration(86399);
        Assertions.assertEquals("23 hours, 59 minutes and 59 seconds", result);
    }

    @Test
    void shouldReturn1DayAnd1Second() {
        String result = TimeFormatter.formatDuration(86401);
        Assertions.assertEquals("1 day and 1 second", result);
    }

    @Test
    void shouldReturn1DayAnd2Seconds() {
        String result = TimeFormatter.formatDuration(86402);
        Assertions.assertEquals("1 day and 2 seconds", result);
    }

    @Test
    void shouldReturn1Day1Minute() {
        String result = TimeFormatter.formatDuration(86460);
        Assertions.assertEquals("1 day and 1 minute", result);
    }

    @Test
    void shouldReturn1Day1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(86461);
        Assertions.assertEquals("1 day, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Day1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(86462);
        Assertions.assertEquals("1 day, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn1Day1Hour() {
        String result = TimeFormatter.formatDuration(90000);
        Assertions.assertEquals("1 day and 1 hour", result);
    }

    @Test
    void shouldReturn1Day1HourAnd1Second() {
        String result = TimeFormatter.formatDuration(90001);
        Assertions.assertEquals("1 day, 1 hour and 1 second", result);
    }

    @Test
    void shouldReturn1Day1Hour1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(90061);
        Assertions.assertEquals("1 day, 1 hour, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Day1Hour1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(90062);
        Assertions.assertEquals("1 day, 1 hour, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn1Day1Hour2MinutesAnd1Second() {
        String result = TimeFormatter.formatDuration(90121);
        Assertions.assertEquals("1 day, 1 hour, 2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn1Day1Hour2MinutesAnd2Seconds() {
        String result = TimeFormatter.formatDuration(90122);
        Assertions.assertEquals("1 day, 1 hour, 2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn1Day2Hours1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(
                1 * 24 * 60 * 60 + +2 * 60 * 60 + 1 * 60 + 1);
        Assertions.assertEquals("1 day, 2 hours, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Day2Hours1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(
                1 * 24 * 60 * 60 + +2 * 60 * 60 + 1 * 60 + 2);
        Assertions.assertEquals("1 day, 2 hours, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn2Days1Hour1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +1 * 60 * 60 + 1 * 60 + 1);
        Assertions.assertEquals("2 days, 1 hour, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn2Days1Hour1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +1 * 60 * 60 + 1 * 60 + 2);
        Assertions.assertEquals("2 days, 1 hour, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn2Days1Hour2MinutesAnd1Second() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +1 * 60 * 60 + 2 * 60 + 1);
        Assertions.assertEquals("2 days, 1 hour, 2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn2Days1Hour2MinutesAnd2Seconds() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +1 * 60 * 60 + 2 * 60 + 2);
        Assertions.assertEquals("2 days, 1 hour, 2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn2Days2Hours1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +2 * 60 * 60 + 1 * 60 + 1);
        Assertions.assertEquals("2 days, 2 hours, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn2Days2Hours1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +2 * 60 * 60 + 1 * 60 + 2);
        Assertions.assertEquals("2 days, 2 hours, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn2Days2Hours2MinutesAnd1Second() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +2 * 60 * 60 + 2 * 60 + 1);
        Assertions.assertEquals("2 days, 2 hours, 2 minutes and 1 second", result);
    }

    @Test
    void shouldReturn2Days2Hours2MinutesAnd2Seconds() {
        String result = TimeFormatter.formatDuration(
                2 * 24 * 60 * 60 + +2 * 60 * 60 + 2 * 60 + 2);
        Assertions.assertEquals("2 days, 2 hours, 2 minutes and 2 seconds", result);
    }

    @Test
    void shouldReturn1Day1HourAnd1Minute() {
        String result = TimeFormatter.formatDuration(90060);
        Assertions.assertEquals("1 day, 1 hour and 1 minute", result);
    }

    @Test
    void shouldReturn1Year() {
        String result = TimeFormatter.formatDuration(31536000);
        Assertions.assertEquals("1 year", result);
    }

    @Test
    void shouldReturn1Year1Second() {
        String result = TimeFormatter.formatDuration(31536001);
        Assertions.assertEquals("1 year and 1 second", result);
    }

    @Test
    void shouldReturn1Year1Minute() {
        String result = TimeFormatter.formatDuration(31536060);
        Assertions.assertEquals("1 year and 1 minute", result);
    }

    @Test
    void shouldReturn1Year1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(31536061);
        Assertions.assertEquals("1 year, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Year1Hour1MinuteAnd2Seconds() {
        String result = TimeFormatter.formatDuration(31539662);
        Assertions.assertEquals("1 year, 1 hour, 1 minute and 2 seconds", result);
    }

    @Test
    void shouldReturn1Year1Day1Hour1MinuteAnd1Second() {
        String result = TimeFormatter.formatDuration(31626061);
        Assertions.assertEquals("1 year, 1 day, 1 hour, 1 minute and 1 second", result);
    }

    @Test
    void shouldReturn1Year1Day1HourAnd2Seconds() {
        String result = TimeFormatter.formatDuration(31626002);
        Assertions.assertEquals("1 year, 1 day, 1 hour and 2 seconds", result);
    }

    @Test
    void shouldReturn1Year1Day1HourAnd1Minute() {
        String result = TimeFormatter.formatDuration(31626060);
        Assertions.assertEquals("1 year, 1 day, 1 hour and 1 minute", result);
    }
}