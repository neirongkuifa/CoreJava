public class AnonInnerClass{
    public static void main(String...args){
        Runnable r=new Runnable(){
        
            @Override
            public void run() {
                System.out.println("The Animal Runs Away!");
            }
        };

        Rabbit(r);
        Rabbit(()->{System.out.println("The rabbit is in lambda!");});
    }

    public static void Rabbit(Runnable r){
        r.run();
    }
}