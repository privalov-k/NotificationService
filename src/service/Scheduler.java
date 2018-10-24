package service;

import model.Command;
import model.NotificationChannel;
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
                if (command.getNotificationChannel() == NotificationChannel.EMAIL) {
                    //код отправки на EMAIL
                    System.out.println("Cообщение " + command.toString() + " отправлено на email: " + command.getDestination());
                } else if (command.getNotificationChannel() == NotificationChannel.HTTP) {
                    //код отправки HTTP
                    System.out.println("Cообщение " + command.toString() + " отправлено на http:// " + command.getDestination());
                }
            }
        }, command.getTime());
    }
}
