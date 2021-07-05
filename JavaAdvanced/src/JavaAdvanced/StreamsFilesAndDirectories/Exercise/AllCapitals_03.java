package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        //Path outputPathFile = Path pathFile = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        List<String> lines = Files.readAllLines(pathFile);
        File outPutFile = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        PrintWriter writer = new PrintWriter(outPutFile);
        lines.forEach(line ->{
            writer.println(line.toUpperCase());
        });
        writer.close();

    }
}
