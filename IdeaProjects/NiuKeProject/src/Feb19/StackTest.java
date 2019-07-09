package Feb19;
import java.util.ArrayList;
import java.util.Stack;
public class StackTest {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> assist = new Stack<Integer>();
        int i = 0;int j = 0;
        int len = pushA.length;
        //System.out.println("len "+len);
        assist.push(pushA[i]);
        i++;
        while(true){
            if(assist.peek()==popA[j]){
                System.out.println("pop "+assist.pop());
                j++;
            }else{
                System.out.println("push "+assist.push(pushA[i]));
                i++;
            }
            if(i==(len)){
                while(j!=(len)){
                    if(assist.pop()!=popA[j]){
                        System.out.println("出栈错误不匹配 ");
                        return false;
                    }
                    System.out.println("pop "+popA[j]);
                    j++;
                }
                return true;
            }
        }

    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println(new StackTest().IsPopOrder(a,b));
    }
}
