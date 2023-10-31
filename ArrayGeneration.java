import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArrayGeneration {

    public static void main(String[] args) {
        int[] lengths = {512, 8192, 65536}; // 2^9, 2^13, 2^16

        for (int length : lengths) {
            int[] sortedArray = generateSortedArray(length);
            int[] randomizedArray = generateRandomizedArray(length);
            int[] reverseSortedArray = generateReverseSortedArray(length);

            writeArrayToFile("sorted_" + length + ".txt", sortedArray);
            writeArrayToFile("randomized_" + length + ".txt", randomizedArray);
            writeArrayToFile("reverse_sorted_" + length + ".txt", reverseSortedArray);
        }
    }

    public static int[] generateSortedArray(int length) {
        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            sortedArray[i] = i;
        }
        return sortedArray;
    }

    public static int[] generateRandomizedArray(int length) {
        int[] randomizedArray = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomizedArray[i] = random.nextInt();
        }
        return randomizedArray;
    }

    public static int[] generateReverseSortedArray(int length) {
        int[] reverseSortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            reverseSortedArray[i] = length - 1 - i;
        }
        return reverseSortedArray;
    }

    public static void writeArrayToFile(String filename, int[] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
