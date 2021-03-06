package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> separators = Set.of(',','.','!','?');
        int nextByte = inputStream.read();


        PrintStream printStream = new PrintStream("out.txt");
        while (nextByte != -1){
            char symbol = (char)nextByte;
            if(!separators.contains(symbol)){
                printStream.print(symbol);
            }
            nextByte = inputStream.read();
        }
    }
}
