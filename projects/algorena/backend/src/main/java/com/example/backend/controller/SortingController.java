package com.example.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.OprationalModel;
import com.example.backend.service.SortingDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/sorting")
public class SortingController {

        @PostMapping("/calculate1")
        public ResponseEntity<?> computeSorting(@RequestBody OprationalModel<?> oprationalModel) {
                String type = oprationalModel.getType();
                String firstSorting = oprationalModel.getFirstSearch();
                String secSorting = oprationalModel.getSecondSearch();
                List<?> inputs = oprationalModel.getInput();

                if (type == null || firstSorting == null || secSorting == null || inputs == null) {
                        return ResponseEntity.badRequest().body("Missing required fields in the request.");
                }

                if ("Integer".equalsIgnoreCase(type)) {
                        try {
                                List<Integer> list = inputs.stream()
                                                .map(val -> Integer.parseInt(val.toString()))
                                                .collect(Collectors.toList());

                                SortingDispatcher<Integer> dispatcher = new SortingDispatcher<>();
                                String firstSorted = dispatcher.sortCompute(firstSorting, new ArrayList<>(list));
                                String secSorted = dispatcher.sortCompute(secSorting, new ArrayList<>(list));

                                return ResponseEntity.ok(
                                                Map.of(
                                                                "firstSorted", firstSorted,
                                                                "secondSorted", secSorted));
                        } catch (NumberFormatException e) {
                                return ResponseEntity.badRequest().body("Invalid integer input: " + e.getMessage());
                        }
                }

                if ("Character".equalsIgnoreCase(type)) {
                        try {
                                List<Character> list = inputs.stream()
                                                .map(val -> {
                                                        String s = val.toString();
                                                        if (s.isEmpty()) {
                                                                throw new IllegalArgumentException(
                                                                                "Empty string cannot be converted to Character.");
                                                        }
                                                        return s.charAt(0);
                                                })
                                                .collect(Collectors.toList());

                                SortingDispatcher<Character> dispatcher = new SortingDispatcher<>();
                                String firstSorted = dispatcher.sortCompute(firstSorting, new ArrayList<>(list));
                                String secSorted = dispatcher.sortCompute(secSorting, new ArrayList<>(list));

                                return ResponseEntity.ok(
                                                Map.of(
                                                                "firstSorted", firstSorted,
                                                                "secondSorted", secSorted));
                        } catch (Exception e) {
                                return ResponseEntity.badRequest().body("Invalid character input: " + e.getMessage());
                        }
                }

                return ResponseEntity.badRequest().body("Unsupported type: " + type);
        }

        @PostMapping("/steps")
        public String postMethodName(@RequestBody String entity) {
                return entity;
        }

}
