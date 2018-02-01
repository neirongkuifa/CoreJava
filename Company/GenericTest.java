public class GenericTest{
    public static void main(String...args){
        // DateInterval di=new DateInterval(LocalDate.of(2016,12,5),LocalDate.of(2018,1,23));
        // Method[] m=di.getClass().getMethods();
        // Pair<LocalDate> p=di;
        // p.setSecond(LocalDate.of(2016,12,5)); //The reason why you can call setSecond on p and still get result of di.setSecond is you override this method in DI. Without bridge method, you do not override mthod in DI actually
        Pair<String>[] pair=new Pair[10];
        pair[0]=new Pair<String>("Abel","Bob");
        pair[1]=new Pair<String>("100","200");

        Pair[] pair2=new Pair[10];
        pair2[0]=new Pair<String>();
        pair2[1]=new Pair<Integer>();

        GenericTest.<String>min(new String[]{"Abel","Atwood"});

        System.out.println(pair[0].getClass().getName());

       if(pair[0] instanceof Pair)
            System.out.println("Yes!!!!!!!!!!!!");

        printTest(new Pair<String>("Abel","Atwood"));
        printTest(new Pair<Integer>(5678,1234));
    }

    public static void printTest(Pair<? extends Comparable> p){
        System.out.println(p.getFirst()+" "+p.getSecond());
    }

    public static <T> void min(T[] t){
        T[] test=(T[])new String[10];
    }

    // public static <T> void printType(T a){
    //     System.out.println(a.toString());
    // }

    // public static <T extends Comparable<T>> void compareTest(T a, T b){ //extends cannot be replaced with implements here
    //     if(a instanceof Comparable)
    //         System.out.println("T is comparable!");
    //     if(a.compareTo(b)>0)
    //         System.out.println(a.toString()+" is Bigger");
    //     else
    //         System.out.println(a.toString()+" is Smaller");
    // }
}

// class DateInterval extends Pair<LocalDate>{
//     public DateInterval(LocalDate first, LocalDate second){
//         setFirst(first);
//         super.setSecond(second);
//     }
//     public void setSecond(LocalDate second0){
//         LocalDate second=(LocalDate)second0;
//         if(second.compareTo(getSecond())>=0)
//             super.setSecond(second);
//     }
// }

class Pair<T>{
    private T first;
    private T second;

    public Pair(){first=null; second=null;}
    public Pair(T first, T second){this.first=first; this.second=second;}

    public T getFirst(){return this.first;}
    public T getSecond(){return this.second;}

    public void setFirst(T newVal){this.first=newVal;} 
    public void setSecond(T newVal){this.second=newVal;}
}