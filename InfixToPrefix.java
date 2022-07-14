import java.util.*;
public class InfixToPrefix {
    static int order(char ch)
    {
        switch(ch)
        {
            case '+' : return 1;
            case '-' : return 1;
            case '/' : return 2;
            case '*' : return 3;
            case '^' : return 4;
        }
        return -1;
    }
    static String infixToPrefix(String str)
    {
        String string = "";
        String result = "";
        for(int i=str.length()-1; i>=0; i--)
        {
            char ch = str.charAt(i);
            string += ch;
        }
        Stack<Character> stack = new Stack<>();
        System.out.println("Symbol\t\t\tStack\t\t\t\tAnswer");
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')))
            {
                result += ch;
            }
            else
            {
                if(ch == ')')
                {
                    stack.push(ch);
                }
                else
                {
                    if(ch == '(')
                    {
                        while (!stack.isEmpty() && stack.peek()!=')') {
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
        while (!stack.isEmpty()) {
            if(stack.peek()==')' || stack.peek()=='(')
            {
                stack.pop();
            }
            result += stack.pop();
        }
        String newString = "";
        for (int i = result.length()-1; i >= 0; i--) {
            char ch = result.charAt(i);
            newString += ch;
        }
        return newString;
    }
    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";
        System.out.println(infixToPrefix(str));
    }
}
