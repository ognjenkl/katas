package tdd.wordWrap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapAcceptanceTest {

    @ParameterizedTest
    @CsvSource({
            "test,7,test",
            "hello world,7hello\nworld",
            "a lot of words for a single line,10,a lot of\nwords for\na single\nline",
            "this is a test,4,this\nis a\ntest",
            "a longword,6,a long\nword",
            "areallylongword,6,areall\nylongw\nord",
            "greedy whenthewordistoolong,6,greedy\nwhenth\newordi\nstoolo\nng",
            "greedy whenthewordistoolong,7,greedy\nwhenthe\nwordist\noolong"
    })
    void givenTestAnd7_whenWrap_thenSuccess(String input, Integer limit, String expected) {
        WordWrap wordWrap = new WordWrap();
        String result = wordWrap.wrap(input, limit);

        assertEquals(expected, result);
    }
}
