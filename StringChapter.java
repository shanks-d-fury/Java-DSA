
import java.util.Scanner;

public class StringChapter {
    public static int fact(int n){
        // //simple using the loop
        // int factx=1;
        // while(n>0){
        //     factx=n*factx;
        //     n--;
        // }
        // System.out.println(factx);

        //now using the recursion 
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = sc.nextInt();
        System.out.print("Enter the r : ");
        int r = sc.nextInt();
        double x=fact(n)/(fact(r)*fact(n-r));
        System.out.println(x);
        sc.close();
    }
}
