import java.util.Arrays;
import java.util.Random;

public class Genarate_Random {
    // Original method for int arrays
    public static int[] IntArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        System.out.println("Random Generated Int Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    public static int[][] Int2DArray_nxn(int size, int min, int max) {
        Random rand = new Random();
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
        System.out.println("Random Generated Int Array: ");
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        return array;
    }

    public static int[][] Int2DArray_mxn(int m, int n, int min, int max) {
        Random rand = new Random();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
        System.out.println("Random Generated Int Array: ");
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        return array;
    }

    // Method for double arrays
    public static double[] DoubleArray(int size, double min, double max) {
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
    public static char[] CharArray(int size, char min, char max) {
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
    public static char[] AlphaArray(int size, boolean lowercase) {
        char min = lowercase ? 'a' : 'A';
        char max = lowercase ? 'z' : 'Z';
        return CharArray(size, min, max);
    }

    // Method for boolean arrays
    public static boolean[] BooleanArray(int size) {
        Random rand = new Random();
        boolean[] array = new boolean[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextBoolean();
        }
        System.out.println("Random Generated Boolean Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }

    // Generate an array of random strings with case control
    public static String[] StringArray(int arraySize, int StringLength, boolean randomLength, int caseOption) {
        Random rand = new Random();
        String[] array = new String[arraySize];

        String caseType;
        switch (caseOption) {
            case 0 -> // lowercase
                caseType = "lowercase";
            case 1 -> // uppercase
                caseType = "uppercase";
            case 2 -> // mixed case
                caseType = "mixed case";
            default -> {
                caseType = "lowercase";
                caseOption = 0; // default to lowercase
            }
        }

        for (int i = 0; i < arraySize; i++) {
            // Determine string length based on randomLength parameter
            int stringLength;
            if (randomLength) {
                // Random length between 1 and StringLength
                stringLength = rand.nextInt(StringLength) + 1;
            } else {
                // Fixed length equal to StringLength
                stringLength = StringLength;
            }

            // Build a random string with the determined length
            StringBuilder sb = new StringBuilder(stringLength);
            for (int j = 0; j < stringLength; j++) {
                char randomChar;

                switch (caseOption) {
                    case 0 -> // Lowercase only (a-z)
                        randomChar = (char) ('a' + rand.nextInt(26));
                    case 1 -> // Uppercase only (A-Z)
                        randomChar = (char) ('A' + rand.nextInt(26));
                    default -> {
                        // Mixed case - randomly choose between uppercase and lowercase
                        if (rand.nextBoolean()) {
                            randomChar = (char) ('A' + rand.nextInt(26));
                        } else {
                            randomChar = (char) ('a' + rand.nextInt(26));
                        }
                    }
                }

                sb.append(randomChar);
            }

            array[i] = sb.toString();
        }

        System.out.println("Random Generated String Array (" + caseType + ", " +
                (randomLength ? "random length" : "fixed length") + "): ");
        System.out.println(Arrays.toString(array) + "\n");
        return array;
    }
}
