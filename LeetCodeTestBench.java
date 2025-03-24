import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[] = Genarate_Random.generateRandomArray(5, -500, 500);
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(Arrays.toString(testArray));
        System.out.println(containsDuplicate(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    // {Given an integer array nums, return true if any value appears at least twice
    // in the array, and return false if every element is distinct.}

    public static boolean containsDuplicate(int[] nums) {
        LinkedHashSet<Integer> hm = new LinkedHashSet<>();
        for (int x : nums) {
            if (hm.contains(x)) {
                return true;
            } else {
                hm.add(x);
            }
        }
        // HashSet<Integer> set = new HashSet<>();
        // Add elements to set
        System.out.println("Using the stream and s foreach method : ");
        hm.stream().forEach(System.out::println);
        System.out.println("Using the iterator : ");
        Iterator<Integer> iterator = hm.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
            // You can also remove elements while iterating
            // iterator.remove();
        }
        System.out.println("Using the forEach : ");
        // Add elements to set
        hm.forEach(value -> {
            System.out.println(value);
        });
        return false;
    }

}
