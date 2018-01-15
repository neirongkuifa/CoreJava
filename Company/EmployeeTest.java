package Company;
import java.time.*;
import java.util.*;

/**
/*@author Abel
*/

public class EmployeeTest{
	public static void main(String[] args){
		Employee[] staff=new Employee[3];
		Manager[] managers=new Manager[3];

		staff[0]=new Employee("Carl Cracker", 75000, 1987, 12,15);
		staff[1]=new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2]=new Employee("Tony Tester", 40000, 1990, 3, 15);

		managers[0]=new Manager("Carl Cracker", 75000, 1987, 12,15);
		managers[1]=new Manager("Harry Hacker", 50000, 1989, 10, 1);
		managers[2]=new Manager("Tony Tester", 40000, 1990, 3, 15);

		Position staffPo=staff[0];
		Position manaPo=managers[0];
		Position.printTest();
		staffPo.printClass();
		manaPo.printClass();
		Arrays.sort(staff);
		Arrays.sort(managers);
		for(Employee e: staff)
			System.out.println(e.getName()+" "+e.getSalary());

	}
}

