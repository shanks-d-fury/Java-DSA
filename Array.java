
import java.util.Random;

public class Array {

    public static void Buy_Sell_Stock(int StockArray[]) {
        for (int x : StockArray) {
            System.out.print(x + ",");
        }
        System.out.println();
        int n = StockArray.length;
        int curBuyDay = 0;
        int BuyDay = 1;
        int SellDay = 0;

        int SellPrice;
        int BuyPrice = Integer.MAX_VALUE;
        int Profit = 0;
        int MaxProfit = 0;
        int MaxProfitArray[] = new int[n];

        for (int i = 0; i < n; i++) {
            SellPrice = StockArray[i];
            Profit = SellPrice - BuyPrice;
            if (BuyPrice < SellPrice) {
                if (Profit > MaxProfit) {
                    MaxProfit = Profit;
                    SellDay = i + 1;
                    MaxProfitArray[i] = MaxProfit;
                }
            } else {
                BuyPrice = SellPrice;
                BuyDay = i + 1;
                if (Profit > 0) {
                    BuyDay = i + 1;
                }
            }
            System.out.println("B: " + BuyDay + " S: " + SellDay + " MP: " + MaxProfit + " Pro: " + Profit + " SP: " + SellPrice + " BP: " + BuyPrice);
        }
        // System.out.println("B: " + BuyDay + " S: " + SellDay + " MP: " + MaxProfit);
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
        int num4[] = {7, 1, 5, 3, 6, 4};
        int num5[] = {1, 5, 3, 5, 9, 2, 0, 5, 1, 7};
        int randomArray[] = generateRandomArray(10, 0, 10); // Generate an array of 10 integers between 0 and 100
        Buy_Sell_Stock(randomArray);
    }

    public static void sort(String[] s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}
