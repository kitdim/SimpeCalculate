package org.kit.task.service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ResultMachine {
    public static Double calc(List<String> postfix) {
        Deque<Double> deque = new ArrayDeque<>();
        for (String x : postfix) {
            switch (x) {
                case "+" -> deque.push(deque.pop() + deque.pop());
                case "-" -> deque.push(-deque.pop() + deque.pop());
                case "*" -> deque.push(deque.pop() * deque.pop());
                case "/" -> deque.push(1 / deque.pop() * deque.pop());
                default -> deque.push(Double.valueOf(x));
            }
        }
        return deque.pop();
    }
}
