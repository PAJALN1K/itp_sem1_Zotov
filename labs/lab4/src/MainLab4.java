package src;

import src.task1.ArrayAverage;
import src.task2.CopyOpenCloseFiles;
import src.task3.CatchCustomException;
import src.task3.CustomFileNotFoundException;

import java.io.*;
//import task3.FileManager;

public class MainLab4 {
    public static void main(String[] arg) {
        System.out.println("===TASK1: ARRAY AVERAGE===");
        ArrayAverage.main(new String[ ]{"3.4", "2.2", "7.1", "1.4", "4.6"});
        ArrayAverage.main(new String[ ]{"1.4", "3.2", "9.1", "9.4", "2.6"});
        ArrayAverage.main(new String[ ]{"2.1", "6.5", "asdfasdf"});

        String invalidHomePath = "C:/Users/sprin/Документы/Программирование/ITiP/labs/lab4/helloWord";
        String correctHomePathTask2 = "C:/Users/sprin/Документы/Программирование/ITiP/labs/lab4/src/task2";
        String correctHomePathTask3 = "C:/Users/sprin/Документы/Программирование/ITiP/labs/lab4/src/task3";

        System.out.println("\n===TASK2: COPY OPEN CLOSE===");
        CopyOpenCloseFiles.main(correctHomePathTask2, new String[]{
                "Jingle bells, jingle bells",
                "Jingle all the way"
        });
        CopyOpenCloseFiles.main(invalidHomePath, new String[]{
                "Lights are turn down low",
                "Let it snow, let it snow, let it snow"
        });

        System.out.println("\n===TASK3: CUSTOM EXCEPTION===");
        CatchCustomException.main(correctHomePathTask3);
        CatchCustomException.main(invalidHomePath);
    }
}
