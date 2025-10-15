package com.example.backend.utils;

import java.util.*;

public class SearchAlgorithims {

    public static <T extends Comparable<T>> String binarySearch(List<T> data, T elem) {
        Collections.sort(data);
        int steps = 0;
        int low = 0;
        int high = data.size() - 1;
        int mid;
        int findIndexElem = -1;

        boolean bestCase = false;
        boolean worstCase = false;

        long startTime = System.nanoTime();

        // Step 2: Binary Search Loop
        while (low <= high) {
            steps++;
            mid = (low + high) / 2;

            T midVal = data.get(mid);
            int compare = midVal.compareTo(elem);

            if (compare == 0) {
                findIndexElem = mid;

                // best case = first check hits the target
                if (steps == 1)
                    bestCase = true;
                // worst case = last possible element or not found
                if (mid == 0 || mid == data.size() - 1)
                    worstCase = true;
                break;
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        // Step 3: Determine Case Type
        String actualCase;
        if (bestCase)
            actualCase = "Best Case (Element found at first comparison)";
        else if (findIndexElem == -1 || worstCase)
            actualCase = "Worst Case (Element found at last comparison or not found)";
        else
            actualCase = "Average Case (Element found in middle iterations)";

        // Step 4: Prepare Output
        StringBuilder result = new StringBuilder();
        result.append("🔹 Binary Search Analysis\n");
        result.append("------------------------------------\n");
        result.append("Best Case Time Complexity: O(1)\n");
        result.append("Average Case Time Complexity: O(log n)\n");
        result.append("Worst Case Time Complexity: O(log n)\n");
        result.append("Space Complexity: O(1)\n\n");

        result.append("Sorted Data: ").append(data).append("\n");
        result.append("Actual Steps (Comparisons): ").append(steps).append("\n");
        result.append("Actual Case Detected: ").append(actualCase).append("\n");
        result.append(String.format("Execution Time: %.3f ms\n", durationMillis));

        if (findIndexElem != -1) {
            result.append("Element Found: ").append(elem)
                    .append(" at Index: ").append(findIndexElem).append("\n");
        } else {
            result.append("Element Not Found in the List\n");
        }

        return result.toString();
    }

    public static <E extends Comparable<E>, T> String linearSearch(List<T> data, T elem) {
        int steps = 0;
        int findIndexElem = -1;
        boolean bestCase = false;
        boolean worstCase = false;

        long startTime = System.nanoTime();

        for (int i = 0; i < data.size(); i++) {
            steps++;
            if (data.get(i).equals(elem)) {
                findIndexElem = i;
                if (i == 0)
                    bestCase = true;
                else if (i == data.size() - 1)
                    worstCase = true;
                break;
            }
        }

        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        String actualCase;
        if (bestCase)
            actualCase = "Best Case (Element found at first position)";
        else if (worstCase)
            actualCase = "Worst Case (Element found at last position or not found)";
        else if (findIndexElem == -1)
            actualCase = "Worst Case (Element not found)";
        else
            actualCase = "Average Case (Element found in middle)";

        StringBuilder result = new StringBuilder();
        result.append("Best Case Time Complexity: O(1)\n");
        result.append("Average Case Time Complexity: O(n/2) ≈ O(n)\n");
        result.append("Worst Case Time Complexity: O(n)\n");
        result.append("Space Complexity: O(1)\n");
        result.append("Actual Steps (Comparisons): ").append(steps).append("\n");
        result.append("Actual Case Detected: ").append(actualCase).append("\n");
        result.append(String.format("Execution Time: %.3f ms\n", durationMillis));

        if (findIndexElem != -1) {
            result.append("Element Found: ").append(elem)
                    .append(" at Index: ").append(findIndexElem).append("\n");
        } else {
            result.append("Element Not Found in the List\n");
        }

        return result.toString();
    }

}
