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
    private NotificationType notificationType;

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

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
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
