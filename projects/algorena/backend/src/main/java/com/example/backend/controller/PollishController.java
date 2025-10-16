package com.example.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.OprationalModel;
import com.example.backend.utils.PollishAlgorithims;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/polish")
public class PollishController {

    @PostMapping("/calculate1/convert")
    public String computePolishConvert(@RequestBody OprationalModel oprationalModel) {
        String expression = oprationalModel.getType();
        String firstNotation = oprationalModel.getFirstSearch();
        String secondNotation = oprationalModel.getSecondSearch();

        PollishAlgorithims pollishAlgorithims = new PollishAlgorithims();
        return pollishAlgorithims.collectExpression(expression, firstNotation, secondNotation);
    }

    @PostMapping("/calculate1/evaluate")
    public String computePolishEvaluate(@RequestBody OprationalModel oprationalModel) {
        String expression = oprationalModel.getType();
        String firstNotation = oprationalModel.getFirstSearch();
        String secondNotation = oprationalModel.getSecondSearch();
        if (expression.equals("")) {// if infix is there

        } else if (expression.equals("")) {// if postfix convert it

        } else {// if postfix convert to infix

        }
        return "";

    }

}
