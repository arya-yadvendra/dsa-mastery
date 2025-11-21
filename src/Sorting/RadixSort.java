package Sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {12, 3, 24, 394, 90, 9};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        int max = Arrays.stream(arr).max().getAsInt();

        // Performing counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // Counting sort based on digit (exp = 1 → units, 10 → tens)
    private static void countSort(int[] arr, int exp) {
        int len = arr.length;
        int[] output = new int[len];
        int[] count = new int[10]; // digits 0-9

        // Count occurrences of digits
        for (int value : arr) {
            int digit = (value / exp) % 10;
            count[digit]++;
        }

        // Convert count[] to cumulative frequency
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (Traversal should be reverse for stability)
        for (int i = len - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy back to original array
        System.arraycopy(output, 0, arr, 0, len);
    }
}
