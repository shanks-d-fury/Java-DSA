
import java.util.Scanner;
public class app {
    public static void main(String args[]){
        System.out.println("hello shanks");
        try (Scanner sc = new Scanner (System.in)) {
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            for (int i =0;i<=n;i++){
                for(int j=0;j<i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
