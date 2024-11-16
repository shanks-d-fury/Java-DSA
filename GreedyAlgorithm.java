
import java.util.Arrays;

public class GreedyAlgorithm {
    public static void main(String args[]) {
        int notes[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int value = 590;
        Arrays.sort(notes);
        int i = notes.length - 1;
        int note = 0;
        while (value > 0) {
            if (notes[i] > value) {
                i--;
            } else {
                note++;
                value -= notes[i];
            }
        }
        System.out.println("Max notes used : " + note);
    }
}
