package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        long sum = 0;
        byte[] bytes = Files.readAllBytes(pathFile);
        for (byte value : bytes) {
            if(value == 10 || value == 13){
                continue;
            }
            sum += value;
        }
        System.out.println(sum);
    }
}
