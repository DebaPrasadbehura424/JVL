package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.OprationalModel;
import com.example.backend.service.SearchingDispatcher;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/searching")
public class SearchingController {

    @PostMapping("/calculate1")
    public <T> ResponseEntity<?> computeSearching(@RequestBody OprationalModel<?> oprationalModel) {
        String type = oprationalModel.getType();
        String firstSearching = oprationalModel.getFirstSearch();
        String secSearching = oprationalModel.getSecondSearch();
        List<?> inputs = oprationalModel.getInput();
        Object elemObj = oprationalModel.getSearchElement();

        if (type == null || firstSearching == null || secSearching == null || inputs == null) {
            return ResponseEntity.badRequest().body("Missing required fields in the request.");
        }

        if ("Integer".equalsIgnoreCase(type)) {
            try {
                List<Integer> list = inputs.stream()
                        .map(val -> Integer.parseInt(val.toString()))
                        .collect(Collectors.toList());

                int elem = Integer.parseInt(elemObj.toString());

                SearchingDispatcher<Integer> dispatcher = new SearchingDispatcher<>();
                String firstSeachResult = dispatcher.searchCompute(firstSearching, new ArrayList<>(list), elem);
                String secSearchResult = dispatcher.searchCompute(secSearching, new ArrayList<>(list), elem);

                return ResponseEntity.ok(
                        Map.of(
                                "firstSeachResult", firstSeachResult,
                                "secondSearchResult", secSearchResult));
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body("Invalid integer input: " + e.getMessage());
            }
        } else if ("Character".equalsIgnoreCase(type)) {
            try {
                List<Character> list = inputs.stream()
                        .map(val -> {
                            String s = val.toString();
                            if (s.isEmpty()) {
                                throw new IllegalArgumentException("Empty string cannot be converted to Character.");
                            }
                            return s.charAt(0);
                        })
                        .collect(Collectors.toList());

                String elemStr = elemObj.toString();
                if (elemStr.isEmpty()) {
                    return ResponseEntity.badRequest().body("Search element cannot be empty for Character type.");
                }
                Character elem = elemStr.charAt(0);

                SearchingDispatcher<Character> dispatcher = new SearchingDispatcher<>();
                String firstSeachResult = dispatcher.searchCompute(firstSearching, new ArrayList<>(list), elem);
                String secSearchResult = dispatcher.searchCompute(secSearching, new ArrayList<>(list), elem);

                return ResponseEntity.ok(
                        Map.of(
                                "firstSeachResult", firstSeachResult,
                                "secondSearchResult", secSearchResult));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Invalid character input: " + e.getMessage());
            }
        }

        return ResponseEntity.badRequest().body("Unsupported type: " + type);
    }

}
