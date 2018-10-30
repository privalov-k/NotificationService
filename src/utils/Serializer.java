package utils;

import java.io.*;

/**
 * Класс для сереализации/десереализации объектов/массивов байт
 */
public class Serializer<T> {

    public T deserialize(byte[] data) {
        try (ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return (T) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.log("Ошибка во время десереализации");
        }
        return null;
    }

    public byte[] serialize(T object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
           Logger.log("Ошибка во время сереализации");
        }
        return null;
    }
}
