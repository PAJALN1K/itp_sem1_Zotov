package src.task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CatchCustomException {
    public static void main(String homePath) {
        try {
            File txt = new File(homePath + "/txt.txt");
            try {
                BufferedReader br = new BufferedReader(new FileReader(txt));

                String line;
                try {
                    System.out.println("[CatchCustomExceptionProgram] The data in the given file is:");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
//                        Files.delete(Path.of(txt.getPath()));
                    }
                    System.out.println("[CatchCustomExceptionProgram] The file has been read completely!");
                }
                catch (IOException e) {System.out.println("[CatchCustomExceptionProgram] Error during reading file.");}
            }
            catch (FileNotFoundException e) {
                throw new CustomFileNotFoundException(String.format(
                        "[CatchCustomExceptionProgram] Error: the file with given path %s doesn't exist. Please, make sure, that you have inputted correct value.",
                        txt.getPath()));
            }
        }
        catch (CustomFileNotFoundException e) {
            System.out.println(e);
        }
    }
}
