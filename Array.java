
import java.util.Random;

public class Array {

    public static void subArray(int arr[]) {
        int prefixArr[] = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int iIndex = 0;
        int jIndex = 0;
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }
        for (int i = 0; i < prefixArr.length; i++) {
            for (int j = i; j < prefixArr.length; j++) {
                sum = i == 0 ? prefixArr[j] : prefixArr[j] - prefixArr[i - 1];
                if (max < sum) {
                    max = sum;
                    iIndex = i;
                    jIndex = j;
                }
            }
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
        int num[] = {1, -2, 6, -1, 3};
        // int[] randomArray = generateRandomArray(5, -100, 100); // Generate an array of 10 integers between 0 and 100
        // System.out.println(num[4]);
        subArray(num);
    }
}
