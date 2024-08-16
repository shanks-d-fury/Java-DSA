
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n){
        for(int i=0;i<n;i++){
           if(i==0 || i==n-1){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
           }
           else{
            for(int j=0;j<n;j++){
                if(j==0 || j==n-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
           }
           System.out.print("\n");
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
