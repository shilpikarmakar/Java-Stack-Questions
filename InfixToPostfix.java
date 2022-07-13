import java.util.Stack;
public class InfixToPostfix 
{
    static int order(char ch)
    {
        switch(ch)
        {
            case '+': return 1;
            case '-': return 1;
            case '/': return 2;
            case '*': return 2;
            case '^': return 3;
        }
        return -1;
    }
    static String infixToPostfix(String str)
    {
        String result = "";
        Stack<Character> stack = new Stack<>();
        System.out.println("Symbol\t\t\tStack\t\t\t\tAnswer");
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            if(((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')))
            {
                result += ch;
            }
            else
            {
                if(ch == '(')
                {
                    stack.push(ch);
                }
                else
                {
                    if(ch == ')')
                    {
                        while (!stack.isEmpty() && stack.peek()!='(') {
                            result += stack.pop();
                        }
                        stack.pop();
                    }
                    else
                    {
                        while(!stack.isEmpty() && order(ch)<=order(stack.peek()))
                        {
                            result += stack.pop();
                        }
                        stack.push(ch);
                    }
                }
            }
            System.out.println(ch+"\t\t\t"+stack+"\t\t\t\t"+result);
        }
        while(!stack.isEmpty())
        {
            if(stack.peek() == '(' || stack.peek() == ')')
            {
                stack.pop();
            }
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) 
    {
        String str = "(A+B/C*(D+E)-F)"; //ABC/DE+*+F-
        // String str = "A+B*C";
        System.out.println(infixToPostfix(str));
    }
}
