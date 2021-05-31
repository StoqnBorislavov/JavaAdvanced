package SetsAndMapsAdvanced.Exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive_13 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        File file2 = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        File file3 = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        File f = new File("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\testZip.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry entry1 = new ZipEntry("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        ZipEntry entry2 = new ZipEntry("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        ZipEntry entry3 = new ZipEntry("C:\\Users\\Stoqn\\Desktop\\SoftUni - Java Advanced\\4.StreamFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        out.putNextEntry(entry1);
        out.putNextEntry(entry2);
        out.putNextEntry(entry3);
        out.close();
    }
}
