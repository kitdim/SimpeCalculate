package org.kit.task;

import io.javalin.Javalin;
import org.kit.task.controller.MainController;
import org.kit.task.util.NamedRoutes;

public class Main {
    private static final int PORT = 7070;
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        var app = Javalin.create(config -> config.plugins.enableDevLogging());
        app.get(NamedRoutes.main(), MainController::index);
        app.post(NamedRoutes.main(), MainController::show);
        app.error(404, MainController::error);
        app.start(PORT);
    }
}