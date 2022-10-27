package RandomArrayList;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();
        list.add(13);
        list.add(33);
        list.add(56);
        Stack<String> stack=new Stack<>();
        stack.push("Ivan");
        stack.push("Mariya");
        stack.push("Gosho");
        stack.push("Pesho");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
