package service;

import utils.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;

/**
 * Сервер, слушающий заданный порт
 */
public class Server {

    private static final int PORT = 8080;

    public static void run() {
        try (AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()) {
            server.bind(new InetSocketAddress("localhost", PORT));
            Logger.log("Сервер запущен на порту = " + PORT);
            Logger.log("Ожидание подключений...");
            ConnectionProcessor.process(server);
        } catch (AlreadyBoundException e){
            Logger.log("Сокет уже занят");
        }catch (UnsupportedAddressTypeException e){
            Logger.log("Тип адреса не поддерживается");
        }  catch (ClosedChannelException e){
            Logger.log("Канал уже закрыт");
        } catch (IOException e){
            Logger.log("Возникли i/o ошибки");
        }
    }
}
