import java.util.*;
public class PreviousGreaterElement {
    static void approach(int arr[])
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek()<arr[i]) {
                stack.pop();
            }
            int previousGreaterElement = stack.empty()?-1:stack.peek();
            System.out.print(previousGreaterElement + " ");
            stack.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 12, 4, 2, 3, 6, 1};
        approach(arr);
    }
}
