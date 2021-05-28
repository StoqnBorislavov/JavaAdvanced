package StreamsFilesAndDirectories.Lab;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();

        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }
    }
}
