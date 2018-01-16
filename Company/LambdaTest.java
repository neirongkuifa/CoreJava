import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest{
    public static void main(String...args){
        String[] str={"Jackson","Kris","Amanda","Hans","Bella"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str,(a,b)->a.length()-b.length());
        System.out.println(Arrays.toString(str));
        // Chicken c=new Chicken(10);
        // if(c instanceof Eatable){
        //     Eatable e=c;
        //     e.eat();
        // }

        Man m=new Man();
        m.hungery(()->System.out.println("I'll eat nothing"));
        m.hungery(new Chicken(10));


        Timer t=new Timer(1000, e->{System.out.println("Current time is "+new Date()); Toolkit.getDefaultToolkit().beep();});
        t.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
 }
}

interface Eatable{
    public void eat();
}

class Chicken implements Eatable{
    double weight;
    Chicken(double w){
        this.weight=w;
    }
    public void eat(){
        System.out.println("I'll eat a chicken");
    }
}

class Man{
    public void hungery(Eatable e){
        e.eat();
    }
}

