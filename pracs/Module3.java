import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Module3 {
    public static String replaceVovels(String s) {
        String alphabet = "aeiouyAEIOUY";
        for (int i = 0; i < alphabet.length(); i++) {
            if (s.indexOf(alphabet.charAt(i)) != -1)
                s = s.replace(alphabet.charAt(i), '*');
        }
        return s;
    }

    public static String stringTransform(String s) {
        StringBuilder result = new StringBuilder();
        s += " ";

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                result.append("Double");
                result.append(Character.toUpperCase(s.charAt(i)));
                i += 1;
            }
            else result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static boolean doesBlockFit(int[] parallelepipedSides, float[] rectangleSides) {
        Arrays.sort(parallelepipedSides);
        Arrays.sort(rectangleSides);
        for (int i = 0; i < rectangleSides.length; i++) {
            if (parallelepipedSides[i] > rectangleSides[i]) return false;
        }
        return true;
    }

    public static boolean numCheck(int num) {
        int sum = 0;
        String sNum = Integer.toString(num);

        for (int i = 0; i < sNum.length(); i++) {
            int divide = Character.getNumericValue(sNum.charAt(i));
            sum += divide * divide;
        }

        return num % 2 == sum % 2;
    }

    public static int countRoots(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (a == 0) {
            if (b == 0) {
                if (c == 0) return -1; // значение "-1" означает, что целочисленных решений бесконечное количество;
                else return 0;
            }
            else {
                if (-c % b == 0) return 1;
                else return 0;
            }
        }
        else {
            int D = b*b - 4*a*c;

            if (D == 0 && (-b % (2*a) == 0)) return 1;

            int roots = 0;
            if (((-b - Math.sqrt(D)) % (2*a)) == 0) roots += 1;
            if (((-b + Math.sqrt(D)) % (2*a)) == 0) roots += 1;
            return roots;
        }
    }

    public static void salesData(String[][] arr) {
        ArrayList<String> shops = new ArrayList<>();
        for (String[] arrInArr : arr) {
            for (int i = 1; i < arrInArr.length; i++) shops.add(arrInArr[i]);
        }

        for (String[] arrInArr : arr) {
            if(arrInArr.length == shops.stream().distinct().count() + 1)
                System.out.print(arrInArr[0] + " ");
        }
        System.out.println();
    }

    public static boolean validSplit(String s) {
        String[] stringArr = s.split(" ");
        char[] firstChars = new char[stringArr.length];
        char[] lastChars = new char[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            String word = stringArr[i];
            firstChars[i] = word.charAt(0);
            lastChars[i] = word.charAt(word.length() - 1);
        }

        int count = 0;
        for (int i = 0; i < firstChars.length; i++) {
            for (int j = 0; j < lastChars.length; j++) {
                if (firstChars[i] == lastChars[j]) {
                    lastChars[j] = ' ';
                    count += 1;
                    break;
                }
            }
        }

        return (count >= stringArr.length - 1);
    }

    public static boolean waveForm(int[] arr) {
        if (arr.length < 3) return false;

        // Пускай дан последовательный набор из чисел x0, x1 и x2.
        // Обозначим пары чисел: prevCouple(x0, x1) и curCouple(x1, x2).
        boolean isPrevCoupleAsc = arr[0] < arr[1];

        for (int i = 2; i < arr.length; i++) {
            boolean isCurCoupleAsc = arr[i-1] < arr[i];
            if (isPrevCoupleAsc == isCurCoupleAsc) return false;
            isPrevCoupleAsc = isCurCoupleAsc;
        }

        return true;
    }

    public static String commonVowel(String s) {
        char[] charArr = s.toLowerCase().toCharArray();
        String alphabet = "aeiouy";
//        HashMap<Character, Integer> hm = new HashMap<>();

        char maxChar = ' ';
        int maxCount = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            int count = 0;

            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == alphabet.charAt(i)) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = alphabet.charAt(i);
            }

//            hm.put(alphabet.charAt(i), count);
        }

        return Character.toString(maxChar);

//        for (char ch: hm.keySet()) {
//            if (hm.get(ch) == maxCount) return Character.toString(ch);
//        }
//        return "There is no vowels in the string!";
    }

    public static void dataScience(int[][] arrArr) {
        for (int i = 0; i < arrArr.length; i++) {
            int sum = 0;

            for (int j = 0; j < arrArr[i].length; j++) {
                if (i !=  j) sum += arrArr[j][i];
            }

            int arMean = Math.round(sum / (float) (arrArr[i].length - 1));
            arrArr[i][i] = arMean;
        }

        for (int[] arr: arrArr) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }
}
