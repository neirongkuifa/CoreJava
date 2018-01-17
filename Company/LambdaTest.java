import java.util.*;
import java.util.function.IntConsumer;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest{
    public static void main(String...args){
        String[] str={"Jackson","Kris","Amanda","Hans","Bella"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str,(a,b)->a.length()-b.length());
        // System.out.println(Arrays.toString(str));
        Chicken c=new Chicken(10);
        c.nonabsTest();
        // if(c instanceof Eatable){
        //     Eatable e=c;
        //     e.eat();
        // }

        Man m=new Man();
        m.hungery(c::eat);
        // m.hungery(Tiger::eat);
        // System.out.println(c.weight);
        //m.hungery(new Chicken(10));
        // String text="variable scope test";
        // text="Let's change it a little bit.";
        // Timer t=new Timer(1000, e->{System.out.println("Current time is "+new Date()+" "+text); Toolkit.getDefaultToolkit().beep();});
       
        //Timer t=new Timer(1000, e->System.out.println(e));
        // Timer t=new Timer(1000, System.out::println);
        // t.start();

        // JOptionPane.showMessageDialog(null, "Quit?");
        // System.exit(0);
        // runTest("Yes", ()->System.out.println("It works!!!"));
        // intConsumerTest(10, (x)->System.out.println(x));
    }

    public static void runTest(String cmd, Runnable r){
        if(cmd.equals("Yes")){
            r.run();
        }
    }

    public static void intConsumerTest(int InitVal, IntConsumer i){
        i.accept(InitVal);
    }
}

interface Eatable{
    public void eat(Tiger c);
    default void nonabsTest(){
        System.out.println("It's ok to have non abstract methods");
    }
}

class Chicken implements Eatable{// implements Eatable{
    double weight;
    Chicken(double w){
        this.weight=w;
    }
    public void eat(Tiger c){
        weight=weight-5;
        System.out.println(this);
    }
}

class Tiger{
    public void eat(){
        System.out.println(this);
    }
}

class Man{
    public void hungery(Eatable e){
        e.eat(new Tiger());
    }
}

