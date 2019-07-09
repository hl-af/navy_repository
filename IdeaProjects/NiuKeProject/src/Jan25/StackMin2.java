package Jan25;

import java.util.Stack;

public class StackMin2 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> as = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min){
            min  = node;
            as.push(node);
        }else{
            as.push(min);
        }
    }

    public void pop() {
        stack.pop();
        as.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return as.peek();
    }
    public static void main(String[] args){
        StackMin2 stm = new StackMin2();
        stm.push(-1);
        System.out.println(stm.min());
        stm.push(0);
        System.out.println(stm.min());
        stm.push(2);
        System.out.println(stm.min());
        stm.push(3);
        System.out.println(stm.min());
        stm.pop();
        System.out.println(stm.min());
    }
}
