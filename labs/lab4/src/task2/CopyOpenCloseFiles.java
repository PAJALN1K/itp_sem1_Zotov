package src.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyOpenCloseFiles {

    public static void main(String homePath, String[] data) {
        File initialFile = new File(homePath + "/InitialFile.txt");
        File terminalFile = new File(homePath + "/TerminalFile.txt");

        try {
            PrintWriter pw = new PrintWriter(initialFile);

            for (String line: data) {
                pw.println(line);
            }

            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(String.format(
                    "[CopyOpenCloseFilesProgram] Error: file with given path %s doesn't exist. Please, make sure, that you have inputted correct value.",
                    initialFile.getPath()
                ));
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(initialFile));
            PrintWriter pw = new PrintWriter(terminalFile);

            String line;
            try {
                while ((line = br.readLine()) != null) {
                    pw.println(line);
//                    Files.delete(Path.of(initialFile.getPath()));
                }
                pw.close();
                try {
                    Files.delete(Path.of(initialFile.getPath()));
                    br.close();
                    System.out.println("[CopyOpenCloseFilesProgram] The data has been copied successfully!");
                }
                catch (IOException e) {
                    System.out.println("[CopyOpenCloseFilesProgram] Error during closing file.");
                }
            }
            catch (IOException e) {
                System.out.println("[CopyOpenCloseFilesProgram] Error during copying data!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("[CopyOpenCloseFilesProgram] Error: one or both of the files with given path don't exist. Please, make sure, that you have inputted correct values.");
        }
    }
}
