
public class Recursion {

    public static void main(String[] args) {
        // System.out.println(recursionfact(4));
        // fabanoci(3);
        // System.out.println(binetFabanoci(10));
        long startTime = System.currentTimeMillis();
        // fabanociSeries(45);
        int arr[] = {15, 2, 10, 14, 15, 20, 16, 201, 12, 15};
        System.out.println(firstOccurance(arr, 0, 15));
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static void IncOrd(int n) {
        if (n == 1) {
            System.out.println("fact(" + n + ") => " + recursionfact(n));
            return;
        }
        IncOrd(n - 1);
        System.out.println("fact(" + n + ") => " + recursionfact(n));
    }

    public static long recursionfact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * recursionfact(n - 1);
    }

    public static int fabanoci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int n1 = fabanoci(n - 1);
        int n2 = fabanoci(n - 2);
        return n1 + n2;
    }

    public static void fabanociSeries(int n) {
        if (n == 0) {
            System.out.println("fabnoci(" + n + ") => " + binetFabanoci(n));
            return;
        }
        fabanociSeries(n - 1);
        System.out.println("fabnoci(" + n + ") => " + binetFabanoci(n));
    }

    public static int binetFabanoci(int n) {
        int ans;
        float theta = (float) ((1 + Math.sqrt(5)) / 2);
        float py = (float) ((1 - Math.sqrt(5)) / 2);
        ans = (int) ((int) (Math.pow(theta, n) + Math.pow(py, n)) / Math.sqrt(5));
        return ans;
    }

    public static int firstOccurance(int arr[], int i, int key) {
        if (arr[i] == key) {
            return i;
        }
        if (i == arr.length - 1) {
            return -1;
        }
        return firstOccurance(arr, i + 1, key);
    }
}
