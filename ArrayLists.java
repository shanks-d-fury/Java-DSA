import java.util.ArrayList;

public class ArrayLists {
    public static void main(String args[]) {
        int[] heightx = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        ArrayList<Integer> height = new ArrayList<>();
        for (int x : heightx) {
            height.add(x);
        }
        int maxArea = 0, crntArea;
        int left = 0, right = height.size() - 1;
        int leftIndex = -1, rightIndex = -1;
        while (left < right) {
            crntArea = (right - left) * (Math.min(height.get(right), height.get(left)));
            if (maxArea < crntArea) {
                maxArea = crntArea;
                leftIndex = left;
                rightIndex = right;
            }
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("(" + leftIndex + "," + rightIndex + ")" + " Area = " + maxArea);
    }
}