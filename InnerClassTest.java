import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class InnerClassTest{
    public static void main(String...args){
        TalkingClock tc=new TalkingClock(1000, true);
        System.out.println(tc);
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

    public void start(){
        Timer t=new Timer(interval, new TimePrinter());
        Timer t1=new Timer(interval, new PrinterTest(this));
        t.start();
        t1.start();
    }

    public class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Inner Class: At the tone, the time is "+new Date());
            System.out.println(this.toString());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}

class PrinterTest implements ActionListener{
    private boolean beep;
    public PrinterTest(TalkingClock tc){
        System.out.println(tc.toString());
        this.beep=true;
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("Regular Class: At the tone, the time is "+new Date());
        System.out.println(this.toString());
        if(beep) Toolkit.getDefaultToolkit().beep();
    }
}