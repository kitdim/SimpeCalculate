package org.kit.task.parser;

import org.kit.task.utils.Utils;

import java.util.*;

public class Parser {
    public static Map<String, List<String>> parse(String input) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> operations = new ArrayList<>();
        List<String> numbers = new ArrayList<>(Arrays.stream(input.split("\\D")).toList());
        for (var i = 0; i < input.length(); i++) {
            Character item = input.charAt(i);
            if (Utils.OPERATIONS.contains(item)) {
                operations.add(item.toString());
            }
        }
        map.put("operations", operations);
        map.put("numbers", numbers);
        return map;
    }
}
