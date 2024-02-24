package homework_23_02;

import java.util.HashSet;
//import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws RepeatElementException {
            Set<Integer> set = new Set<>();
            set.add(5);
            set.add(4);
            set.add(2);
            set.add(1);
            set.delete(2);
            System.out.println(set.contains(3));
            System.out.println(set.toString());

            Stack<Integer> stack =  new Stack<>();
            stack.push(5);
            stack.push(4);
            stack.push(2);
            stack.push(1);
            System.out.println(stack.toString());
            System.out.println(stack.size());
            System.out.println(stack.pop());
            System.out.println(stack.toString());

    }
}
