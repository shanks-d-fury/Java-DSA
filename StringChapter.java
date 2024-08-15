
import java.util.Scanner;

public class StringChapter {
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the num : ");
        char[] x=sc.next().toCharArray();
        for(int i=x.length-1;i>=0;i--){
            System.out.print(x[i]);
        }
        System.out.print("\nEnter the num : ");
        String sx=sc.next();
        StringBuilder sb=new StringBuilder(sx);
        System.out.println(sb.reverse());
        sc.close();
    }
}
