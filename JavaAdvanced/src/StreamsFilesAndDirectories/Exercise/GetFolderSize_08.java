package StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(folderPath);

        long size = 0;
        for(File file : folder.listFiles()){
            size += file.length();
        }
        System.out.println("Folder size: " + size);
    }
}
