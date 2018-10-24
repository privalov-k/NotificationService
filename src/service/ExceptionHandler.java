package service;

import static utils.Logger.log;

/**
 * Обработчик ошибок
 */
public class ExceptionHandler {

    public static void handle(Exception ex) {
        log("Ошибка: " + ex.getMessage());
        System.exit(1);
    }
}
