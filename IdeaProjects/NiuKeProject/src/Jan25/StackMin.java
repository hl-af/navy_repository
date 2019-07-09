package Jan25;

import java.util.Stack;

public class StackMin {
    Stack<Integer> st = new Stack<Integer>();//不用指定大小
    Stack<Integer> assist = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();
    public void push(int node) {
        st.push(node);
        if(assist.isEmpty()){
            assist.push(node);
        }else{
            while(assist.peek()<node){
                tmp.push(assist.pop());
            }
            while(!assist.isEmpty()){
                if(assist.peek()<node){
                    tmp.push(assist.pop());
                }else
                    break;
            }
            assist.push(node);
            while(!tmp.isEmpty()){
                assist.push(tmp.pop());
            }
        }

    }

    public void pop() {
        while(!assist.isEmpty()){
            if(st.peek()!=assist.peek())
                tmp.push(assist.pop());
            else
                break;
        }
        st.pop();
        assist.pop();
        while(!tmp.isEmpty()){
            assist.push(tmp.pop());
        }
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return assist.peek();
    }

    public static void main(String[] args){
        StackMin stm = new StackMin();
        stm.push(3);
        System.out.println(stm.min());
        stm.push(4);
        System.out.println(stm.min());
        stm.push(2);
        System.out.println(stm.min());
        stm.push(3);
        System.out.println(stm.min());
        stm.pop();
        System.out.println(stm.min());
    }
}
