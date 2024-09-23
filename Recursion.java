
public class Recursion {

    public static void main(String[] args) {
        int ary[] = { 12, 54, 91, 23, 45, 67, 38, 82, 16, 29,
                33, 77, 64, 50, 89, 72, 18, 39, 55, 93,
                26, 47, 61, 84, 70, 35, 48, 95, 60, 73,
                11, 28, 49, 66, 53, 83, 40, 71, 24, 56,
                19, 32, 59, 90, 44, 87, 21, 63, 14, 34,
                78, 57, 25, 52, 80, 37, 62, 15, 41, 68,
                76, 27, 31, 86, 46, 13, 75, 22, 94, 30,
                43, 58, 81, 17, 69, 36, 74, 20, 92, 51,
                85, 65, 42, 88, 79, 96, 10, 99, 20, 66,
                31, 55, 50, 44, 77, 33, 71, 91, 25, 38 };
        printAry(ary);
        long startTime = System.currentTimeMillis();
        mergesort(ary, 0, ary.length - 1);
        long endTime = System.currentTimeMillis();
        printAry(ary);
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static void printAry(int ary[]) {
        for (int x : ary) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void mergesort(int ary[], int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2; // This caused trouble
        mergesort(ary, left, mid);
        mergesort(ary, mid + 1, right);
        merge(ary, left, mid, right);
    }

    public static void merge(int ary[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (ary[i] < ary[j]) {
                temp[k++] = ary[i++];
            } else {
                temp[k++] = ary[j++];
            }
        }

        while (j <= right) {
            temp[k++] = ary[j++];
        }
        while (i <= mid) {
            temp[k++] = ary[i++];
        }
        for (k = 0, i = left; k < temp.length; k++, i++) {
            ary[i] = temp[k];
        }
    }
}
