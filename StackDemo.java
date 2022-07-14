class MyStack
{
    int arr[], top, capacity;
    MyStack(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }
    void push(int element)
    {
        if(top == capacity-1)
        {
            System.out.println("Stack is Full");
            return;
        }
        top++;
        arr[top] = element;
    }
    int pop()
    {
        if(top == -1)
        {
            throw new RuntimeException("Stack is empty");
        }
        int element = arr[top];
        top--;
        return element;
    }
    int peek()
    {
        if(top == -1)
        {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }
}
public class StackDemo {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        // stack.push(60);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
