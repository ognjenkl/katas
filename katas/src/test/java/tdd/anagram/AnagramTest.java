package tdd.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Code takes one word as an input.
Reads a list of words, look for anagrams of the input in the list.
Prints out how many anagrams it found and enlists them all.
 */
public class AnagramTest {

    private Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }

    @Test
    void givenNullWord_whenFindAllAnagrams_thenNoWordException() {
        String word = null;
        assertThrows(Anagram.NoWordException.class, () -> anagram.findAllAnagrams(word, null));
    }

    @Test
    void givenNullWordList_whenFindAllAnagrams_thenNoWordListException() {
        String word = "word";
        assertThrows(Anagram.NoWordListException.class, () -> anagram.findAllAnagrams(word, null));
    }

    @Test
    void givenEmptyWordList_whenFindAllAnagrams_thenEmptyWordListException() {
        String word = "word";
        assertThrows(Anagram.EmptyWordListException.class, () -> anagram.findAllAnagrams(word, List.of()));
    }

    @Test
    void shouldFindTheSameAnagram() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of(word));
        assertEquals(1, anagrams.size());
        assertEquals(word, anagrams.get(0));
    }

    @Test
    void shouldFindNoAnagram() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of("wrd"));
        assertEquals(0, anagrams.size());
    }

    @Test
    void shouldFindOneAnagram() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of("wrod"));
        assertEquals(1, anagrams.size());
    }

    @Test
    void shouldFindNoAnagramSameLength() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of("wlod"));
        assertEquals(0, anagrams.size());
    }

    @Test
    void shouldFindTwoAnagrams() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of("wrod", "dwro"));
        assertEquals(2, anagrams.size());
    }

    @Test
    void shouldFindThreeAnagrams() {
        String word = "word";
        List<String> anagrams = anagram.findAllAnagrams(word, List.of("word", "wrod", "dwro"));
        assertEquals(3, anagrams.size());
    }

    @Test
    void shouldFindAndPrintTwoAnagrams() {
        String word = "word";
        Print console = new Console();
        List<String> anagrams = anagram.findAllAnagramsAndPrint(word, List.of("wrod", "dwro"), console);
        assertEquals(2, anagrams.size());
        assertEquals("wrod", anagrams.get(0));
        assertEquals("dwro", anagrams.get(1));
        System.out.println(anagrams);
    }

    @Test
    void shouldFindAndPrintToFileTwoAnagrams() {
        String word = "word";
        String filePath = "filePath";
        FakeFile file = new FakeFile(filePath);
        List<String> anagrams = anagram.findAllAnagramsAndPrint(word, List.of("wrod", "dwro"), file);
        assertEquals(2, anagrams.size());
        assertEquals("wrod", anagrams.get(0));
        assertEquals("dwro", anagrams.get(1));


        System.out.println(file.read());
    }

    @Test
    void shouldReadListFromFileAndWriteAnagramsToOtherFile() {
        String word = "word";
        FakeFile inputFakeFile = new FakeFile("words.txt");
        inputFakeFile.write(List.of("wrod", "dwro", "falseWord"));
        FakeFile outputFakeFile = new FakeFile("anagrams.txt");

        String wordLine = inputFakeFile.read();
        List<String> wordList = List.of(wordLine.split(", "));
        List<String> anagrams = anagram.findAllAnagramsAndPrint(word, wordList, outputFakeFile);

        String outputLine = outputFakeFile.read();
        List<String> outputList = List.of(outputLine.split("\n"));
        assertEquals("Found anagrams: 2", outputList.get(0));
        assertEquals("wrod, dwro", outputList.get(1));
    }
}
