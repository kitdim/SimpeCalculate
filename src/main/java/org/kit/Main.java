package org.kit;

import org.kit.calculate.Calculate;
import org.kit.parser.Parser;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in)
                .next()
                .trim();
        Map<String, List<String>> data = Parser.parse(input);
        Calculate.getResult(data);
    }
}