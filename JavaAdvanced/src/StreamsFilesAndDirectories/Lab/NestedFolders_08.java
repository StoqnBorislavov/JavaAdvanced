package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class NestedFolders_08 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);

        PrintStream printStream = new PrintStream("nested-out.txt");
        int counter = 0;
        while (!files.isEmpty()){
            File innerFile = files.poll();
            for (File f : innerFile.listFiles()) {
                if(f.isDirectory()) {
                    files.offer(f);
                    counter++;
                    printStream.println(f.getName());
                }
            }
        }
        printStream.println(counter + " folders");
    }
}
