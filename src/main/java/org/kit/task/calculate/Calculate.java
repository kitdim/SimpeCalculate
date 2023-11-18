package org.kit.task.calculate;

import java.util.List;
import java.util.Map;

public class Calculate {
    public static Func<Integer, String> func = (result, number, operand) -> {
        result = switch (operand) {
            case "+" -> result + number;
            case "-" -> result - number;
            case "*" -> result * number;
            default -> throw new IllegalStateException("Unexpected value: " + operand);
        };
        return result;
    };

    public static void getResult(Map<String, List<String>> data) {
        List<String> temp1 = data.get("numbers");
        List<String> temp2 = data.get("operations");
        int result = 0;
        int index = 0;
        for (int i = 0; i < temp1.size(); i++) {
            int number = Integer.parseInt(temp1.get(i));
            String operation = temp2.get(index);
            result = func.apply(result, number, operation);
            if (i != 0) {
                index++;
            }
        }
        System.out.println("Result: " + result);
    }
}
