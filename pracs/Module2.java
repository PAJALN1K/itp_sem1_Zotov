import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Module2 {
    public static boolean dublicateChars(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length-1; i++) {
            for (int j = i+1; j < charArray.length; j++) {
                if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(charArray[j])) return true;
            }
        }

        return false;
    }

    public static String getInitials(String nameSurname) {
        String[] nsArray = nameSurname.split(" ");
        return Character.toString(nsArray[0].charAt(0)) + Character.toString(nsArray[1].charAt(0));
    }

    public static int differenceEvenOdd(int[] intArray) {
        int diff = 0;

        for (int num: intArray) {
            if (num % 2 == 0) diff += num;
            else  diff -= num;
        }

        return Math.abs(diff);
    }

    public static boolean equalToAvg(int[] intArray) {
        float arithmMean = (float) IntStream.of(intArray).sum() / (float) intArray.length;
        if ((int)arithmMean != arithmMean) return false;

        for (int num: intArray) {
            if (num == arithmMean) return true;
        }

        return false;
    }

    public static int[] indexMult(int[] intArray) {
        int[] newArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            newArray[i] = i * intArray[i];
        }

        return newArray;
    }

    public static String reverse(String s) {
        char[] sCharArr = s.toCharArray();
        char[] newArr = new char[sCharArr.length];

        for (int i = 0; i < sCharArr.length; i++) {
            newArr[i] = sCharArr[sCharArr.length-1-i];
        }

        return new String(newArr);
    }

    public static int Tribonacci(int index) {
        if (index == 1) return 0;
        else if (index == 2) return 0;
        else if (index == 3) return 1;
        else {
            int[] arr = new int[index];
            arr[0] = 0;
            arr[1] = 0;
            arr[2] = 1;

            for (int i = 3; i < arr.length; i++) {
                arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
            }

            return arr[index-1];
        }
    }

    public static String pseudoHash(int len) {
        String result = "";
        String[] charsList = new String[] {"a", "b", "c", "d", "e", "f", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random r = new Random();

        for (int i = 0; i < len; i++) {
            result += charsList[r.nextInt(charsList.length)];
        }

        return result;
    }

    public static String botHelper(String s) {
        s = s.replaceAll("[!#%&'\"()*+-/<>=_?.,~`@№]", "");
        String[] words = s.split(" ");
        for (String i: words) {
            if (i.equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() == b.length()) {
            char[] charsListA = a.toCharArray();
            Arrays.sort(charsListA);

            char[] charsListB = b.toCharArray();
            Arrays.sort(charsListB);

            return (Arrays.equals(charsListA, charsListB));
        }
        else return false;
    }
}
