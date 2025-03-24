
public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.generateRandomArray(5, -500, 500);
        //
        long startTime = System.currentTimeMillis();
        //
        // System.out.println(Arrays.toString(testArray));
        int size = 10, min = -5, max = 5;
        Genarate_Random.generateRandomIntArray(size, min, max);
        Genarate_Random.generateRandomCharArray(size, 'a', 'z');
        Genarate_Random.generateRandomStringArray(size, 5, true);
        Genarate_Random.generateRandomDoubleArray(size, min, max);
        Genarate_Random.generateRandomAlphaArray(size, false);
        Genarate_Random.generateRandomBooleanArray(size);
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

}
