
public class Type<S, T>{
    public static void main(String...args){
        Type<String, Pair<String>> type=new Type("Abel", new Pair<String>(String::new));
        //type.setS(new Pair<String>(String::new));
    }

    // public static void flip(Type<?,?> p){
    //     Object o=p.s;
    //     p.s=p.t;
    //     p.t=o;
    // }

    private S s;
    private T t;
    public Type(S s, T t){
        this.s=s;
        this.t=t;
    }

    public void setS(S s){
        this.s=s;
    }
}