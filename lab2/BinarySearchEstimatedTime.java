public class BinarySearchEstimatedTime {
    public static void main(String args[]){
        int ARRAY_LENGTH = 1000;
        int[] sortedArr = new int[ARRAY_LENGTH];
        
        for (int i = 0; i<ARRAY_LENGTH; i++){
            sortedArr[i] = i+1;
        }

        BinarySearch searchForInt = new BinarySearch();

        searchForInt.search(sortedArr, 1000);

        System.out.println("the index is " + searchForInt.getIndex());
        System.out.println("The estimated time is " + searchForInt.getEstimatedTime());


        
    }
}

class BinarySearch {
    private int index = -1; 
    private long estimatedTime = 0;

    public void search(int[] arr, int number) {
        int start = 0;
        int end = arr.length - 1;
        long startTime = System.nanoTime();
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == number) {
                index = mid;
                estimatedTime = System.nanoTime() - startTime;
                return;
            } else if (arr[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public long getEstimatedTime(){
        return estimatedTime;
    }
}