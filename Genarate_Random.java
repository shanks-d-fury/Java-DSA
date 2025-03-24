import java.util.Arrays;
import java.util.Random;

public class Genarate_Random {
    // Original method for int arrays
    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        System.out.println("Random Generated Int Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    // Method for double arrays
    public static double[] generateRandomDoubleArray(int size, double min, double max) {
        Random rand = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + (max - min) * rand.nextDouble();
        }
        System.out.println("Random Generated Double Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    // Method for char arrays (generates random lowercase letters by default)
    public static char[] generateRandomCharArray(int size, char min, char max) {
        Random rand = new Random();
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            array[i] = (char) (min + rand.nextInt(max - min + 1));
        }
        System.out.println("Random Generated Char Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    // Convenience method for alphabet characters
    public static char[] generateRandomAlphaArray(int size, boolean lowercase) {
        char min = lowercase ? 'a' : 'A';
        char max = lowercase ? 'z' : 'Z';
        return generateRandomCharArray(size, min, max);
    }

    // Method for boolean arrays
    public static boolean[] generateRandomBooleanArray(int size) {
        Random rand = new Random();
        boolean[] array = new boolean[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextBoolean();
        }
        System.out.println("Random Generated Boolean Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    // Generate an array of random strings
    public static String[] generateRandomStringArray(int arraySize, int maxStringLength, boolean lowercase) {
        Random rand = new Random();
        String[] array = new String[arraySize];

        // Define character range based on case preference
        char minChar = lowercase ? 'a' : 'A';
        char maxChar = lowercase ? 'z' : 'Z';
        int charRange = maxChar - minChar + 1;

        for (int i = 0; i < arraySize; i++) {
            // Randomly determine string length (between 1 and maxStringLength)
            int stringLength = rand.nextInt(maxStringLength) + 1;

            // Build a random string with the determined length
            StringBuilder sb = new StringBuilder(stringLength);
            for (int j = 0; j < stringLength; j++) {
                char randomChar = (char) (minChar + rand.nextInt(charRange));
                sb.append(randomChar);
            }

            array[i] = sb.toString();
        }

        System.out.println("Random Generated String Array (" +
                (lowercase ? "lowercase" : "uppercase") + "): ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }
}
