import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {20,7,5,14,16};
        int output[] = new int[arr.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            int index = stack.peek();
            if(arr[index] >= arr[i])
            {
                stack.push(i);
            }
            else
            {
                while(arr[stack.peek()] < arr[i])
                {
                    output[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        for (int element : output) {
            System.out.print(element + " ");
        }
    }
}
