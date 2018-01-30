public class ExceptionTest{
    public static void main(String...args) throws Throwable{
        try{
            System.out.println("Under this line, there will be an exception: ");
            throw new Throwable("Here is the exception!");
        }catch(Throwable t){
            System.out.println(t.getMessage());
            t.printStackTrace();
        }
        throw new Throwable("This is an exception test!");
    }
    
}