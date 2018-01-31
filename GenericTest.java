public class GenericTest{
    public static void main(String[] args){
        Automobile a=new Automobile();
        Benz b=new Benz();
        Bike bk=new Bike();
        House hs=new House();

        Container1 c1ForA=new Container1(a);
        Container1 c1ForB=new Container1(b);
        //Container1 c1ForBk=new Container1(bk); //Does not fit in Container1

        Container2 c2ForA=new Container2(a);
        Container2 c2ForB=new Container2(b);
        Container2 c2ForBk=new Container2(bk); 
        //Container2 c2ForHouse=new Container2(hs); //Does not fit in Container2
        System.out.println((c2ForA.get()).getDesc()+"\n"+(c2ForB.get()).getDesc()+"\n"+(c2ForBk.get()).getDesc()); //Polymorphism! No need to Unbox!

        Container3 c3ForA=new Container3(a);
        Container3 c3ForB=new Container3(b);
        Container3 c3ForBk=new Container3(bk); 
        Container3 c3ForHouse=new Container3(hs);
        System.out.println(((Automobile)c3ForA.get()).getDesc()+"\n" //Unbox! Object does not have getDesc()
        +((Benz)c3ForB.get()).getDesc()+"\n"
        +((Bike)c3ForBk.get()).getDesc()+"\n"
        +((House)c3ForHouse.get()).getDesc());
        
        Container4<Automobile> c4ForA=new Container4<>(a);
        Container4<Benz> c4ForB=new Container4<>(b);
        Container4<Bike> c4ForBk=new Container4<>(bk); 
        Container4<House> c4ForHouse=new Container4<>(hs);
        Container4<String> c4ForStr=new Container4<>("This is a String");
        System.out.println((c4ForA.get()).getDesc()+"\n"+(c4ForB.get()).getDesc()+"\n"+(c4ForBk.get()).getDesc()+"\n"+c4ForHouse.get().getDesc()+"\n"+c4ForStr.get()); 

        ThreeTuple<String, Integer, Double> tt=new ThreeTuple<>("Abel",24,3.1415926);
        System.out.println(tt.toString());

        System.out.println(tupleTest().toString());
        LinkedStack<String> ls=new LinkedStack<>();
        ls.push("One");
        ls.push("Two");
        String s;
        while((s=ls.pop())!=null)
            System.out.println(s);
    }

    public static TwoTuple<String, String> tupleTest(){
        return new TwoTuple<String,String>("Abel","Atwood");
    }
}

class Tool{
    private String desc="This is a Tool!";
    public String getDesc(){
        return this.desc;
    }
}

class Automobile extends Tool{
    private String desc="This is an automobile!";
    public String getDesc(){
        return this.desc;
    }
}

class Benz extends Automobile{
    private String desc="This is a Benz car!";
    public String getDesc(){
        return this.desc;
    }
}

class Bike extends Tool{
    private String desc="This is a Bike!";
    public String getDesc(){
        return this.desc;
    }
}

class House{
    private String desc="This is a House!";
    public String getDesc(){
        return this.desc;
    }
}
//Specific Type Container
class Container1{
    private Automobile a;
    public Container1(Automobile a){
        this.a=a;
    }
    public Automobile get(){
        return this.a;
    }
}
//More General Container
class Container2{
    private Tool a;
    public Container2(Tool a){
        this.a=a;
    }
    public Tool get(){
        return this.a;
    }
}

//Even More General Conatainer
class Container3{
    private Object a;
    public Container3(Object a){
        this.a=a;
    }
    public Object get(){
        return this.a;
    }
}

//Ultimate Generalization
class Container4<T>{
    private T a;
    public Container4(T a){
        this.a=a;
    }
    public void set(T a){
        this.a=a;
    }
    public T get(){
        return this.a;
    }
}

class TwoTuple<A,B>{
    public final A a;
    public final B b;
    public TwoTuple(A a, B b){
        this.a=a;
        this.b=b;
    }

    public String toString(){
        return a+" "+b;
    }
}

class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
    public final C c;
    public ThreeTuple(A a, B b, C c){
        super(a,b);
        this.c=c;
    }
    public String toString(){
        return super.toString()+" "+c;
    }
}

class LinkedStack<T>{
    private static class Node<U>{
        U item;
        Node<U> next;

        Node(){
            this.item=null;
            this.next=null;
        }

        Node(U item, Node<U> next){
            this.item=item;
            this.next=next;
        }

        boolean end(){
            if(this.next==null&&this.item==null)
                return true;
            else
                return false;
        }
    }

    private Node<T> top=new Node<T>();
    public void push(T item){
        top=new Node<T>(item, top);
    }
    public T pop(){
        T result=top.item;
        if(top.item!=null){
            top=top.next;
        }
        return result;
    }

}
