
public class Recursion {

    public static void main(String[] args) {
        // System.out.println(recursionfact(4));
        IncOrd(20);
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
}
