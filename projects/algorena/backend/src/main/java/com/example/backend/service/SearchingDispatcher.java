package com.example.backend.service;

import java.util.List;

import com.example.backend.utils.SearchingAlgorithims;

public class SearchingDispatcher<T extends Comparable<T>> {
    public String searchCompuet(String algorithm, List<T> data) {
        String ans = "";
        switch (algorithm.toLowerCase()) {
            case "binarysearch":

                ans = SearchingAlgorithims.binarySearch(data);
                break;
            case "linearsearch":
                ans = SearchingAlgorithims.linearSearch(data);
                break;

            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
        return ans;
    }

}
