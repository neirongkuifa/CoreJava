import java.time.LocalDate;
import java.lang.reflect.*;
import java.util.*;

public class GenericTest{
    public static void main(String...args){
        DateInterval di=new DateInterval(LocalDate.of(2016,12,5),LocalDate.of(2018,1,23));
        Method[] m=di.getClass().getMethods();
        System.out.println(Arrays.toString(di.getClass().getFields()));
        for(Method method: m)
            System.out.println(method.getName()+" "+Arrays.toString(method.getParameters()));
    }

    public static <T> void printType(T a){
        System.out.println(a.toString());
    }

    public static <T extends Comparable<T>> void compareTest(T a, T b){ //extends cannot be replaced with implements here
        if(a instanceof Comparable)
            System.out.println("T is comparable!");
        if(a.compareTo(b)>0)
            System.out.println(a.toString()+" is Bigger");
        else
            System.out.println(a.toString()+" is Smaller");
    }
}

class DateInterval extends Pair<LocalDate>{
    public DateInterval(LocalDate first, LocalDate second){
        setFirst(first);
        super.setSecond(second);
        System.out.println(this.third);
    }
    public void setSecond(LocalDate second){
        if(second.compareTo(getSecond())>=0)
            super.setSecond(second);
    }
}

class Pair<T>{
    private T first;
    private T second;
    public T third=(T)LocalDate.of(2017,8,15);

    public Pair(){first=null; second=null;}
    public Pair(T first, T second){this.first=first; this.second=second;}

    public T getFirst(){return this.first;}
    public T getSecond(){return this.second;}

    public void setFirst(T newVal){this.first=newVal;} 
    public void setSecond(T newVal){this.second=newVal;}
}