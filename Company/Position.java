package Company;

public interface Position{
    default void printClass(){
        System.out.println("I'm in "+this.getClass().getName());
    }

    static void printTest(){
        System.out.println("Static Interface Method Test!");
    };
}