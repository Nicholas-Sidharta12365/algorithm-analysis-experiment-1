import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortBenchmark {

    public static void main(String[] args) {
        String[] fileNames = {
            "sorted_512.txt", "randomized_512.txt", "reverse_sorted_512.txt",
            "sorted_8192.txt", "randomized_8192.txt", "reverse_sorted_8192.txt",
            "sorted_65536.txt", "randomized_65536.txt", "reverse_sorted_65536.txt"
        };

        for (String fileName : fileNames) {
            int[] array = readArrayFromFile(fileName);
            
            // Benchmark TwoPivotBlockQuickSort
            long startTime = System.nanoTime();
            TwoPivotBlockQuickSort.twoPivotBlockQuicksort(array, 0, array.length - 1);
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1_000_000; // in milliseconds
            System.out.println("TwoPivotBlockQuickSort for " + fileName + ": " + executionTime + " ms");

            // Restore the original array
            array = readArrayFromFile(fileName);

            // Benchmark MergeSort
            startTime = System.nanoTime();
            MergeSort.mergeSort(array);
            endTime = System.nanoTime();
            executionTime = (endTime - startTime) / 1_000_000; // in milliseconds
            System.out.println("MergeSort for " + fileName + ": " + executionTime + " ms");

            System.out.println(); // Add a newline for separation
        }
    }

    public static int[] readArrayFromFile(String fileName) {
        int[] array = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if (array == null) {
                    array = new int[countLines(fileName)];
                }
                array[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static int countLines(String fileName) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
