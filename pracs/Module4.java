import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Module4 {
    public static String nonRepeatable(String s) {
        for (int i = 0; i < s.length(); i++) {
            char elem = Character.toLowerCase(s.charAt(i));
            int anotherElemIndex = s.indexOf(elem, i+1);

            if (anotherElemIndex != -1) {
                String s1 = s.substring(0, anotherElemIndex);
                String s2 = s.substring(anotherElemIndex+1, s.length());
                s = s1 + s2;

                return nonRepeatable(s);
            }
        }

        return s;
    }

    public static ArrayList<String> generateBrackets(int num) {
        if (num == 0) return new ArrayList<String>();
        if (num == 1) return new ArrayList<String>(Arrays.asList("()"));

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < generateBrackets(num-1).toArray().length; i++) {
            String elem = generateBrackets(num-1).get(i);
            String newElem = String.format("(%s)", elem);
            arr.add(newElem);
        }

        for (int i = 0; i < num / 2; i++) {
            int num1 = i + 1;
            int num2 = num - num1;
            for (int j = 0; j < generateBrackets(num1).toArray().length; j++) {
                String elem1 = generateBrackets(num1).get(j);
                for (int k = 0; k < generateBrackets(num2).toArray().length; k++) {
                    String elem2 = generateBrackets(num2).get(k);
                    String newElem1 = String.format("%s%s", elem1, elem2);
                    String newElem2 = String.format("%s%s", elem2, elem1);
                    arr.add(newElem1);
                    if (!newElem1.equals(newElem2)) arr.add(newElem2);
                }
            }
        }

        return new ArrayList<String>(arr.stream().distinct().sorted().collect(Collectors.toList()));
    }

    public static ArrayList<String> binarySystem(int num) {
        if (num == 0) return new ArrayList<String>();

        if (num == 1) {
            ArrayList<String> arr = new ArrayList<String>();
            for (int i = 0; i <= 1; i++) {
                arr.add(Integer.toString(i));
            }
            return arr;
        }

        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i <= 1; i++) {
            ArrayList<String> lowerArr = binarySystem(num-1);
            for (int j = 0; j < lowerArr.size(); j++) {
                String lowerElem = lowerArr.get(j);
                if (!(i == 0 && lowerElem.charAt(0) == '0')) {
                    String iToString = Integer.toString(i);
                    String elem = iToString + lowerElem;
                    arr.add(elem);
                }
            }
        }

        return arr;
    }

    public static String alphabeticRow(String s) {
        if (s.isEmpty()) return s;

        int maxCount = 0;
        String maxCountSubstring = "";

        for (int i = 0; i < s.length()-1; i++) {
            String substringAsc = Character.toString(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                String anotherDigit = Character.toString(s.charAt(j));
                if (s.charAt(j) - s.charAt(j-1) == 1) {
                    substringAsc += anotherDigit;
                    continue;
                }
                break;
            }
            if (maxCount < substringAsc.length()) {
                maxCount = substringAsc.length();
                maxCountSubstring = substringAsc;
            }

            String substringDesc = Character.toString(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                String anotherDigit = Character.toString(s.charAt(j));
                if (s.charAt(j-1) - s.charAt(j) == 1) {
                    substringDesc += anotherDigit;
                    continue;
                }
                break;
            }
            if (maxCount < substringDesc.length()) {
                maxCount = substringDesc.length();
                maxCountSubstring = substringDesc;
            }
        }

        return maxCountSubstring;
    }

    public static String crazySort(String s) {
        if (s.isEmpty()) return s;

        int count = 1;
        ArrayList<String> patternList = new ArrayList<String>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                count += 1;
                if (i == s.length() - 1) {
                    String pattern = Integer.toString(count) + s.charAt(i-1);
                    patternList.add(pattern);
                    break;
                }
            }
            else {
                String pattern = Integer.toString(count) + s.charAt(i-1);
                patternList.add(pattern);
                count = 1;
            }
        }

        Collections.sort(patternList);
        String result = "";
        for (String pattern: patternList) {
            result += Character.toString(pattern.charAt(1)) + pattern.charAt(0);
        }

        return result;
    }

    public static int convertToNum(String s) {
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] firstTens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] otherTens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String[] sArray = s.split(" ");
        int result = 0;

        for (int i = 0; i < sArray.length; i++) {
            String element = sArray[sArray.length - (i+1)];
            if (AdditionalMethods.linearSearch(ones, element) != -1) {
                result += AdditionalMethods.linearSearch(ones, element);
            }
            else if (AdditionalMethods.linearSearch(firstTens, element) != -1) {
                result += 10 + AdditionalMethods.linearSearch(firstTens, element);
            }
            else if (AdditionalMethods.linearSearch(otherTens, element) != -1) {
                result += 10 * (2 + AdditionalMethods.linearSearch(otherTens, element));
            }
            else if ("hundred".equals(element)) {
                result +=  100 * AdditionalMethods.linearSearch(ones, sArray[0]);
                break;
            }
        }

        return result;
    }

    public static String uniqueSubstring(String s) {
        if (s.isEmpty()) return s;

        int maxCount = 0;
        String maxCountSubstring = "";

        for (int i = 0; i < s.length()-1; i++) {
            String substring = Character.toString(s.charAt(i));
            int minLength = Math.min(9, s.length() - i);

            for (int j = i+1; j < i + minLength; j++) {
                String anotherDigit = Character.toString(s.charAt(j));
                if (!substring.contains(anotherDigit)) {
                    substring += anotherDigit;
                    continue;
                }
                break;
            }

            if (maxCount < substring.length()) {
                maxCount = substring.length();
                maxCountSubstring = substring;
            }
        }

        return maxCountSubstring;
    }

    public static int shortestWay(int[][] incArrArr) {
        int len = incArrArr.length;
        int[][] outArrArr = new int[len][len];

        outArrArr[0][0] = incArrArr[0][0];
        for (int i = 1; i < len; i++) {
            outArrArr[i][0] = outArrArr[i-1][0] + incArrArr[i][0];
            outArrArr[0][i] = outArrArr[0][i-1] + incArrArr[0][i];
        }

        for (int i = 1; i < incArrArr.length; i++) {
            for (int j = 1; j < incArrArr[i].length; j++) {
                int upSidePath = outArrArr[i-1][j];
                int leftSidePath = outArrArr[i][j-1];
                outArrArr[i][j] = Math.min(leftSidePath, upSidePath) + incArrArr[i][j];
            }
        }

        return outArrArr[len-1][len-1];
    }

    public static String numericOrder(String s) {
        String[] sArray = s.split(" ");
        String[] resultArray = new String[sArray.length];

        for (int i = 0; i < sArray.length; i++) {
            String deceasedWord = sArray[i];
            for (int j = 0; j < deceasedWord.length(); j++) {
                if (Character.isDigit(deceasedWord.charAt(j))) {
                    String vitalWord = deceasedWord.substring(0, j) + deceasedWord.substring(j+1, deceasedWord.length());
                    int index = Integer.parseInt(Character.toString(deceasedWord.charAt(j))) - 1;
                    resultArray[index] = vitalWord;
                }
            }
        }

        return String.join(" ", resultArray);
    }

    public static int switchNums(int a, int b) {
        char[] sA = Integer.toString(a).toCharArray();
        Arrays.sort(sA);
        char[] sB = Integer.toString(b).toCharArray();

        for (int i = 0; i < sB.length; i++) {
            for (int j = 0; j < sA.length; j++) {
                if (sB[i] < sA[sA.length - (j+1)]) {
                    sB[i] = sA[sA.length - (j+1)];
                    sA[sA.length - (j+1)] = 0;
                    break;
                }
            }
        }

        return Integer.parseInt(new String(sB));
    }
}
