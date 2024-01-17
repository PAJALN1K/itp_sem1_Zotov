package src.task2;

import java.util.Arrays;

public class Task2 {
    public static void main() {
        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.getData()));

        System.out.println(stack.peek());
        System.out.println(Arrays.toString(stack.getData()));

        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.getData()));

        for (int i = 0; i < 10; i++) {
            stack.push(3);
        }
        stack.push(3);
        System.out.println(Arrays.toString(stack.getData()));
    }
}
