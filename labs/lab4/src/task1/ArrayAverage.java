package src.task1;

public class ArrayAverage {
    public static void main(String[] args) {
        float sum = 0;

        try {
//            for (int i = 0; i < args.length; i++) {
            for (int i = 0; i < args.length+1; i++) {
                try {
                    float number = Float.parseFloat(args[i]);
                    sum += number;
                }
                catch (NumberFormatException e) {
                    System.out.println("[ArrayAverageProgram] Error: one of the inputted value is not a number! Please, input correct values.");
                    return;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ArrayAverageProgram] Error: index goes out of bounds of the given array!");
            return;
        }

        try {
//            int result = (int) sum / args.length;
            int result = (int) sum / 0;
            System.out.println(String.format("[ArrayAverageProgram] The arithmetic mean of the array is : %s.", result));
        }
        catch (ArithmeticException divideByZeroError) {
            System.out.println("[ArrayAverageProgram] Error: divide by zero.");
        }
    }
}
