package com.example.backend.utils;

import java.util.List;

public class SortingAlgorithims<E> {

    public static <E extends Comparable<E>> String bubbleSort(List<E> data) {
        int n = data.size();
        boolean swapped;
        int step = 0;
        boolean bestCase = true;
        boolean worstCase = true;
        int passes = 0;

        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j).compareTo(data.get(j + 1)) > 0) {
                    E temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    swapped = true;
                }
                step++;
            }
            if (swapped && i == 0) {
                bestCase = false;
            }
            if (!swapped) {
                worstCase = false;
                break;
            }
        }
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        String actualCase;
        if (bestCase) {
            actualCase = "Best Case (Already Sorted)";
        } else if (worstCase && passes == n - 1) {
            actualCase = "Worst Case (Likely Reverse Sorted)";
        } else {
            actualCase = "Average Case (Partially Sorted)";
        }

        StringBuilder result = new StringBuilder();
        result.append("Best Case Time Complexity: O(n)\n");
        result.append("Average Case Time Complexity: O(n^2)\n");
        result.append("Worst Case Time Complexity: O(n^2)\n");
        result.append("Space Complexity: O(1)\n");
        result.append("Actual Steps (Comparisons): ").append(step).append("\n");
        result.append("Number of Passes: ").append(passes).append("\n");
        result.append("Actual Case Detected: ").append(actualCase).append("\n");
        result.append(String.format("Execution Time: %.3f ms\n", durationMillis));

        result.append("Sorted Elements: ");
        for (int i = 0; i < data.size(); i++) {
            result.append(data.get(i));
            if (i < data.size() - 1) {
                result.append(",");
            }
        }
        result.append("\n");

        return result.toString();

    }

    public static <E extends Comparable<E>> String insertionSort(List<E> data) {
        int n = data.size();
        int step = 0;
        int innserStep = 0;
        int passes = 0;
        boolean bestCase = true;
        boolean worstCase = true;

        long startTime = System.nanoTime();

        for (int i = 1; i < n; i++) {
            passes++;
            E key = data.get(i);
            int j = i - 1;
            boolean moved = false;

            while (j >= 0 && data.get(j).compareTo(key) > 0) {
                data.set(j + 1, data.get(j));
                j--;
                innserStep++;
                moved = true;
            }

            if (!moved && i == 1) {
                bestCase = true;
            } else {
                bestCase = false;
            }

            if (!moved) {
                worstCase = false;
            }

            data.set(j + 1, key);
            step++;
        }
        step = step + innserStep;

        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        String actualCase;
        if (bestCase) {
            actualCase = "Best Case (Already Sorted)";
        } else if (worstCase && passes == n - 1) {
            actualCase = "Worst Case (Likely Reverse Sorted)";
        } else {
            actualCase = "Average Case (Partially Sorted)";
        }

        StringBuilder result = new StringBuilder();
        result.append("Best Case Time Complexity: O(n)\n");
        result.append("Average Case Time Complexity: O(n^2)\n");
        result.append("Worst Case Time Complexity: O(n^2)\n");
        result.append("Space Complexity: O(1)\n");
        result.append("Actual Steps (Comparisons/Shifts): ").append(step).append("\n");
        result.append("Number of Passes: ").append(passes).append("\n");
        result.append("Actual Case Detected: ").append(actualCase).append("\n");
        result.append(String.format("Execution Time: %.3f ms\n", durationMillis));

        result.append("Sorted Elements: ");
        for (int i = 0; i < data.size(); i++) {
            result.append(data.get(i));
            if (i < data.size() - 1) {
                result.append(",");
            }
        }
        result.append("\n");

        return result.toString();
    }

    public static <E extends Comparable<E>> String selectionSort(List<E> data) {
        int n = data.size();
        int steps = 0;
        int passes = 0;
        boolean bestCase = true;
        boolean worstCase = true;

        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            passes++;
            int minIndex = i;
            boolean swapped = false;

            for (int j = i + 1; j < n; j++) {
                steps++;
                E val1 = data.get(minIndex);
                E val2 = data.get(j);
                if (val1.compareTo(val2) > 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                E temp = data.get(i);
                data.set(i, data.get(minIndex));
                data.set(minIndex, temp);
                swapped = true;
            }

            if (swapped && i == 0)
                bestCase = false;
            if (!swapped)
                worstCase = false;
        }

        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        String actualCase;
        if (bestCase) {
            actualCase = "Best Case (Already Sorted)";
        } else if (worstCase && passes == n - 1) {
            actualCase = "Worst Case (Likely Reverse Sorted)";
        } else {
            actualCase = "Average Case (Partially Sorted)";
        }

        StringBuilder result = new StringBuilder();
        result.append("Best Case Time Complexity: O(n^2)\n");
        result.append("Average Case Time Complexity: O(n^2)\n");
        result.append("Worst Case Time Complexity: O(n^2)\n");
        result.append("Space Complexity: O(1)\n");
        result.append("Actual Steps (Comparisons): ").append(steps).append("\n");
        result.append("Number of Passes: ").append(passes).append("\n");
        result.append("Actual Case Detected: ").append(actualCase).append("\n");
        result.append(String.format("Execution Time: %.3f ms\n", durationMillis));

        result.append("Sorted Elements: ");
        for (int i = 0; i < data.size(); i++) {
            result.append(data.get(i));
            if (i < data.size() - 1)
                result.append(",");
        }
        result.append("\n");

        return result.toString();
    }

    public static <E extends Comparable<E>> String quickSort(List<E> data, int i, int j) {
        return "";
    }

    public static <E extends Comparable<E>> String mergesort(List<E> data, int i, int j) {
        return "";

    }
}
