package tdd.wordWrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Your job is to write a function that takes a string and a maximum number of characters per line and then
 * inserts line breaks as necessary so that no line in the resulting string is longer than the specified limit.
 * <p>
 * If possible, line breaks should not split words. However, if a single word is longer than the limit, it obviously
 * has to be split. In this case, the line break should be placed after the first part of the word (see examples below).
 * <p>
 * Really long words may need to be split multiple times.
 * <p>
 * Input
 * A word consists of one or more letters.
 * The input text will be the empty string or a string consisting of one or more words separated by single spaces.
 * It will not contain any punctuation or other special characters.
 * The limit will always be an integer greater or equal to one.
 * <p>
 * Rules
 * Fit as many words as you can on a single line.
 * Always try to break on spaces.
 * If a single word is longer than a line, break it apart by appending as much of it as possible to the previous line,
 * then break it again if it still doesn't fit the current line, etc.
 * Lines must not contain leading or trailing spaces.
 * <p>
 * Examples
 * Note: Line breaks in the results have been replaced with two backslashes, \\, to improve readability.
 * <p>
 * ("test", 7)            -> "test"
 * ("hello world", 7)     -> "hello\\world"
 * ("a lot of words for a single line", 10) -> "a lot of\\words for\\a single\\line"
 * <p>
 * ("this is a test", 4)  -> "this\\is a\\test"
 * ("a longword", 6)      -> "a long\\word"
 * ("areallylongword", 6) -> "areall\\ylongw\\ord"
 * <p>
 * ("greedy whenthewordistoolong", 6) -> "greedy\\whenth\\ewordi\\stoolo\\ng"
 * ("greedy whenthewordistoolong", 7) -> "greedy\\whenthe\\wordist\\oolong"   (=> no trailing space)
 * Note: Sometimes spaces are hard to see in the test results window.
 */
public class WordWrapTest {

    WordWrap wordWrap;

    @BeforeEach
    void setUp() {
        wordWrap = new WordWrap();
    }

    @Test
    void givenNullInputAndNullLimit_whenWrap_thenThrowLimitException() {

        assertThrows(WordWrap.LimitException.class, () -> wordWrap.wrap(null, null));
    }

    @Test
    void givenNullInputAndZeroLimit_whenWrap_thenThrowLimitException() {
        assertThrows(WordWrap.LimitException.class, () -> wordWrap.wrap(null, 0));
    }

    @Test
    void givenNullInput_whenWrap_thenThrowException() {
        assertThrows(WordWrap.InputException.class, () -> wordWrap.wrap(null, 1));
    }

    @Test
    void givenInputTest_whenWrap_thenReturnTest() {
        String expected;
        expected = "test";
        String result = wordWrap.wrap("test", 7);

        assertEquals(expected, result);
    }

    @Test
    void givenTestWithTrailingSpaces_whenWrap_thenReturnTestWithoutTrailingSpaces() {
        String expected = "test";
        String result = wordWrap.wrap("  test   ", 7);

        assertEquals(expected, result);
    }

    @Test
    void givenTwoWords_whenWrap_thenReturnTwoLines() {
        String expected = "hello\\nworld";
        String result = wordWrap.wrap("hello world", 7);

        assertEquals(expected, result);

    }

    @Test
    void givenMultipleWords_whenWrap_thenReturnOneLine() {
        String expected = "hello new world";
        String input = "hello new world";

        String result = wordWrap.wrap(input, 27);

        assertEquals(expected, result);
    }

    @Test
    void givenThreeWords_whenWrap_thenSeparateOnFirstSpace() {
        String expected = "hello\\nwor ld";
        String input = "hello wor ld";

        String result = wordWrap.wrap(input, 6);

        assertEquals(expected, result);
    }

    @Test
    void givenThreeWords_whenWrap_thenSeparateOnLastSpace() {
        String expected = "hello wor\\nld";
        String input = "hello wor ld";

        String result = wordWrap.wrap(input, 10);

        assertEquals(expected, result);
    }

    @Test
    void givenTwoWords_whenWrap_thenSeparateOnLastWord() {
        String expected = "hello new\\nworld";
        String input = "hello new world";

        String result = wordWrap.wrap(input, 12);

        assertEquals(expected, result);
    }

    @Test
    void givenTreeWords_whenWrap_thenReturnThreeLines() {
        String expected = "hello\\nnew\\nworld";
        String input = "hello new world";

        String result = wordWrap.wrap(input, 6);

        assertEquals(expected, result);
    }

    @Test
    void givenTwoWords_whenWordEndsOnLimit_thenBreakBeforeSpace() {
        String expected = "hello\\nworld";
        String input = "hello world";

        String result = wordWrap.wrap(input, 5);

        assertEquals(expected, result);
    }

    @Test
    void givenOneWord_whenLimitLessThanWordLength_thenBreakWord() {
        String expected = "hell\\no";
        String input = "hello";

        String result = wordWrap.wrap(input, 4);

        assertEquals(expected, result);
    }

    @Test
    void givenTwoWords_whenLimitLessThanFirstWordLength_thenBreakOnFirstWord() {
        String expected = "hell\\no w\\norld";
        String input = "hello world";

        String result = wordWrap.wrap(input, 4);

        assertEquals(expected, result);
    }
}
