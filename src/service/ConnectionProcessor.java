package service;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Процессор подключений
 */
public class ConnectionProcessor {

    public static void process(AsynchronousServerSocketChannel server) {
        //Бесконечная обработка соединений
        while (true) {
            Future<AsynchronousSocketChannel> future = server.accept();
            try {
                AsynchronousSocketChannel channel = future.get();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                channel.read(buffer).get();
                //как чтение завершится, обрабатываем данные
                CommandProcessor.process(buffer);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
