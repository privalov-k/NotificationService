package service;

import model.Command;
import utils.Logger;
import utils.Serializer;

import java.nio.ByteBuffer;

/**
 * Процессор команд
 */
public class CommandProcessor {

    private static final Serializer<Command> SERIALIZER = new Serializer<>();

    public static void process(ByteBuffer buffer) {
        //десериализуем данные в Объект (Команду)
        Command command = SERIALIZER.deserialize(buffer.array());
        Logger.log("Передаю команду с id = " + command.getId() + " на обработку");
        //передаем команду планировщику
        Scheduler.scheduleCommand(command);
    }
}
