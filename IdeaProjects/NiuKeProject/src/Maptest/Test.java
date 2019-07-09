package Maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void test2(){
        System.out.println("Use String as Key:");
        HashMap<Person,String> hm = new HashMap<Person,String>();
        Person p1 = new Person("111","qibaishi");
        Person p2 = new Person("111","huangsanshi");
        hm.put(p1,"anhuihuangshan");
        hm.put(p2,"changchengxiaoqu");
        Iterator iter = hm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Person key = (Person)entry.getKey();
            String val = (String)entry.getValue();
            System.out.println("key= "+key+",val= "+ val);
        }
    }
    public static void main(String args[]){
        test2();
    }
}
