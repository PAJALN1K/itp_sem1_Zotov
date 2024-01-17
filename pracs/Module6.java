import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class Module6 {
    public static String hiddenAnagram(String[] stringArray) {
        String sentence = stringArray[0].toLowerCase();
        sentence = sentence.replaceAll("[^a-zA-Z\']", "");
        String lettersString = stringArray[1].toLowerCase();
        lettersString = lettersString.replaceAll("[^a-zA-Z\']", "");

        char[] lettersArray = lettersString.toCharArray();
        Arrays.sort(lettersArray);

        char[] sentenceLettersArray;
        for (int i = 0; i < sentence.length()-lettersArray.length+1; i++) {
            String sequence = sentence.substring(i, lettersArray.length+i);
            sentenceLettersArray = sequence.toCharArray();
            Arrays.sort(sentenceLettersArray);
            if (Arrays.equals(sentenceLettersArray, lettersArray)) return sequence;
        }
        return "notfound";
    }

    public static String[] collect(String word, int n) {
        if (word.length() < n) return new String[0];
        if (word.length() % n != 0) return collect(word.substring(0, (word.length() / n) * n), n);
        if (word.length() / n > 1) return Stream.concat(Arrays.stream(collect(word.substring(0, n), n)), Arrays.stream(collect(word.substring(n, word.length()), n)))
                .sorted()
                .toArray(String[]::new);

        return new String[] {word};
    }

    public static String nicoCipher(String message, String key) {
        char[] keyCharArray = key.toCharArray();
        Arrays.sort(keyCharArray);
        int[] keyIntArray = new int[key.length()];
        for (int i = 0; i < key.length(); i++) keyIntArray[i] = i+1;

        // step 1
        int[] keyIntArrayNew = new int[keyIntArray.length];
        for (int i = 0; i < key.length(); i++) {
            char curChar = key.charAt(i);
            for (int j = 0; j < keyCharArray.length; j++) {
                if (curChar == keyCharArray[j] && keyIntArray[j] != 0) {
                    keyIntArrayNew[i] = keyIntArray[j];
                    keyIntArray[j] = 0;
                    break;
                }
            }
        }

        // step 2
        char[][] messageCharArray = new char[key.length()][(message.length() + key.length() - 1) / key.length()];
        for (int i = 0; i < messageCharArray.length; i++) {
            for (int j = 0; j < messageCharArray[0].length; j++) {
                if (i + j * messageCharArray.length >= message.length()) messageCharArray[i][j] = ' ';
                else messageCharArray[i][j] = message.charAt(i + j * messageCharArray.length);
            }
        }

        // step 3
        for (int i = 0; i < keyIntArray.length-1; i++) {
            for (int j = i+1; j < keyIntArray.length; j++) {
                if (keyIntArrayNew[i] > keyIntArrayNew[j]) {
                    int tempInt = keyIntArrayNew[i];
                    keyIntArrayNew[i] = keyIntArrayNew[j];
                    keyIntArrayNew[j] = tempInt;
                    char[] tempArr = messageCharArray[i];
                    messageCharArray[i] = messageCharArray[j];
                    messageCharArray[j] = tempArr;
                }
            }
        }

        // step 4
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < messageCharArray[0].length; j++) {
            for (int i = 0; i < messageCharArray.length; i++) {
                result.append(messageCharArray[i][j]);
            }
        }


        return result.toString();
    }

    public static int[] twoProduct(int[] arr, int n) {
        ArrayList<Integer> dividerArraysList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0) {
                if (dividerArraysList.contains(n / arr[i])) return new int[] {n/arr[i], arr[i]};
                else dividerArraysList.add(arr[i]);
            }
        }

        return new int[0];
    }

    public static int[] isExact(int n) {
        int newNum = 1;
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                newNum *= i;
                if (newNum == n) return new int[] {n, i};
            }
            else break;
        }
        return new int[0];
    }

    public static String fractions(String decimalStr) {
        String integer = decimalStr.substring(0, decimalStr.indexOf("."));
        String nonperiodFraction = decimalStr.substring(decimalStr.indexOf(".")+1, decimalStr.indexOf("("));
        String period = decimalStr.substring(decimalStr.indexOf("(")+1, decimalStr.indexOf(")"));

        int deductible = Integer.parseInt(integer + nonperiodFraction + period);
        int subtractor = Integer.parseInt(integer + nonperiodFraction);
        int numerator = deductible - subtractor;

        StringBuilder denominatorString = new StringBuilder();
        denominatorString.append("9".repeat(period.length()));
        denominatorString.append("0".repeat(nonperiodFraction.length()));
        int denominator = Integer.parseInt(denominatorString.toString());

        int gcd = AdditionalMethods.gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        return numerator + "/" + denominator;
    }

    public static String pilishString(String s) {
        String pi = "314159265358979";
        StringBuilder result = new StringBuilder();
        int finalLen = s.length();

        int i = 0;
        while (finalLen > 0 && i < pi.length()) {
            int curPiDigit = pi.charAt(i) - '0';
            int curSubstringStart = s.length() - finalLen;
            if (curPiDigit > finalLen) {
                result.append(s.substring(curSubstringStart, s.length()));
                result.append(new String(new char[curPiDigit-finalLen]).replace("\0", Character.toString(s.charAt(s.length()-1))));
            }
            else {
                result.append(s.substring(curSubstringStart, curSubstringStart + curPiDigit));
                result.append(' ');
            }
            finalLen -= curPiDigit;
            i += 1;
        }

        return result.toString();
    }

    public static float generateNonconsecutive(String expression) {
        try {
            Stack<Float> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (Character.isDigit(ch) || ((ch == '-' && i == 0) || (ch == '-' && expression.charAt(i-1) == '('))) {
                    StringBuilder num = new StringBuilder();

                    boolean canItBeStartBracket = true;
                    boolean canItBeMinus = true;
                    int minusCount = 0;
                    boolean canItBeDot = false;
                    boolean isItFractionalPart = false;
                    boolean canItBeEndBracket = false;
                    boolean canItBeDigit = true;

                    while (i < expression.length() &&
                            (
                                (canItBeDigit && Character.isDigit(expression.charAt(i))) ||
                                (canItBeDot && expression.charAt(i) == '.')  ||
                                (ch == '-' && i == 0) ||
                                (canItBeMinus && expression.charAt(i) == '-' && expression.charAt(i-1) == '(') ||
                                ((canItBeStartBracket && expression.charAt(i) == '(') || (canItBeEndBracket && expression.charAt(i) == ')'))
                            )
                    ) {
                        if (expression.charAt(i) == '.') {
                            canItBeDot = false;
                        }
                        else if (expression.charAt(i) == '-') {
                            minusCount += 1;
                        }
                        else if (Character.isDigit(expression.charAt(i))) {
                            canItBeMinus = false;
                            canItBeStartBracket = false;
                            canItBeEndBracket = true;
                            canItBeDot = !isItFractionalPart;
                        }
                        else if (expression.charAt(i) == ')') {
                            if (AdditionalMethods.countMatches(num.toString(), '(') <= AdditionalMethods.countMatches(num.toString(), ')')) {
                                break;
                            }
                            else {
                                canItBeDigit = false;
                            }
                        }

                        num.append(expression.charAt(i));
                        i++;
                    }
                    i--;

                    String numStr = num.toString().replace("(", "").replace(")", "");
                    num = new StringBuilder(numStr);
                    if (minusCount > 0) {
                        numStr = num.toString().replace("-", "");
                        float floatNum = (float) Math.pow(-1, minusCount) * Float.parseFloat(numStr);
                        num = new StringBuilder(Float.toString(floatNum));
                    }
                    numbers.push(Float.parseFloat(num.toString()));
                }
                else if (ch == '(') {
                    operators.push(ch);
                }
                else if (ch == ')') {
                    while (operators.peek() != '(') {
                        if (numbers.size() >= 2) numbers.push(AdditionalMethods.applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                        else throw new Exception("Operands at inappropriate place");
                    }
                    operators.pop();
                }
                else if (AdditionalMethods.isOperator(ch)) {
                    while (!operators.isEmpty() && AdditionalMethods.hasPriority(operators.peek(), ch)) {
                        if (numbers.size() >= 2) numbers.push(AdditionalMethods.applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                        else throw new Exception("Operands at inappropriate place");
                    }
                    operators.push(ch);
                }
                else if (ch != ' ') throw new Exception("Illegal symbols");
            }

            while (!operators.isEmpty()) {
                System.out.println(numbers);
                System.out.println(operators);
                if (numbers.size() >= 2) numbers.push(AdditionalMethods.applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                else if (operators.peek() == '(' || operators.peek() == ')') throw new Exception("Brackets at inappropriate place");
                else throw new Exception("Operands at inappropriate place");
            }

            return (float) numbers.pop();
        }
        catch (Exception e) {
            System.out.print(e.getMessage() + " ");
            return Float.NaN;
        }
    }


    public static String isValid(String s) {
        HashMap<Character, Integer> charsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charsMap.keySet().contains(c)) charsMap.put(c, charsMap.get(c)+1);
            else charsMap.put(c, 1);
        }

        int diff = 0;
        int prevValue = charsMap.get(s.charAt(0));
        for (int value: charsMap.values()) {
            if (value != prevValue) {
                diff += 1;
                if (diff > 1) return "NO";
            }
        }

        return "YES";
    }

    public static String findLCS(String s1, String s2) {
        int[][] maxLenMatrix = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i < maxLenMatrix.length; i++) {
            for (int j = 1; j < maxLenMatrix[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) maxLenMatrix[i][j] = maxLenMatrix[i-1][j-1] + 1;
                else maxLenMatrix[i][j] = Math.max(maxLenMatrix[i-1][j], maxLenMatrix[i][j-1]);
            }
        }

        StringBuilder result = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                result.append(s1.charAt(i-1));
                i -= 1;
                j -= 1;
            }
            else if (maxLenMatrix[i-1][j] == maxLenMatrix[i][j]) i-= 1;
            else j -= 1;
        }

        return result.reverse().toString();
    }
}
