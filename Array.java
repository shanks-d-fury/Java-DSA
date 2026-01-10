
import java.util.Random;

public class Array {

    public static int Buy_Sell_Stock(int StockArray[]) {
        for (int x : StockArray) {
            System.out.print(x + ",");
        }
        System.out.println();
        int maxProfit = 0, Profit;
        int buyPrice = StockArray[0], sellDay = 1, buyDay;
        for (int i = 1; i < StockArray.length; i++) {
            Profit = StockArray[i] - buyPrice;
            if (StockArray[i] > buyPrice) {
                if (Profit > maxProfit) {
                    maxProfit = Profit;
                    sellDay = i + 1;
                }
            } else {
                buyPrice = StockArray[i];
            }
        }
        buyDay = findDayByValue(StockArray, StockArray[sellDay - 1] - maxProfit);
        System.out.println("Buy & Sell ==> " + buyDay + "," + sellDay + " Profit: " + maxProfit);
        return maxProfit;
    }

    public static int findDayByValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i + 1;
            }
        }
        return 0;
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
        // int num[] = {7, 6, 4, 3, 1};
        // int num2[] = {9, 2, 1, 8, 10, 4, 9, 8, 0, 3};
        // int num3[] = {4, 2, 0, 6, 3, 2, 5}; //Apna college questions example
        // int num4[] = {7, 1, 5, 3, 6, 4};
        // int num5[] = {1, 5, 3, 5, 9, 2, 0, 5, 1, 7};
        this line has an error 
        int randomArray[] = generateRandomArray(100, 0, 100); // Generate an array of 10 integers between 0 and 100
        System.out.println(Buy_Sell_Stock(randomArray));
    }
}
