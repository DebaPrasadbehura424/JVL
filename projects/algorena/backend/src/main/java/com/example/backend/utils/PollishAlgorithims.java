package com.example.backend.utils;

import java.util.Stack;

public class PollishAlgorithims {
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public boolean isOprater(char ch) {
        return ch == '*' || ch == '-' || ch == '%' || ch == '/' || ch == '^' || ch == '+';
    }

    public String collectExpression(String expression, String firstnotation, String secnotation) {
        if (firstnotation.equals("Infix Notation")) {
            return infix(expression, secnotation);
        } else if (firstnotation.equals("Prefix Notation")) {
            return prefix(expression, secnotation);
        }
        return postfix(expression, secnotation);
    }

    public String infix(String expression, String secnotation) {

        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        if (secnotation.equals("Prefix Notation")) {
            for (int i = expression.length() - 1; i >= 0; i--) {
                char ch = expression.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                } else if (ch == ')') {
                    st.push(ch);
                } else if (ch == '(') {
                    while (!st.isEmpty() && st.peek() != ')') {
                        result.append(st.pop());
                    }
                    st.pop();
                } else if (isOprater(ch)) {
                    while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                        result.append(st.pop());
                    }
                    st.push(ch);
                }
            }
            while (!st.isEmpty()) {
                result.append(st.pop());
            }

        } else {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                } else if (ch == '(') {
                    st.push(ch);
                } else if (ch == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        result.append(st.pop());
                    }
                    st.pop();
                } else if (isOprater(ch)) {
                    while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                        result.append(st.pop());
                    }
                    st.push(ch);
                }
            }
            while (!st.isEmpty()) {
                result.append(st.pop());
            }

        }
        return result.toString();

    }

    public String postfix(String expression, String secnotation) {
        Stack<String> st = new Stack<>();
        if (secnotation.equals("")) {

        } else {

        }

        return "";
    }

    public String prefix(String expression, String secnotation) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                if (stack.size() < 2) {
                    return "Invalid Expression";
                }
                String op1 = stack.pop();
                String op2 = stack.pop();

                if (secnotation.equals("Infix Notation")) {
                    String result = op1 + ch + op2;
                    stack.push(result);
                } else {
                    String result = op1 + op2 + ch;
                    stack.push(result);
                }

            }

        }
        return stack.peek();

    }

}
