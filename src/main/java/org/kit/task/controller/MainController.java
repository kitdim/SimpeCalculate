package org.kit.task.controller;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.kit.task.dto.BuildCalculatePage;
import org.kit.task.dto.CalculatePage;
import org.kit.task.parser.Parser;
import org.kit.task.service.ResultMachine;
import org.kit.task.util.Sanitiser;

import java.util.Collections;

public class MainController {
    public static void index(Context ctx) {
        ctx.render("index.jte");
    }
    public static void show(Context ctx) {
        try {
            var input = ctx.formParamAsClass("input", String.class)
                    .check(Sanitiser::checkForBrackets, "Неверно указаны скобки")
                    .check(Sanitiser::checkForLetters, "Неверно составлено уравнение")
                    .get();
            var expression = Parser.evaluateExpression(input);
            var result = ResultMachine.calc(expression);
            var page = new CalculatePage(result);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        } catch (ValidationException errors) {
            var input = ctx.formParam("input");
            var pageBuild = new BuildCalculatePage(input, errors.getErrors());
            ctx.render("index.jte", Collections.singletonMap("pageBuild", pageBuild));
        }
    }
    public static void error(Context ctx) {
        ctx.render("404.jte");
    }
}
