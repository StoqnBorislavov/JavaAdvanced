package StreamsFilesAndDirectories.Lab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\\\\\\\Users\\\\\\\\Stoqn\\\\\\\\Desktop\\\\\\\\SoftUni - Java Advanced\\\\\\\\4.StreamFilesAndDirectories\\\\\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\\\\\\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner sc = new Scanner(reader);

        while (sc.hasNext()){
            if(sc.hasNextInt()){
                System.out.println(sc.nextInt());
            }
            sc.next();
        }
    }
}
