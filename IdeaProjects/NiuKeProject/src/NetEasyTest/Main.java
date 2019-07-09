package NetEasyTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println(("a"+"b").intern()=="ab".intern());
        System.out.println(Integer.MAX_VALUE==(-1>>1));
        String a ="a b";
        String b ="b";
        String c;
        Scanner sc = new Scanner(System.in);
        int i = 2;
        if(i++>2 && ++i>=3){
            System.out.println(i);
        }
        System.out.println(i);
    }   //System.out.println((-1>>1)==Integer.MAX_VALUE);

}
