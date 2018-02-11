import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Pair<T>{
    public static void main(String[] args){
        Pair<Integer> spair=new Pair<Integer>(10,15);
        if(spair instanceof Pair) //instanceof only work with raw type
            System.out.println("Yes!");
        Pair<String> p0=new Pair<String>(String::new);// Of course, you can instantiate a parameterized generic type.
        Pair<String>[] p; //You can declare parameterized generic type but you can't instantiate it.
        Pair<String>[] p1=new Pair[10]; //You can instantiate raw type arrays, because they are equal after type erasure
        // Pair<String>[] p=new Pair<String>[10];  It is not allowed because type is eliminated after erasure.

        p=array(new Pair<String>("Abel","Atwood"), new Pair<String>("Alice","Ada"));
        get(String[]::new);
    }

    public static<T> T[] array(T...t){ //varargs exception for parameterized generic array
        return t;
    }

    // public static<T extends Comparable> T get(){
    //     Object o=new Object();
    //     return (T)o;
    // } 

    public static<T extends Comparable> T[] get(IntFunction<T[]> intF){
        T[] t=intF.apply(3);
        return t;
    } 

    private T first;
    private T second;
    public Pair(Supplier<T> s){
        this.first=s.get();
        this.second=s.get();
    }

    public Pair(T a, T b){
        this.first=a;
        this.second=b;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

}