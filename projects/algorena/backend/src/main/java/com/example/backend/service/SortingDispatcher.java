package com.example.backend.service;

import java.util.List;

import com.example.backend.utils.SortingAlgorithims;

public class SortingDispatcher<T extends Comparable<T>> {
    public String sortCompute(String algorithm, List<T> data) {
        String ans = "";
        switch (algorithm.toLowerCase()) {
            case "bubblesort":
                ans = SortingAlgorithims.bubbleSort(data);
                break;
            case "insertionsort":
                ans = SortingAlgorithims.insertionSort(data);
                break;
            case "selectionsort":
                ans = SortingAlgorithims.selectionSort(data);
                break;
            case "quicksort":
                ans = SortingAlgorithims.quickSort(data, 0, data.size() - 1);
                break;
            case "mergesort":
                ans = SortingAlgorithims.mergesort(data, 0, data.size() - 1);
                break;
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
        return ans;
    }
}
