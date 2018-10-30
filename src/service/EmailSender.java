package service;

import model.Account;
import utils.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Класс для отправки сообщения на почту
 */
public class EmailSender {

    private static final String PORT = "465";
    private Properties props;
    private Account account;
    private static final String MAIL_SMTP_HOST = "mail.smtp.host";
    private static final String SMTP_GMAIL_COM = "smtp.gmail.com";
    private static final String MAIL_SMTP_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";
    private static final String MAIL_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
    private static final String JAVAX_NET_SSL_SSLSOCKETFACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_PORT = "mail.smtp.port";

    public EmailSender(Account account) {
        this.account = account;

        props = new Properties();
        props.put(MAIL_SMTP_HOST, SMTP_GMAIL_COM);
        props.put(MAIL_SMTP_SOCKETFACTORY_PORT, PORT);
        props.put(MAIL_SMTP_SOCKETFACTORY_CLASS, JAVAX_NET_SSL_SSLSOCKETFACTORY);
        props.put(MAIL_SMTP_AUTH, Boolean.TRUE);
        props.put(MAIL_SMTP_PORT, PORT);
    }

    public void send(String subject, String text, String fromEmail, String toEmail){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account.getUsername(), account.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(account.getUsername()));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //тема сообщения
            message.setSubject(subject);
            //текст
            message.setText(text);

            //отправляем сообщение
            Transport.send(message);
        } catch (MessagingException e) {
            Logger.log("Не удалось отправить сообщение!Проверьте, правильно ли указана почта и пароль");
        }
    }
}

