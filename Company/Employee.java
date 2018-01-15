package Company;
import java.time.*;

public class Employee implements Comparable<Employee>,Position,Cloneable{

    public static void main(String[] args){
        System.out.println("This is so cool");
    }

	public final String name;
	private double salary;
	private LocalDate hireDay;

	//public Employee(){};

	public Employee(String n, double s, int year, int month, int day){
		name=n;
		salary=s;
		hireDay=LocalDate.of(year,month,day);

	}

	public String getName(){
		return name;
    }

	public Double getSalary(){
		return salary;
	}

	public LocalDate getHireDay(){
		return hireDay;
	}

	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	
	public void test(double x){
		System.out.println(x+" in Em!");
	}

	public int compareTo(Employee em){
		return Double.compare(this.salary, em.salary);
	}
	
}
