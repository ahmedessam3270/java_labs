
import java.util.Random;

public class RandNumberMinMaxSearch {
    public static void main(String[] args){
        int randomNumbersLength = 1000;
        int[] randomNumbersArray = new int[randomNumbersLength];
        
        Random random = new Random();

        for (int i = 0; i< randomNumbersLength; i++){
            randomNumbersArray[i] = random.nextInt(randomNumbersLength) + 1;
        }

        System.out.println("Random Numbers in the array");

        for (int number: randomNumbersArray){
            System.out.print(number+ "\t");
        }


        // finding the minimum and maximum numbers in the random array

        System.out.println("\n");

        MinMaxLinearSearch minMax = new MinMaxLinearSearch(randomNumbersArray);
        minMax.searchForMinMax(randomNumbersArray);
        System.out.println("Minimum number in the array is "+ minMax.getMin());
        System.out.println("Maximum number in the array is "+ minMax.getMax());
        System.out.println("Estimated Time of the process "+ minMax.getEstimatedTime());  
    }
    
}

class MinMaxLinearSearch {
    private int min;
    private int max;
    private long estimatedTime;

    public MinMaxLinearSearch(int[] randomArray){
        min = randomArray[0];
        max = randomArray[0];
    }

    public void searchForMinMax(int[] randomArray){
        if(randomArray.length > 0){
            long startTime = System.nanoTime();
            for (int i = 0; i<randomArray.length; i++){
                if (randomArray[i] > max) max = randomArray[i];
                if (randomArray[i] < min) min = randomArray[i];
            }
            estimatedTime = System.nanoTime() - startTime;
           }else {
            System.out.println("please enter a valid string");
           }
    }

    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
    public long getEstimatedTime(){
        return estimatedTime;
    }
    
}
