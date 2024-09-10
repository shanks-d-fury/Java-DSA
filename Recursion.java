
public class Recursion {

    public static void main(String[] args) {
        // System.out.println(recursionfact(4));
        // fabanoci(3);
        fabanociSeries(10);
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
            System.out.println("fabnoci(" + n + ") => " + fabanoci(n));
            return;
        }
        fabanociSeries(n - 1);
        System.out.println("fabnoci(" + n + ") => " + fabanoci(n));
    }
}
