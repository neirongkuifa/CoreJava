package Company;
import Company.*;
import java.lang.reflect.*;

public class Manager extends Company.Employee{
    public static void main(String...args){
        Company.Employee e=new Company.Employee("Carl Cracker", 75000, 1987, 12,15);
        Manager m=(Manager)e;
        System.out.println(m.level);
    }

    public String level;

    public Manager(){
    }

    public Manager(String n, double s, int year, int month, int day, String level){
        super(n, s, year, month, day);
        this.level=level;
    }
    
    public void printClass(){
        System.out.println("Hi there!");
    }
}