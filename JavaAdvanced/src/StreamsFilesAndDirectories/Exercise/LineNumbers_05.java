package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(pathFile);
        PrintWriter writer = new PrintWriter("outputLines.txt");
        int row = 1;
        for (String line : lines) {
            writer.println(row++ + ". " + line);
        }
        writer.close();

    }
}
