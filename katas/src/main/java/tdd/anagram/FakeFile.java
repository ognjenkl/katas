package tdd.anagram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeFile implements Print {
    Map<String, String> fileMap = new HashMap<>();
    private String filePath;

    public FakeFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void print(List<String> anagrams) {
        StringBuilder line = new StringBuilder("Found anagrams: " + anagrams.size() + "\n");
        for(String word : anagrams)
            line.append(word).append(", ");
        line.delete(line.length() - 2, line.length());
        fileMap.put(filePath, line.toString());
    }

    public String read() {
        return fileMap.get(filePath);
    }

    public void write(List<String> wordList) {
        StringBuilder line = new StringBuilder();
        for(String word : wordList)
            line.append(word).append(", ");
        line.delete(line.length() - 2, line.length());
        fileMap.put(filePath, line.toString());
    }
}
