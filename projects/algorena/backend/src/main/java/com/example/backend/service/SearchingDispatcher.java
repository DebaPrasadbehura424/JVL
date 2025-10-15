package com.example.backend.service;

import java.util.List;

import com.example.backend.utils.SearchAlgorithims;

public class SearchingDispatcher<T extends Comparable<T>> {
    public String searchCompute(String algorithm, List<T> data, T elem) {
        String ans = "";
        switch (algorithm.toLowerCase()) {
            case "binarysearch":
                ans = SearchAlgorithims.binarySearch(data, elem);
                break;
            case "linearsearch":
                ans = SearchAlgorithims.linearSearch(data, elem);
                break;

            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
        return ans;
    }

}
