public class SuperType{
    public static void main(String...args){
        B[] b=new B[3];
        A[] a=new A[3];
        SuperType.<A>first(b); //B will be cast to A
        SuperType.<A>first(a);
        //SuperType.<B>first(b); doesn't work T lower bounds doesn't fit

        SuperType.<A>second(b); //B will be cast to A
        SuperType.<A>second(a);
        SuperType.<B>second(b);
    }

    public static<T extends Comparable<T>> T first(T[] t){
        return t[0];
    }

    public static<T extends Comparable<? super T>> T second(T[] t){
        return t[1];
    }
}

class A implements Comparable<A>{
    public int compareTo(A a){
        return 0;
    }
}

class B extends A{//implements Comparable<B>{ // you cannot implements two interfaces of same type with different parameters, cause you will have bridge methods clash
    private int value;
    public B(){
        this.value=5;
    }

    public int compareTo(B b){
        return 0;
    }
}
