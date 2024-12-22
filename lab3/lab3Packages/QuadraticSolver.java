package lab3Packages;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.*;

public class QuadraticSolver implements Function<double[], double[]> {

    @Override
    public double[] apply(double[] constants)  {

        int noOfConstants = constants.length;

        if (noOfConstants != 3)
            throw new IllegalArgumentException("Please enter valid input");
        double a = constants[0];
        double b = constants[1];
        double c = constants[2];

        double underTheRoot = (b * b) - (4 * a * c);
        if (a == 0) {
            throw new IllegalArgumentException("can't divide by zero");
        }

        double firstNo;
        double secondNo;

        if (underTheRoot < 0){
            throw new IllegalArgumentException("we can't handle complex numbers here");
        }else if (underTheRoot == 0) {
            firstNo = -b / 2 * a;
            secondNo = firstNo;
        } else {
            firstNo = (-b + Math.sqrt(underTheRoot)) / (2 * a);
            secondNo = (-b - Math.sqrt(underTheRoot)) / (2 * a);
        }

        double[] resultSquares = { firstNo, secondNo };
        return resultSquares;
    }

}