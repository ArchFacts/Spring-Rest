package Facts.Arch.ArchFacts.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    private Session criarSessaoEmail() {
        Properties props = new Properties();

        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("archfacts@outlook.com", "SociaLight@123");
            }
        });
        return session;
    }

    public void enviarEmail() throws AddressException, MessagingException {
        String msg = "Enviando email com Java.Mail";
        String assunto = "Teste de envio de email";
        String email = "luis.almeida@sptech.school";

        String remetente = "archfacts@outlook.com";
        System.out.println("__________________________________________________");
        System.out.println("Enviando email DE: " + remetente + " PARA: " + email);
        System.out.println("Assunto: " + assunto);

        Message message = new MimeMessage(criarSessaoEmail());
        message.setFrom(new InternetAddress(remetente));

        Address[] toUser = InternetAddress // Destinatário(s)
                .parse(email.trim().toLowerCase());

        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject(assunto);// Assunto
        message.setContent(msg, "text/html");
        /** Método para enviar a mensagem criada */
        Transport.send(message);

        System.out.println("Email enviado com sucesso !");
        System.out.println("__________________________________________________");
    }
}
