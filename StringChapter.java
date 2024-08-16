
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n){
        for(int i=n;i>0;i--){
            for(int k=n-1;k>=i;k--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = sc.nextInt();
        pattern(n);
        sc.close();
    }
}
