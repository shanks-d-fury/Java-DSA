
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n*2;j++){
                if(j<=i){
                    System.out.print("* ");
                }
                else  if (j>n*2-i) {
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=n*2;j++){
                if(j<=i){
                    System.out.print("* ");
                }
                else  if (j>n*2-i) {
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
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
