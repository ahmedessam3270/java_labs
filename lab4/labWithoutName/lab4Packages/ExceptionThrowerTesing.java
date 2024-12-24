package lab4Packages;

public class ExceptionThrowerTesing {
    public static void test () throws NewException {
        
        ExceptionThrower.divideTwoNumbers(24.5,0);

        ExceptionThrower.getTheSqrt(-43);

        int[] myArr = {1,2,3,4,5};
        ExceptionThrower.returnElementFromArr(myArr, 10);
    }
}
