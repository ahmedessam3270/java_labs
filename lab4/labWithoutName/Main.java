import lab4Packages.ExceptionThrowerTesing;
import lab4Packages.NewException;

public class Main {
    public static void main (String[] args){
        try{
            ExceptionThrowerTesing.test();
        }catch(NewException ne){
            System.out.println(ne);
        }finally{
            System.out.println("This is my test cases");
        }
    }
}
