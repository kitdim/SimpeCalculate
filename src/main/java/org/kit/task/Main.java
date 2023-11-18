package org.kit.task;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
//        String input = new Scanner(System.in)
//                .next()
//                .trim();
//        Map<String, List<String>> data = Parser.parse(input);
//        Calculate.getResult(data);
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/", ctx -> ctx.render("index.jte"));
        app.start(7070);
    }
}