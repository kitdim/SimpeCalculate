package org.kit.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kit.task.parser.Parser;
import org.kit.task.service.Calculate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    private static List<String> data;

    @BeforeEach
    void init() {
        data = List.of("1+2-3", "-3+2", "2*(3)", "2-(3)");
    }

    @Test
    void wasGetResult() {
        var item = Parser.evaluateExpression(data.get(0));
        var actual = Calculate.calc(item);
        assertThat(actual).isEqualTo(0);
        item = Parser.evaluateExpression(data.get(1));
        actual = Calculate.calc(item);
        assertThat(actual).isEqualTo(-1);
        item = Parser.evaluateExpression(data.get(2));
        actual = Calculate.calc(item);
        assertThat(actual).isEqualTo(6);
        item = Parser.evaluateExpression(data.get(3));
        actual = Calculate.calc(item);
        assertThat(actual).isEqualTo(-1);
    }
}
