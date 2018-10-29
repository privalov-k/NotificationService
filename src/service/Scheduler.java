package service;

import model.Command;
import model.NotificationType;
import utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Планировщик, отправляющий команду, в указанное время
 */
public class Scheduler {

    public static void scheduleCommand(Command command) {
        Logger.log("Команда с id = " + command.getId() + " будет обработана " + command.getTime());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (command.getNotificationType() == NotificationType.EMAIL) {
                    //отправка email, нужно указать свою почту и пароль
                    EmailSender emailSender = new EmailSender("ваша почта","пароль");
                    emailSender.send("Напоминание", command.getMessage(), emailSender.getUsername(), command.getDestination());
                } else if (command.getNotificationType() == NotificationType.HTTP) {
                    //код отправки HTTP
                }
            }
        }, command.getTime());
    }
}
