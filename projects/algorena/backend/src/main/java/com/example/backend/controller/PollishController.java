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
    public int computePolishEvaluate(@RequestBody OprationalModel oprationalModel) {
        String expression = oprationalModel.getType();
        String firstNotation = oprationalModel.getFirstSearch();
        PollishAlgorithims pollishAlgorithims = new PollishAlgorithims();
        System.out.println(firstNotation);
        System.out.println(expression);
        if (firstNotation.equals("Prefix Notation")) {
            expression = pollishAlgorithims.prefix(expression, "Infix Notation");
            System.out.println(expression);
        } else if (expression.equals("Postfix Notation")) {
            expression = pollishAlgorithims.postfix(expression, "Infix Notation");

        }
        int total = 0;
        int lastTerm = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == expression.length() - 1) { // <-- FIX
                if (op == '+') {
                    total += lastTerm;
                    lastTerm = num;
                } else if (op == '-') {
                    total += lastTerm;
                    lastTerm = -num;
                } else if (op == '*') {
                    lastTerm *= num;
                } else if (op == '/') {
                    lastTerm /= num;
                } else if (op == '%') {
                    lastTerm %= num;
                }

                op = ch;
                num = 0;
            }
        }

        total += lastTerm;
        return total;

    }

}
