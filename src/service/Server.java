package service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import static utils.Logger.log;

/**
 * Сервер, слушающий заданный порт
 */
public class Server {

    private static final int PORT = 8080;

    public static void run() {
        try (AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()) {
            server.bind(new InetSocketAddress("localhost", PORT));
            log("Сервер запущен на порту = " + PORT);
            log("Ожидание подключений...");
            ConnectionProcessor.process(server);
        } catch (IOException ex) {
            ExceptionHandler.handleAndExit(ex);
        }
    }
}
