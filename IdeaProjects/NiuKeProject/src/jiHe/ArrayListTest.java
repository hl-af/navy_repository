package jiHe;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

    //为什么将类放在外面就不能使用，alist调用不了方法add
    //能否假如不同类型的元素，如果能，怎样访问每一个元素，应该不能使用迭代器了
    public static void main(String args[]){
        ArrayList<String> alist = new ArrayList<String>();
        alist.add("25");
        alist.add("67");
        Iterator<String> iter = alist.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }



}
