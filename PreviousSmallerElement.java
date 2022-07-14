import java.util.*;
public class PreviousSmallerElement {
    static void approach(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && stack.peek()>arr[i])
            {
                stack.pop();
            }
            int previousSmallerElement = stack.empty()?-1:stack.peek();
            System.out.print(previousSmallerElement + " ");
            stack.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 7, 8, 1, 9};
        approach(arr);
    }
}
