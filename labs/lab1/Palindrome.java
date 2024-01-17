public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(String.format("word: %s, is palindrome: %b", s, isPalindrome(s)));
        }
    }

    public static String reverseString(String s) {
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            newS += s.charAt(s.length()-i-1);
        }
        return newS;
    }

    public static boolean isPalindrome(String s) {
        return (s.equals(reverseString(s))) ? true : false;
    }
}
