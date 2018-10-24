package service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import static utils.Logger.log;

/**
 * Сервер, слушающий заданный порт
 */
public class Server {

    public static void run() {
        try (AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()) {
            server.bind(new InetSocketAddress("localhost", 8081));
            log("Сервер запущен на порту = 8081");
            log("Ожидание подключений...");
            ConnectionProcessor.process(server);
        } catch (IOException ex) {
            ExceptionHandler.handle(ex);
        }
    }
}
