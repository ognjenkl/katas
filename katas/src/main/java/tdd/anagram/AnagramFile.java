package tdd.anagram;

import java.io.*;
import java.util.List;

public class AnagramFile implements Print {
    private String filePath;

    public AnagramFile(String filePath) {
        this.filePath = filePath;
    }

    public void write(List<String> wordList) throws IOException {
        File file = new File(filePath);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            StringBuilder line = new StringBuilder();
            for (String word : wordList)
                line.append(word).append(", ");
            line.delete(line.length() - 2, line.length());
            out.write(line.toString());
        }
    }

    public String read() throws IOException {
        File file = new File(filePath);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line).append("\n");
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    @Override
    public void print(List<String> anagrams) {
        File file = new File(filePath);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            StringBuilder line = new StringBuilder("Found anagrams: " + anagrams.size() + "\n");
            for (String word : anagrams)
                line.append(word).append(", ");
            line.delete(line.length() - 2, line.length());
            out.write(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
