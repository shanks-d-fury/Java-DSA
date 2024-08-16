
import java.util.Scanner;

public class StringChapter {
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int n){
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = sc.nextInt();
        printPrime(n);
        sc.close();
    }
}
