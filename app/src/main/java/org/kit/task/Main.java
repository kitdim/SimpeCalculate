package org.kit.task;

import io.javalin.Javalin;
import org.kit.task.controller.MainController;
import org.kit.task.util.NamedRoutes;

public class Main {
    private static final String PORT_DEFAULT = "7070";
    public static void main(String[] args) {
        var app = getApp();
        var port = getPort();
        app.start(port);
    }
    public static Javalin getApp() {
        var app = Javalin.create(config -> config.plugins.enableDevLogging());
        app.get(NamedRoutes.main(), MainController::index);
        app.post(NamedRoutes.main(), MainController::show);
        app.error(404, MainController::error);
        return app;
    }
    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", PORT_DEFAULT);
        return Integer.parseInt(port);
    }
}
