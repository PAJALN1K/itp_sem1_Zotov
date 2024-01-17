import java.util.Arrays;

public class AdditionalMethods {
    public static void doubleArrayPrint(int[][] arrArr) {
        System.out.print("[");
        if (arrArr.length != 0) {
            for (int i = 0; i < arrArr.length-1; i++) {
                System.out.format("%s, ", Arrays.toString(arrArr[i]));
            }
            System.out.print(Arrays.toString(arrArr[arrArr.length-1]));
        }
        System.out.println("]");
    }

    public static void doubleArrayPrint(String[][] arrArr) {
        System.out.print("[");
        if (arrArr.length != 0) {
            for (int i = 0; i < arrArr.length-1; i++) {
                System.out.format("%s, ", Arrays.toString(arrArr[i]));
            }
            System.out.print(Arrays.toString(arrArr[arrArr.length-1]));
        }
        System.out.println("]");
    }

    public static void doubleArrayPrint(char[][] arrArr) {
        System.out.print("[");
        if (arrArr.length != 0) {
            for (int i = 0; i < arrArr.length-1; i++) {
                System.out.format("%s, ", Arrays.toString(arrArr[i]));
            }
            System.out.print(Arrays.toString(arrArr[arrArr.length-1]));
        }
        System.out.println("]");
    }

    public static int linearSearch(String sB, char element) {
        for (int i = 0; i < sB.length(); i++) {
            if (sB.charAt(i) == element) return i;
        }
        return -1;
    }

    public static int linearSearch(String[] arr, String element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) return i;
        }
        return -1;
    }

    public static int linearSearch(char[] arr, char element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int order, int element) {
        for (int i = order; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    public static int countMatches(String s, char ch) {
        return (int) s.chars().filter(c -> c == ch).count();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static String[] reversedArray(String[] arr) {
        int len = arr.length;
        for(int i = 0; i < arr.length / 2; i++)
        {
            String temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len- i - 1] = temp;
        }
        return arr;
    }

    public static boolean doLettersEqual(String substring, String mainstring) {
        char[] substringCharArray =  substring.toCharArray();
        char[] mainstringCharArray = mainstring.toCharArray();

        for (int i = 0; i < substringCharArray.length; i++) {
            char substringLetter = substringCharArray[i];
            int index = linearSearch(mainstringCharArray, substringLetter);

            if (index != -1) {
                mainstringCharArray[index] = ' ';
                continue;
            }
            return false;
        }

        return true;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean hasPriority(char op1, char op2) {
        return (((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) ||
                ((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/')) ||
                ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')));
    }

    public static float applyOperator(char operator, float b, float a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (float) Math.round(a / b * 10000) / 10000;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
