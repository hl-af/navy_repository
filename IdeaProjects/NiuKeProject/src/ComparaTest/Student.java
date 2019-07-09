package ComparaTest;
/*实现Comparator接口的类可以方便的排序，
 * 覆写compareTo接口
 * java.util.Arrays.sort(对象类数组)，*/
class Student implements Comparable<Student> {    // 指定类型为Student
    private String name ;
    private int age ;
    private float score ;
    public Student(String name,int age,float score){
        this.name = name ;
        this.age = age ;
        this.score = score ;
    }
    public String toString(){
        return name + "\t\t" + this.age + "\t\t" + this.score ;
    }
    public int compareTo(Student stu){    // 覆写compareTo()方法，实现排序规则的应用
        if(this.score>stu.score){
            return -1 ;
        }else if(this.score<stu.score){
            return 1 ;
        }else{
            if(this.age>stu.age){
                return 1 ;
            }else if(this.age<stu.age){
                return -1 ;
            }else{
                return 0 ;
            }
        }
    }
};
