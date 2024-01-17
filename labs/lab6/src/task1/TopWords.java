package src.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String filePath) {
        File file = new File(filePath);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        HashMap<String, Integer> wordsMap = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Z\']", "");
            if (wordsMap.containsKey(word)) {
                int oldCount = wordsMap.get(word);
                wordsMap.put(word, oldCount+1);
            }
            else {
                wordsMap.put(word, 1);
            }
        }
        scanner.close();

        ArrayList<HashMap.Entry<String, Integer>> listOfMaps = new ArrayList<>(wordsMap.entrySet());
        for (int i = 0; i < listOfMaps.toArray().length-1; i++) {
            for (int j = i + 1; j < listOfMaps.toArray().length; j++) {
                int count1 = listOfMaps.get(i).getValue();
                int count2 = listOfMaps.get(j).getValue();
                if (count1 < count2) Collections.swap(listOfMaps, i, j);
            }
        }

        System.out.println("-----Top 10 " + file.getName() + " words-----");
        for (int i = 0; i < listOfMaps.toArray().length; i++) {
            if (i > 9) break;

            String outputString = String.format("%s: %s - %s times", i+1, listOfMaps.get(i).getKey(), listOfMaps.get(i).getValue());
            System.out.println(outputString);
        }
    }
}
