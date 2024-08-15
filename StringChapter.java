
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
        System.out.print("\nEnter the num : ");
        int ab=sc.nextInt();
        int rev=0;
        while(ab>0){
            rev=(rev*10)+(ab%10);
            ab=ab/10;
            if(ab<=0){
                ab=rev;
                break;
            }
            // //or there is an another way 
            // System.out.print(ab%10);
            // ab=ab/10;
        }
        System.out.println(ab);
        sc.close();
    }
}
