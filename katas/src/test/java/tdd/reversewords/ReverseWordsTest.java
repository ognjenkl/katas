package tdd.reversewords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsTest {

    private ReverseWords reverseWords;

    @BeforeEach
    void setUp() {
        reverseWords = new ReverseWords();
    }

    @Test
    void reverseWords_EmptyString() {
        assertEquals("", reverseWords.reverseWords(""));
    }

    @Test
    void reverseWords_OneWord() {
        assertEquals("word", reverseWords.reverseWords("word"));
    }

    @Test
    void reverseWords_TwoWords() {
        assertEquals("2 1", reverseWords.reverseWords("1 2"));
    }

    @Test
    void reverseWords_FiveWords() {
        assertEquals("5 4 3 2 1", reverseWords.reverseWords("1 2 3 4 5"));
    }
}
