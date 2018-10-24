package test;

import model.Command;
import model.NotificationChannel;
import utils.Serializer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestClient {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8081);
        Future future = client.connect(hostAddress);
        future.get();
        System.out.println("TestClient is started: " + client.isOpen());
        System.out.println("Sending messages to server: ");
        Serializer<Command> serializer = new Serializer<>();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);

        //сохдание и отправка комманды
        Command command = new Command();
        command.setMessage("поход к врачу");
        command.setId(UUID.randomUUID().toString());
        command.setDestination("123@mail.ru");
        command.setTime(calendar.getTime());
        command.setNotificationChannel(NotificationChannel.EMAIL);
        client.write(ByteBuffer.wrap(serializer.serialize(command))).get();
        client.close();
    }
}
