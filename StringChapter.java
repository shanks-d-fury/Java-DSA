
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n,int m){
        for(int i=0;i<n;i++){
            if(i==0 || i==n-1){
                for(int j=0;j<m;j++){
                    System.out.print("* ");
                }
               }
               else{
                for(int j=0;j<m;j++){
                    if(j==0 || j==m-1){
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
        System.out.print("Enter the lenght : ");
        int n = sc.nextInt();
        System.out.print("Enter the breath : ");
        int m = sc.nextInt();
        pattern(n,m);
        sc.close();
    }
}
