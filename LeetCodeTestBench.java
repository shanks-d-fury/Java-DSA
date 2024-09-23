import java.util.Arrays;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        String testArray[] = { "introspection", // because of this the longest common prefix is "int";
                "intermediate",
                "internet",
                "interval",
                "internal",
                "interlock",
                "interaction",
                "intercept",
                "interesting",
                "international",
                "interpret",
                "interstate",
                "intervene",
                "intermittent",
                "interceptive",
                "interchangeable",
                "interpolate",
                "intermediate",
                "interrelation",
                "interrogation" };
        // printAry(testArray);
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(longestCommonPrefix(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");

    }

    public static void printAry(String ary[]) {
        for (String x : ary) {
            System.out.println(x);
        }
        System.out.println();
    }

    public static String longestCommonPrefix(String[] strs) {
        String lcp = new String();
        Arrays.sort(strs);
        // printAry(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return lcp;
            }
            lcp += strs[0].charAt(i);
        }
        return lcp;
    }
}
