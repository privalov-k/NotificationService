package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Входящие команды поступающие от клиентов
 */
public class Command implements Serializable {

    private static final long serialVersionUID = -3242800231118351740L;

    /**
     * Уникальный идентификатор сообщения (формат UUID)
     */
    private String id;

    /**
     * Текст сообщения
     */
    private String message;

    /**
     * Канал куда необходимо отправить напоминание
     */
    private NotificationChannel notificationChannel;

    /**
     * Время когда необходимо отправить напоминание
     */
    private Date time;

    /**
     * Адресат
     */
    private String destination;

    public Command() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationChannel getNotificationChannel() {
        return notificationChannel;
    }

    public void setNotificationChannel(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
