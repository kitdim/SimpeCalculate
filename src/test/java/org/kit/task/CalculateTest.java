package org.kit.task;

import org.junit.jupiter.api.Test;
import org.kit.task.parser.Parser;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    void wasGetResult() {
        var actual = Parser.evaluateExpression("1+2-3");
        assertThat(actual).isEqualTo(0);
        actual = Parser.evaluateExpression("-3+2");
        assertThat(actual).isEqualTo(-1);
        actual = Parser.evaluateExpression("2*(-3)");
        assertThat(actual).isEqualTo(-6);
        actual = Parser.evaluateExpression("2-(-3)");
        assertThat(actual).isEqualTo(5);
    }
}
