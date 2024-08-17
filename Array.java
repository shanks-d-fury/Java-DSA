
import java.util.Random;

public class Array {

    public static void subArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int iIndex = 0;
        int jIndex = 0;
        boolean count = false;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                count = false;
            }
            if (sum > max) {
                max = sum;
                jIndex = i;
                if (max > 0 && count == false) {
                    iIndex = i;
                }
                count = true;
            }
        }
        System.out.println("start index : " + iIndex + " " + "End index : " + jIndex);
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
        int num[] = {1, -2, 6, -1, 3};
        int num2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] randomArray = generateRandomArray(5, -10, 10); // Generate an array of 10 integers between 0 and 100
        // System.out.println(num[4]);
        subArray(randomArray);
    }
}
