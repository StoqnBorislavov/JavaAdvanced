package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream  = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        List<String> lines = new ArrayList<>();

        while (line != null){
             lines.add(line);

            line = reader.readLine();
        }
        Collections.sort(lines);
        Files.write(Path.of("sorted-lines-out.txt"),  lines);
    }
}
