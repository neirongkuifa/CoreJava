package Company;
import java.time.*;

public class Employee implements Comparable<Employee>,Cloneable{

    public static void main(String[] args) throws Exception{
		System.out.println("This is so cool");
		Employee e=new Employee("Carl Cracker", 75000, 1987, 12,15);
        System.out.println(e.getName());
        Employee test=(Employee)e.clone();
    }

	//final variables either have an initial value or initialized in the constructor. Exactly one initialization must be excuted.
	public String name;
	private double salary;
	private LocalDate hireDay;

	public Employee(){}

	public Employee(String n, double s, int year, int month, int day){
		name=n;
		salary=s;
		hireDay=LocalDate.of(year,month,day);

	}

	protected String getName(){
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
