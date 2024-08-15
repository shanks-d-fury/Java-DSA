public class StringChapter {
    
    public static void main(String[] args) {
        int a=-10;
        int b=-20;
        int c=-30;
        String x= a>c?(a>b?"a":"b"):(c>b?"c":"b");
        System.out.println("Largest is "+x);
    }
}
