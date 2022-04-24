package tdd.anagram;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramFileTest {
    private Anagram anagram;

    public AnagramFileTest() {
        this.anagram = new Anagram();
    }

    @Test
    void shouldReadListFromFileAndWriteAnagramsToOtherFile() throws IOException {
        String word = "word";
        AnagramFile inputFile = new AnagramFile("words.txt");
        inputFile.write(List.of("wrod", "dwro", "falseWord"));
        AnagramFile outputFile = new AnagramFile("anagrams.txt");

        String wordLine = inputFile.read();
        List<String> wordList = List.of(wordLine.split(", "));
        List<String> anagrams = anagram.findAllAnagramsAndPrint(word, wordList, outputFile);

        String outputLine = outputFile.read();
        List<String> outputList = List.of(outputLine.split("\n"));
        assertEquals("Found anagrams: 2", outputList.get(0));
        assertEquals("wrod, dwro", outputList.get(1));
    }

}
