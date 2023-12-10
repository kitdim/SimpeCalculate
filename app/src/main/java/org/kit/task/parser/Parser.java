package org.kit.task.parser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static List<String> evaluateExpression(String input) {
        List<String> result = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        Pattern operatorPattern = Pattern.compile("([\\d+\\-*/]+)");
        Pattern delimPattern = Pattern.compile("([\\d+\\-*/()]+)");

        if (input.toCharArray()[0] == '-') {
            input = "0" + input;
        }
        StringTokenizer tokenizer = new StringTokenizer(input, "+-*/()", true);

        String currentToken;
        while (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();

            Matcher matcher = delimPattern.matcher(currentToken);

            if (matcher.find()) {
                switch (currentToken) {
                    case "(" -> deque.push(currentToken);
                    case ")" -> {
                        while (!deque.peek().equals("(")) {
                            result.add(deque.pop());
                        }
                        deque.pop();
                        if (!deque.isEmpty()) {
                            result.add(deque.pop());
                        }
                    }
                    default -> {
                        while (!deque.isEmpty() && (getPriority(currentToken) <= getPriority(deque.peek()))) {
                            result.add(deque.pop());
                        }
                        deque.push(currentToken);
                    }
                }
            } else {
                result.add(currentToken);
            }
        }
        while (!deque.isEmpty()) {
            if (operatorPattern.matcher(deque.peek()).find()) {
                result.add(deque.pop());
            }
        }
        return result;
    }

    private static byte getPriority(String token) {
        switch (token) {
            case "(" -> {
                return 1;
            }
            case "+", "-" -> {
                return 2;
            }
            case "*", "/" -> {
                return 3;
            }
            default -> {
                return 4;
            }
        }
    }
}
