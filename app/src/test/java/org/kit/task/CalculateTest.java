package org.kit.task;

import io.javalin.Javalin;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kit.task.parser.Parser;
import org.kit.task.service.ResultMachine;
import org.kit.task.util.Sanitiser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateTest {
    private static List<String> data;
    private static Javalin app;
    private static String baseUrl;

    @BeforeEach
    void init() {
        data = List.of("1+2-3", "-3+2", "2*(3)", "2-(3)");
        app = Main.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }
    @AfterAll
    public static void afterAll() {
        app.stop();
    }

    @Test
    void wasGetResult() {
        var item = Parser.evaluateExpression(data.get(0));
        var actual = ResultMachine.calc(item);
        assertThat(actual).isEqualTo(0);

        item = Parser.evaluateExpression(data.get(1));
        actual = ResultMachine.calc(item);
        assertThat(actual).isEqualTo(-1);

        item = Parser.evaluateExpression(data.get(2));
        actual = ResultMachine.calc(item);
        assertThat(actual).isEqualTo(6);

        item = Parser.evaluateExpression(data.get(3));
        actual = ResultMachine.calc(item);
        assertThat(actual).isEqualTo(-1);
    }
    @Test
    void isCorrectBrackets() {
        var actual = Sanitiser.checkForBrackets("(5+5)");
        assertTrue(actual);

        actual = Sanitiser.checkForBrackets("(5+5");
        assertFalse(actual);
    }
    @Test
    void isContainsLetters() {
        var actual = Sanitiser.checkForLetters("5+5");
        assertTrue(actual);

        actual = Sanitiser.checkForLetters("5+j");
        assertFalse(actual);
    }
    @Test
    void isRunWebApp() {
        HttpResponse<String> response = Unirest.get(baseUrl).asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }
}
