
import java.util.Scanner;
//Till this commit this File is used as the pattern file the string is done after the 2D array chapter
public class StringChapter {
    public static void pattern(int n){
        for(int i=0;i<n;i++){
           for(int k=n-i;k>0;k--){
                System.out.print(" ");
           } 
           for(int j=0;j<=i;j++){
            System.out.print("* ");
           }
           System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int k=n-i;k>=0;k--){
                 System.out.print(" ");
            } 
            for(int j=0;j<=i-1;j++){
             System.out.print("* ");
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
