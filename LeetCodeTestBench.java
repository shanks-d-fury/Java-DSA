
public class LeetCodeTestBench {

    public static String DecimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static void main(String[] args) {
        int decimal = 2024;
        System.out.println("Decimal : " + decimal + "\nBinery : " + DecimalToBinary(2024));
    }
}
