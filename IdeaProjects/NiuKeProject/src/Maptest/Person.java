package Maptest;

public class Person {
    String id;
    String name;

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Person(String id , String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return  "id= "+id+",name= "+ name;
    }

    public boolean equals(Object obj){
        Person p = (Person)obj;
        if(p.id.equals(this.id))
            return true;
        else
            return false;
    }
}

