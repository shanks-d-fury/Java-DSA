
import java.util.Random;

public class Array {

    public static void subArray(int arr[]) {
        // System.out.println(arr.length);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int iIndex = 0;
        int jIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println(" => " + sum);
                if (max < sum) {
                    max = sum;
                    iIndex = i;
                    jIndex = j;
                }
                sum = 0;
            }
            System.out.println();
        }
        System.out.println("The max sub array is :-");
        for (int i = iIndex; i <= jIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" => " + max);
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
        // int num[] = {1, -2, 6, -1, 3};
        int[] randomArray = generateRandomArray(10, -100, 100); // Generate an array of 10 integers between 0 and 100
        // System.out.println(num[4]);
        subArray(randomArray);
    }
}
