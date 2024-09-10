
public class Recursion {

    public static void main(String[] args) {
        recursion(10);
    }

    public static void recursion(int n) {
        System.out.println(n);
        if (n == 0) {
            return;
        }
        recursion(n - 1);
    }
}
