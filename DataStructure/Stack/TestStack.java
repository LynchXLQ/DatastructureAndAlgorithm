package DataStructure.Stack;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/24 17:11
 * @description :
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        for (String s : stack) {
            System.out.println(s);
        }

        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
    }
}
