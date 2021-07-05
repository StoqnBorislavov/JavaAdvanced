package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        String vowelsTypes = "aeiou";
        String punctuationTypes = "!,.?";
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                for (char symbol : word.toCharArray()) {
                    String charAsString = String.valueOf(symbol);
                    if (vowelsTypes.contains(charAsString)) {
                        vowels++;
                    } else if (punctuationTypes.contains(charAsString)) {
                        punctuation++;
                    } else {
                        consonants++;
                    }
                }
            }
            line = reader.readLine();
        }
        reader.close();
        PrintWriter writer = new PrintWriter("outputCount.txt");
        writer.println("Vowels: " + vowels);
        writer.println("Consonants: " + consonants);
        writer.println("Punctuation: " + punctuation);
        writer.close();
    }
}
