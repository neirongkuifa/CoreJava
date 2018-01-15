
import static java.lang.System.*;
import Company.Employee;
import java.lang.reflect.*;

public class ParamTest{
    public static void main(String[] args) throws Exception{
        Employee a=new Manager("Carl Cracker", 75000, 1987, 12,15);
        Employee b=new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Class cl=Class.forName("Manager");
        Class supercl=cl.getSuperclass();
        Method m=supercl.getMethod("getName");
        System.out.println(m.invoke(b).toString());
        out.println(supercl.toString());
        out.println(Modifier.toString(supercl.getModifiers()));
        Constructor[] con=supercl.getDeclaredConstructors();
        for(Constructor c : con){
            out.print(c.getName()+" "+c.getParameterCount()+" -> ");
            Class[] paraT=c.getParameterTypes();
            for(Class p: paraT){
                out.print(p.getName()+" ");
            }
            out.println();
        }
    }

    public static void exchage(Employee a, Employee b){
        Employee temp=a;
        a=b;
        b=temp;
        System.out.println(a.getName());
        System.out.println(b.getName());
    }
}