
public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.generateRandomArray(5, -500, 500);
        //
        long startTime = System.currentTimeMillis();
        //
        // System.out.println(Arrays.toString(testArray));
        int size = 10, min = -5, max = 5;
        Genarate_Random.IntArray(size, min, max);
        Genarate_Random.CharArray(size, 'a', 'z');
        Genarate_Random.StringArray(size, 5, true, 2);
        Genarate_Random.DoubleArray(size, min, max);
        Genarate_Random.AlphaArray(size, false);
        Genarate_Random.BooleanArray(size);
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

}
