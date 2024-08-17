
import java.util.Random;

public class Array {

    public static void subArray(int arr[]) {
        System.out.println("The Building Array layout :- ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
        int n = arr.length;
        int i, j;
        int TotalWaterCapacity = 0;

        int leftIndex = 0;
        int rightIndex = n - 1;

        int leftMaxHeightArray[] = new int[n];
        int rightMaxHeightArray[] = new int[n];
        leftMaxHeightArray[0] = arr[0];
        rightMaxHeightArray[n - 1] = arr[n - 1];

        for (i = 1, j = n - 2; i < n && j >= 0; j--, i++) {
            if (leftMaxHeightArray[leftIndex] < arr[i]) {
                leftMaxHeightArray[i] = arr[i];
                leftIndex = i;
            } else {
                leftMaxHeightArray[i] = leftMaxHeightArray[leftIndex];
            }
            if (rightMaxHeightArray[rightIndex] < arr[j]) {
                rightMaxHeightArray[j] = arr[j];
                rightIndex = j;
            } else {
                rightMaxHeightArray[j] = rightMaxHeightArray[rightIndex];
            }
        }

        //Printing the Left and Right array
        System.out.println("Left max height array :- ");
        for (int x : leftMaxHeightArray) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("\nRight max height array :- ");
        for (int x : rightMaxHeightArray) {
            System.out.print(x + " ");
        }

        //Finding the water storing capacity 
        for (i = 0; i < n - 1; i++) {
            TotalWaterCapacity += Math.min(leftMaxHeightArray[i], rightMaxHeightArray[i]) - arr[i];
        }
        System.out.println("\n\nTotal Water Capacity :- " + TotalWaterCapacity);
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }

        return array;
    }

    public static void main(String[] args) {
        int num[] = {1, -2, 6, -1, 3};
        int num2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int num3[] = {4, 2, 0, 6, 3, 2, 5};//Apna college questions example
        int randomArray[] = generateRandomArray(5, 0, 10); // Generate an array of 10 integers between 0 and 100
        subArray(randomArray);
    }
}
