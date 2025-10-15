package com.example.backend.model;

import java.util.List;

public class OprationalModel<T> {
    private String type;
    private String firstSearch;
    private int searchElement;
    private String secondSearch;
    private List<T> input;

    public OprationalModel() {
    }

    public OprationalModel(String type, String firstSearch, String secondSearch, List<T> input, int searchElement) {
        this.type = type;
        this.firstSearch = firstSearch;
        this.secondSearch = secondSearch;
        this.input = input;
        this.searchElement = searchElement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstSearch() {
        return firstSearch;
    }

    public void setFirstSearch(String firstSearch) {
        this.firstSearch = firstSearch;
    }

    public String getSecondSearch() {
        return secondSearch;
    }

    public void setSecondSearch(String secondSearch) {
        this.secondSearch = secondSearch;
    }

    public int getSearchElement() {
        return searchElement;
    }

    public void setSearchElement(int searchElement) {
        this.searchElement = searchElement;
    }

    public List<T> getInput() {
        return input;
    }

    public void setInput(List<T> input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "SortingModel{" +
                "type='" + type + '\'' +
                ", firstSearch='" + firstSearch + '\'' +
                ", secondSearch='" + secondSearch + '\'' +
                ", input=" + input +
                '}';
    }
}
