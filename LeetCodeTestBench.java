
public class LeetCodeTestBench {

    public static int[] plusOne(int[] digits) {
        //shortest ans possible 
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        //this above line creates a new ary of length+1 and all the element will be zero intially and then further first element is made 1;
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOnex(int[] digits) {
        // This is my own code of O(n) time complexity and O(1) space complexity 
        int n = digits.length;
        int sum;
        int cary = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + cary;
            }
            if (sum > 9) {
                cary = (sum) % 9;
                digits[i] = sum % 10;
            } else {
                digits[i] = sum;
                break;
            }
            if (sum > 9 && i == 0) {
                int ary[] = new int[digits.length + 1];
                ary[0] = cary;
                int j = 1;
                for (int x : digits) {
                    ary[j] = x;
                    j++;
                }
                return ary;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int testAry[] = {9, 9, 9, 9};
        int ansAry[] = plusOnex(testAry);
        // Arrays.sort(ansAry);
        for (int x : ansAry) {
            System.out.print(x + " ");
        }
    }
}
