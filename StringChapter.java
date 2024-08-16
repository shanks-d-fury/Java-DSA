
import java.util.Scanner;

public class StringChapter {
    public static void BinToDec(int n){
        int sum=0;
        int i=0;
        while(n>0){
            sum=(int) (sum+(n%10*Math.pow(2, i)));
            n=n/10;
            i++;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = sc.nextInt();
        BinToDec(n);
        sc.close();
    }
}
