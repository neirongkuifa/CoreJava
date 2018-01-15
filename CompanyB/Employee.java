package CompanyB;
import java.time.*;

public class Employee{

    public static void main(String[] args){
        System.out.println("This is so cool");
    }

	private final String name;
	private double salary;
	private LocalDate hireDay;

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
	
	private int test(){
		return 5;
	}
	public void privatetest(Employee e){
		System.out.println(e.test());
	}
}
