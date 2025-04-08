
import java.util.Scanner;

public class app {
    public static void main(String args[]) {
        System.out.println("hello shanks");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            int v = n, c = n - 2;
            System.out.println(1);
            for (int i = 1; i < n; i++) {
                System.out.print(v + " ");
                int x = 0;
                for (int j = n - 1; j > n - i - 1; j--) {
                    x += j;
                    System.out.print(v - x + " ");
                }
                v = v + c--;
                System.out.println();
            }
        }
    }
}
