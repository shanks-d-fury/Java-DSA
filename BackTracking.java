public class BackTracking {

    public static void backtracking(int arr[], int i, int val) {
        if (i == arr.length) {
            System.out.println("Original array : ");
            printary(arr);
            return;
        }
        arr[i] = val;
        backtracking(arr, i + 1, val + 1);
        arr[i] = val - 2;
    }

    public static void stringSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("NULL");
            } else {
                System.out.println(ans);
            }
            return;
        }
        stringSubset(str, ans + str.charAt(i), i + 1);
        stringSubset(str, ans, i + 1);
    }

    public static void StringPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);
            StringPermutation(newstr, ans + c);
        }
    }

    public static void printary(int ary[]) {
        for (int n : ary) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        //
        StringPermutation("abc", "");
        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }
}
