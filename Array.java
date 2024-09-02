
import java.util.Random;

public class Array {

    public static int Buy_Sell_Stock(int StockArray[]) {
        for (int x : StockArray) {
            System.out.print(x + ",");
        }
        System.out.println();
        int maxprofit = 0;
        int buyDay = 0, sellDay = 0;
        for (int i = 0; i < StockArray.length - 1; i++) {
            for (int j = i + 1; j < StockArray.length; j++) {
                if (StockArray[j] - StockArray[i] > maxprofit) {
                    maxprofit = StockArray[j] - StockArray[i];
                    buyDay = i;
                    sellDay = j;
                }
            }
        }
        buyDay++;
        sellDay++;
        System.out.println("Buy & Sell ==> " + buyDay + "," + sellDay + " Profit: " + maxprofit);
        return maxprofit;
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
        // int num2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // int num3[] = {4, 2, 0, 6, 3, 2, 5}; //Apna college questions example
        // int num4[] = {7, 1, 5, 3, 6, 4};
        int num5[] = {1, 5, 3, 5, 9, 2, 0, 5, 1, 7};
        // int randomArray[] = generateRandomArray(10, 0, 10); // Generate an array of 10 integers between 0 and 100
        Buy_Sell_Stock(num5);
    }
}
