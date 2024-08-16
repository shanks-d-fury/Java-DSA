
import java.util.Scanner;

public class StringChapter {
    public static void pattern(int n){
        int sym=1;
        for(int i=0;i<n;i++){
           for(int j=0;j<=i;j++){
            System.out.print((sym==0?sym++:sym--)+" ");
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
