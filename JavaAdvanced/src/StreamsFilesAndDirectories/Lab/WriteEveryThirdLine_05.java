package StreamsFilesAndDirectories.Lab;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\\\Users\\\\Stoqn\\\\Desktop\\\\SoftUni - Java Advanced\\\\4.StreamFilesAndDirectories\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\\\input.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (int i = 0; i < lines.size(); i++) {
            if((i+1) % 3 == 0){
                System.out.println(lines.get(i));
            }
        }

//        FileReader reader = new FileReader(path);
//        Scanner sc = new Scanner(reader);
//
//        PrintStream printStream = new PrintStream("third-line-out.txt")
//        int lineNumber = 0;
//        while (sc.hasNext()){
//            lineNumber++;
//            if(lineNumber % 3 == 0) {
//                printStream.println();
//            } else {
//                sc.nextLine();
//            }
//        }

    }
}
