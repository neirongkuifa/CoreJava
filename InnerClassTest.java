import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class InnerClassTest{
    public static void main(String...args){
        TalkingClock tc=new TalkingClock(1000, true);
        tc.start();
        // ActionListener tp=tc.new TimePrinter();
        // Timer t=new Timer(1000, tp);
        // t.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}

class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }

    public static void staticInTest(){
        class staCl{
            public void printInfo(){
               System.out.println("This is an inner class");
            }
        }
        staCl s=new staCl();
        s.printInfo();
    }

    public void start(){
        int test=5;
        staticInTest();
        // test=8;
        class localPrinter implements ActionListener{
            public void actionPerformed(ActionEvent e){
                System.out.println("Local Inner Class:"+this.toString());//+" "+TalkingClock.this.interval+" "+test);
            }
        }
        //int test=5;
        Timer t=new Timer(interval, new TimePrinter());
        Timer t1=new Timer(interval, new PrinterTest(this));
        Timer t2=new Timer(interval, new localPrinter());
        // t.start();
        // t1.start();
        t2.start();  
    }

    public static class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Inner Class:"+this.toString());
        }
    }
}

class PrinterTest implements ActionListener{
    private boolean beep;
    public PrinterTest(TalkingClock tc){
        this.beep=true;
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("Regular Class:"+this.toString());
    }
}