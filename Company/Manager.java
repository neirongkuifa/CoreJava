package Company;
import Company.*;
import java.lang.reflect.*;

public class Manager extends Employee{
    public void test(double x){
        System.out.println(x+" in Ma");
    }

    public Manager(String n, double s, int year, int month, int day){
		super(n, s, year, month, day);
    }
    
    public void printClass(){
        System.out.println("Hi there!");
    }
}