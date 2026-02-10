import java.io.*;
import java.util.*;

public class Task3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().trim().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            long maxSubarray = kadane(arr);
            long maxSubsequence = maxSubsequence(arr);

            System.out.println(maxSubarray + " " + maxSubsequence);
        }
    }

    // Kadane's Algorithm for maximum subarray sum
    private static long kadane(int[] arr) {
        long maxSoFar = arr[0];
        long currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    // Maximum subsequence sum
    private static long maxSubsequence(int[] arr) {
        long sum = 0;
        int maxElement = arr[0];

        for (int x : arr) {
            if (x > 0) sum += x;
            maxElement = Math.max(maxElement, x);
        }

        // If all numbers are negative, return the largest element
        return (sum > 0) ? sum : maxElement;
    }
}

