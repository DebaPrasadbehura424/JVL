package com.example.backend.model;
import java.util.List;

public class SortingModel<T> {
    private String type;
    private String firstSearch;
    private String secondSearch;
    private List<T> input;

    public SortingModel() {
    }

    public SortingModel(String type, String firstSearch, String secondSearch, List<T> input) {
        this.type = type;
        this.firstSearch = firstSearch;
        this.secondSearch = secondSearch;
        this.input = input;
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
