package qRF;

public class equalTest {
    public static void main(String args[]){
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = new String("hellow");
        StringBuffer s4 = new StringBuffer("hello");
        Integer i1 = 1;
        Integer i2 = 2;
        System.out.println("==================Integer==================");
        System.out.println("== "+(i1==i2));
        System.out.println("hasCode "+(i1.hashCode()==i2.hashCode()));
        System.out.println("i1 equal i2 "+i1.equals(i2));
        System.out.println("==================String==================");
        System.out.println("== "+(s1==s2));
        System.out.println("hasCode "+(s1.hashCode()==s2.hashCode()));
        System.out.println("s1 equal s2 "+s1.equals(s2));
        System.out.println("s1 equal s3 "+s1.equals(s3));
        System.out.println("StringBuffer equal"+s1.equals(s4));
        System.out.println("StringBuffer hashCode "+(s1.hashCode()==s4.hashCode()));
    }
}
