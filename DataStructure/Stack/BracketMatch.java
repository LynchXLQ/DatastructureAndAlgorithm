package DataStructure.Stack;

import java.util.Stack;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/24 17:30
 * @description :
 */
public class BracketMatch {
    public static void main(String[] args) {
        String s = "(()()(())";
        boolean match = isMatch(s);
        System.out.println(match);
    }

    public static boolean isMatch(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String curChar = s.charAt(i) + "";   // Char 转 String
            if (curChar.equals("(")) {
                stack.push(curChar);
            } else if (curChar.equals(")")) {
                String popChar = stack.pop();
                if (popChar == null){
                    return false;
                }

            }
        }

        return stack.size() == 0;
    }
}
