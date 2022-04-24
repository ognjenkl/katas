package tdd.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    public List<String> findAllAnagrams(String word, List<String> wordList) {
        checkInputWordAndList(word, wordList);
        return checkForAnagrams(word, wordList);
    }

    private List<String> checkForAnagrams(String word, List<String> wordList) {
        List<String> retList = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for (String w : wordList) {
            if (isAnagram(wordArray, w.toCharArray()))
                retList.add(w);
        }
        return retList;
    }

    private Boolean isAnagram(char[] first, char[] second) {
        if (first.length != second.length)
            return false;
        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < first.length; i++)
            if (first[i] != second[i])
                return false;
        return true;
    }

    private void checkInputWordAndList(String word, List<String> list) {
        if (word == null)
            throw new NoWordException();
        if (list == null)
            throw new NoWordListException();
        if (list.isEmpty())
            throw new EmptyWordListException();
    }

    public List<String> findAllAnagramsAndPrint(String word, List<String> wordList, Print print) {
        List<String> anagrams = findAllAnagrams(word, wordList);
        print.print(anagrams);
        return anagrams;
    }

    public class NoWordException extends RuntimeException {
    }

    public class NoWordListException extends RuntimeException {
    }

    public class EmptyWordListException extends RuntimeException {
    }
}
