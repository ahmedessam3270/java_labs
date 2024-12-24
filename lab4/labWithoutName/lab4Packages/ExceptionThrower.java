package lab4Packages;

public class ExceptionThrower {
    public static double divideTwoNumbers(double num1, double num2) throws NewException{
        if (num2 == 0) throw new NewException("can't divide by zero");
        return num1 / num2;
    }

    public static int returnElementFromArr(int[] arr, int index) throws NewException{
        if (index >= arr.length) throw new NewException("out of range");
        return arr[index];
    }
    public static double getTheSqrt(double num) throws NewException{
        if (num < 0) throw new NewException("can't calculate the square root of a negative number");
        return Math.sqrt(num);
    }


}
