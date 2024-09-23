

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[] = { 45, 48, 51, 53, 57, 63, 67, 70, 74, 79, 83, 1, 5, 9, 15, 21, 28, 32, 37, 41 };
        //
        int key = 1;
        long startTime = System.currentTimeMillis();
        //
        System.out.println(sortedRotatedArray(testArray, key, 0, testArray.length - 1));
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

    public static int sortedRotatedArray(int ary[], int tar, int st, int ed) {
        // Base case
        if (st > ed) {
            return -1;
        }

        // target found
        int mid = st + (ed - st) / 2;
        if (ary[mid] == tar) {
            return mid;
        }

        if (ary[st] <= ary[mid]) {
            if (ary[st] <= tar && tar <= ary[mid]) {
                return sortedRotatedArray(ary, tar, st, mid - 1);
            } else {
                return sortedRotatedArray(ary, tar, mid + 1, ed);
            }
        } else {
            if (ary[mid] <= tar && tar <= ary[ed]) {
                return sortedRotatedArray(ary, tar, mid + 1, ed);
            } else {
                return sortedRotatedArray(ary, tar, st, mid - 1);
            }
        }
    }
}
