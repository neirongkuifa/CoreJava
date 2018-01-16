package Company;
import CompanyB.*;
import java.lang.reflect.*;

public class Manager extends CompanyB.Employee{
    public static void main(String...args){
        Manager e=new Manager("Carl Cracker", 75000, 1987, 12,15);
        System.out.println(e.getName());
    }

    public Manager(){
    }

    public Manager(String n, double s, int year, int month, int day){
		super(n, s, year, month, day);
    }
    
    public void printClass(){
        System.out.println("Hi there!");
    }
}