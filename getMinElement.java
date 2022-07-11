import java.util.*;

public class getMinElement {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();
    static void addElement(int element)
    {
        if(stack.empty() && minStack.empty())
        {
            stack.push(element);
            minStack.push(element);
            return;
        }
        else
        {
            if(element < minStack.peek())
            {
                minStack.push(element);
                stack.push(element);
                return;
            }
            else
            {
                stack.push(element);
            }
        }
    }
    static void deleteElement()
    {
        stack.pop();
    }
    static void peekElement()
    {
        System.out.println(stack.peek());
    }
    static void print()
    {
        System.out.println(stack);
        System.out.println(minStack);
    }
    static void MinElement()
    {
        System.out.println(minStack.peek());
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add element in stack");
                System.out.println("2. Delete from the stack");
                System.out.println("3. Get minimum element from the stack");
                System.out.println("4. Print Stack");
                System.out.println("10. Exit");
                System.out.println("Enter the choice: ");
                int choice = sc.nextInt();
                switch(choice)
                {
                    case 1: System.out.println("Enter the element to add: ");
                    int data = sc.nextInt();
                    addElement(data);
                    break;
                    case 2: deleteElement();
                    break;
                    case 3: MinElement();
                    break;
                    case 4: print();
                    break;
                    case 10: return;
                }
            }
        }
    }
}
