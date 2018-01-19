import java.lang.reflect.*;

interface Printer{
    public void PrinterInfo();
    public void Print(String s);
    public void Print();
}

interface Printer1{
    public void PrinterInfo();
    public void Print(String s);
    default void IAM1(){};
}

interface Printer2{
    public void PrinterInfo();
    public void Print(String s);
    default void IAM2(){};
}

public class ProxyTest{
    public static void main(String...args){
        Object p=Proxy.newProxyInstance(Printer.class.getClassLoader(), 
        new Class[]{Printer.class, Printer1.class, Printer2.class},
        new PrinterHandler(new RealPrinter()));
        Method[] method=p.getClass().getMethods();
        for(Method m : method){
            System.out.println(m.getName());
        }
        if(p instanceof Printer2)
            System.out.println("Yes");
        // Printer p=(Printer)Proxy.newProxyInstance(Printer.class.getClassLoader(), 
        // new Class[]{Printer.class},
        // new PrinterHandler(new RealPrinter()));

        //p.Print("Print Test!");
    }
}

class RealPrinter implements Printer{
    public void PrinterInfo(){
        System.out.print("This is a real Printer: ");
        Print();
    }

    public void Print(String s){
        System.out.println("Content to be printed: "+s);
    }

    public void Print(){
        System.out.println(this.toString());
    }
}

class PrinterHandler implements InvocationHandler{
    private Object proxied;

    public PrinterHandler(Object proxied){
        this.proxied=proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("The operation is handled by proxy!");
        return method.invoke(proxied, args);
    }
}