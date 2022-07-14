import java.util.*;
public class BalancedParenthesis {
    static boolean isBalanced(String str)
    {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < str.length(); i++) {
            char singleChar = str.charAt(i);
            if(singleChar == '(' || singleChar == '{' || singleChar == '[')
            {
                stack.push(singleChar);
            }
            else
            {
                char top = stack.pop();
                char closing = map.get(top);
                if(closing != singleChar)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        System.out.println(isBalanced(str));
        sc.close();
    }
}
