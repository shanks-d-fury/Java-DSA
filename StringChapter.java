
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n){
        int chars=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++,chars++){
                System.out.print(chars+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the n : ");
            int n = sc.nextInt();
            pattern(n);
        }
    }
}
