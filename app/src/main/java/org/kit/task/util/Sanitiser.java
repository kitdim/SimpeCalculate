package org.kit.task.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sanitiser {
    public static boolean checkForBrackets(String expression) {
        int bracketsCount = 0;
        for (int i = 0; i < expression.toCharArray().length; i++) {
            if (expression.toCharArray()[i] == '(') {
                bracketsCount++;
            }
            if (expression.toCharArray()[i] == ')') {
                bracketsCount--;
                if (bracketsCount < 0) {
                    return false;
                }
            }
        }
        return bracketsCount == 0;
    }

    public static boolean checkForLetters(String expression) {
        Pattern pattern = Pattern.compile("([^\\d+\\-*/()]+)");
        Matcher matcher = pattern.matcher(expression);

        return !matcher.find();
    }
}
