package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");

        List<String> lines = Files.readAllLines(pathFile);

        Map<String, Integer> wordsCount  = new LinkedHashMap<>();

        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                word = word.replace(",", "");
                wordsCount.put(word, 0);
            }
        }
        Path searchedPath = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> searchedWords = Files.readAllLines(searchedPath);
        for (String line : searchedWords) {
            Arrays.stream(line.split("\\s+")).forEach(word ->{
                if(wordsCount.containsKey(word)){
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            });

        }
        PrintWriter writer = new PrintWriter("results.txt");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
           writer.println(entry.getKey() + " - " + entry.getValue());
        }
        writer.close();

    }
}
