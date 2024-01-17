import javax.swing.*;
import java.util.*;

public class Module5 {
    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char word1Letter = s1.charAt(i);
            char word2Letter = s2.charAt(i);
            if (charList.contains(word1Letter)) continue;
            s2 = s2.replace(word2Letter, word1Letter);
            charList.add(word1Letter);
        }

        return s1.equals(s2);
    }

    public static String spiderVsFly(String spider, String fly) {
        char[] radicalsArray = "ABCDEFGH".toCharArray();

        char spiderRadical = spider.charAt(0);
        int spiderRadicalIndex = AdditionalMethods.linearSearch(radicalsArray, spiderRadical);
        int spiderNum = spider.charAt(1) - '0';
        char flyRadical = fly.charAt(0);
        int flyRadicalIndex = AdditionalMethods.linearSearch(radicalsArray, flyRadical);
        int flyNum = fly.charAt(1) - '0';

        /** Логика числовых коэффициентов координат */
        if (spiderNum == 0 && spiderNum == flyNum) return "A0";
        if (spiderNum < flyNum) {
            String[] reversedFunction = spiderVsFly(fly, spider).split("-");
            String[] reversedArray = AdditionalMethods.reversedArray(reversedFunction);
            return String.join("-", reversedArray);
        }
        if (spiderNum > flyNum) {
            String lowerSpiderCoordinate = spiderRadical + Integer.toString((8+spiderNum-1)%8);
            return spider + "-" + spiderVsFly(lowerSpiderCoordinate, fly);
        };

        /** Логика радикалов координат */
        boolean isRadicalsEqual = spiderRadicalIndex == flyRadicalIndex;
        boolean isRadicalsOpposite = spiderRadicalIndex == (flyRadicalIndex + 4) % 8;
        boolean isRadicalsNeighbours1 = (flyRadicalIndex == (spiderRadicalIndex + 1) % 8) || (flyRadicalIndex == (spiderRadicalIndex - 1 + 8) % 8);
        boolean isRadicalsNeighbours2 = (flyRadicalIndex == (spiderRadicalIndex + 2) % 8 || flyRadicalIndex == (spiderRadicalIndex - 2 + 8) % 8);
        boolean isRadicalsNeighbours3 = (flyRadicalIndex == (spiderRadicalIndex + 3) % 8 || flyRadicalIndex == (spiderRadicalIndex - 3 + 8) % 8);
        int k = 1;

        if (isRadicalsEqual) return spider;
        else if (isRadicalsOpposite || isRadicalsNeighbours3) {
            int len = 2 * spiderNum + 1;
            String[] resultArray = new String[len];
            for (int i = 0; i < spiderNum+1; i++) {
                if (i == spiderNum) {
                    resultArray[i] = "A0";
                    break;
                }
                resultArray[i] = spiderRadical + Integer.toString(spiderNum-i);
                resultArray[len - 1 - i] = flyRadical + Integer.toString(spiderNum-i);
            }
            return String.join("-", resultArray);
        }
        else if (isRadicalsNeighbours1) {
            String[] resultArray = {spider, fly};
            return String.join("-", resultArray);
        }
        else {
            if (flyRadicalIndex == (spiderRadicalIndex - 2 + 8) % 8) k = -1;
            int stoppingPointIndex = (8 + spiderRadicalIndex + k) % 8;
            String stoppingPoint = radicalsArray[stoppingPointIndex] + String.valueOf(spiderNum);
            String[] resultArray = {spider, stoppingPoint, fly};
            return String.join("-", resultArray);
        }
    }

    public static int digitsCount(int num) {
        if (num / 10 != 0) return 1 + digitsCount(num / 10);
        return 1;
    }

    public static long digitsCount(long num) {
        if (num / 10 != 0) return 1 + digitsCount(num / 10);
        return 1;
    }

    public static int totalPoints(String[] array, String key) {
        int score = 0;
        ArrayList<String> sixLenWords = new ArrayList<>();
        boolean isThereAKey = false;

        for (String word: array) {
            boolean lengthLimitOk = 3 <= word.length() && word.length() <= 6;

            if (AdditionalMethods.doLettersEqual(word, key) && lengthLimitOk) {
                score += word.length() - 2;
                if (word.length() == 6) {
                    sixLenWords.add(word);
                    if (word.equals(key)) isThereAKey = true;
                }
            }
        }
        if (isThereAKey) score += sixLenWords.size() * 50;

        return score;
    }

    public static void sumsUp(int[] array) {
        ArrayList<int[]> listOfArrs = new ArrayList<>();

        for (int i = 0; i < array.length-1; i++) {
            int num1 = array[i];
            int num2 = 8-num1;
            int indexOfLast = AdditionalMethods.linearSearch(array, i+1,num2);
            if (indexOfLast != -1) {
                int[] subArray = new int[] {num2, num1, i, indexOfLast};
                listOfArrs.add(subArray);
            }
        }

        int len = listOfArrs.toArray().length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int i1 = listOfArrs.get(i)[2];
                int j1 = listOfArrs.get(i)[3];
                int i2 = listOfArrs.get(j)[2];
                int j2 = listOfArrs.get(j)[3];

                if ((j2 < j1) || (j2 == j1 && i2 < i1)) {
                    Collections.swap(listOfArrs, i, j);
                }
            }
        }

        int[][] arrOfArrs = new int[listOfArrs.toArray().length][2];
        for (int i = 0; i < arrOfArrs.length; i++) {
            arrOfArrs[i] = Arrays.copyOfRange(listOfArrs.get(i),0, 2);
            Arrays.sort(arrOfArrs[i]);
        }

        AdditionalMethods.doubleArrayPrint(arrOfArrs);
    }

    public static String takeDownAverage(String[] array) {
        int sum = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(array[i].substring(0, array[i].length()-1));
            sum += num;
        }
        float result = (float)(len+1)*((float)sum/(float)len - 5) - sum;
        String resultString = Integer.toString(Math.round(result)) + "%";
        return resultString;
    }

    public static String caesarCipher(String command, String text, int shift) {
        char[] alphabetArr = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        text = text.toUpperCase();
        int commandCoef = 1;
        if (command == "decode") commandCoef *= -1;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char textCharI = text.charAt(i);
            if (Character.isLetter(textCharI)) {
                int pos1 = AdditionalMethods.linearSearch(alphabetArr, textCharI);
                int len = alphabetArr.length;
                int pos2 = (len + pos1 + (commandCoef * shift)) % len;
                char newChar = alphabetArr[pos2];

                result.append(newChar);
            }
            else {
                result.append(textCharI);
            }
        }

//        return text;
        return result.toString();
    }

    public static int setSetup(int n, int k) {
        if (k != 0) return n * setSetup(n-1, k-1);
        return 1;
    }

    public static String timeDifference(String cityA, String date1, String cityB) {
        HashMap<String, int[]> cityTimestamps = new HashMap<>();
        cityTimestamps.put("Los Angeles", new int[] {-8, 0});
        cityTimestamps.put("New York", new int[] {-5, 0});
        cityTimestamps.put("Caracas", new int[] {-4, -30});
        cityTimestamps.put("Buenos Aires", new int[] {-3, 0});
        cityTimestamps.put("London", new int[] {0, 0});
        cityTimestamps.put("Rome", new int[] {1, 0});
        cityTimestamps.put("Moscow", new int[] {3, 0});
        cityTimestamps.put("Tehran", new int[] {3, 30});
        cityTimestamps.put("New Delhi", new int[] {5, 30});
        cityTimestamps.put("Beijing", new int[] {8, 0});
        cityTimestamps.put("Canberra", new int[] {10, 0});

        HashMap<String, int[]> monthsNumLogic = new HashMap<>();
        monthsNumLogic.put("January", new int[] {1, 31});
        monthsNumLogic.put("February", new int[] {2, 28});
        monthsNumLogic.put("March", new int[] {3, 31});
        monthsNumLogic.put("April", new int[] {4, 30});
        monthsNumLogic.put("May", new int[] {5, 31});
        monthsNumLogic.put("June", new int[] {6, 30});
        monthsNumLogic.put("July", new int[] {7, 31});
        monthsNumLogic.put("August", new int[] {8, 31});
        monthsNumLogic.put("September", new int[] {9, 30});
        monthsNumLogic.put("October", new int[] {10, 31});
        monthsNumLogic.put("November", new int[] {11, 30});
        monthsNumLogic.put("December", new int[] {12, 31});

        // December 31, 1970 13:40 template
        String[] date1Array = date1.split(" ");
        int[] month1 = monthsNumLogic.get(date1Array[0]);
        int day1 = Integer.parseInt(date1Array[1].substring(0, date1Array[1].length()-1));
        int year1 = Integer.parseInt(date1Array[2]);
        if ((year1 % 400 == 0) || (year1 % 4 == 0 && year1 % 100 != 0)) {
            monthsNumLogic.put("February", new int[] {2, 29});
        }
        int hour1 = Integer.parseInt(date1Array[3].substring(0, 2));
        int minutes1 = Integer.parseInt(date1Array[3].substring(3, date1Array[3].length()));

        float hourMinDiff = cityTimestamps.get(cityB)[0] - cityTimestamps.get(cityA)[0] + (float)(cityTimestamps.get(cityB)[1] - cityTimestamps.get(cityA)[1]) /60f;

        // 1970-12-31 16:10 template
        int minutes2NoRound = minutes1 + (int)((hourMinDiff - (float)(int)hourMinDiff) * 60);
        int minutes2 = minutes2NoRound % 60;
        String minutes2ToString = Integer.toString(minutes2);
        if (minutes2 < 10) minutes2ToString = "0" + minutes2ToString;

        int hour2NoRound = hour1 + (int)hourMinDiff + minutes2NoRound / 60;
        int hour2 = hour2NoRound % 24;
        String hour2ToString = Integer.toString(hour2);
        if (hour2 < 10) hour2ToString = "0" + hour2ToString;

        int day2NoRound = day1 + hour2NoRound / 24;
        int day2 = (day2NoRound-1) % (monthsNumLogic.get(date1Array[0])[1]) + 1;
        int month2NoRound = month1[0] + (day2NoRound-1) / monthsNumLogic.get(date1Array[0])[1];
        int month2 = (month2NoRound-1) % 12 + 1;
        int year2 = year1 + (month2NoRound-1) / 12;

        String date2 = String.format("%s-%s-%s ", year2, month2, day2);
        date2 += String.format("%s:%s", hour2ToString, minutes2ToString);

        return date2;
    }

    public static boolean isNew(int num) {
        if (num <= 20) return true;
        String numToString = Integer.toString(num);

        char[] sortedNum = numToString.toCharArray();
        Arrays.sort(sortedNum);
        while (sortedNum[0] == '0') {
            for (int i = 0; i < sortedNum.length; i++) {
                if (sortedNum[i] != '0') {
                    sortedNum[i-1] = sortedNum[i];
                    sortedNum[i] = '0';
                    break;
                }
            }
        }

        int sortedNumToInt = Integer.parseInt( new String(sortedNum) );

        return num == sortedNumToInt;
    }
}
