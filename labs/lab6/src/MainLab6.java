package src;

import src.task1.TopWords;
import src.task2.Task2;
import src.task3.Task3;

public class MainLab6 {
    public static void main(String[] args) {
        System.out.println("===TASK1: TOP WORDS===");
        TopWords.main("C:/Users/sprin/Документы/Программирование/ITiP/labs/lab6/src/task1/wordsFile.txt");

        System.out.println("\n===TASK2: STACK===");
        Task2.main();

        System.out.println("\n===TASK3: SALES ORGANIZER===");
        Task3.main(
            new String[] {"Apple", "Banana", "Chicken", "Olives", "Eggs", "Cheese", "Meal", "Oats"},
            new int[] {20, 30, 370, 150, 110, 310, 90, 70},
            new int[] {37, 26, 13, 5, 30, 28, 15, 19}
        );
    }
}
