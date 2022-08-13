package domain.entities.sender;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    public void sendNotification(String recipient, String contenido) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("cirogamer@gmail.com");
            msg.setRecipients(Message.RecipientType.TO,
                    recipient);
            msg.setSubject("Notificacion Crypto");
            msg.setSentDate(new Date());
            msg.setText(contenido);
            Transport.send(msg, "cirogamer@gmail.com", "srpqztdtfuplgypy");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }


    }


}
