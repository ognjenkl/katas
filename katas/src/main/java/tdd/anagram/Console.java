package tdd.anagram;

import java.util.List;

public class Console implements Print {
    @Override
    public void print(List<String> anagrams) {
        System.out.println("Found anagrams: " + anagrams.size());
        System.out.println(anagrams);
    }
}
