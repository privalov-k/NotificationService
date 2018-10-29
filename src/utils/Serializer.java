package utils;

import service.ExceptionHandler;
import java.io.*;

/**
 * Класс для сереализации/десереализации объектов/массивов байт
 */
public class Serializer<T> {

    public T deserialize(byte[] data) {
        try (ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return (T) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.handleAndExit(e);
        }
        return null;
    }

    public byte[] serialize(T object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            ExceptionHandler.handleAndExit(e);
        }
        return null;
    }
}
