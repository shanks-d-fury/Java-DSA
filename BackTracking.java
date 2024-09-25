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

    public static void printary(int ary[]) {
        for (int n : ary) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        //
        int arr[] = new int[10];
        backtracking(arr, 0, 1);
        //
        long endTime = System.currentTimeMillis();
        //
        System.out.println("\nBackTrancked array : ");
        printary(arr);
        //
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }
}
