package domain.entities.sender;

import java.util.List;

public abstract class SenderStrategy {
   public abstract void sendEmail(String recipient, String contenido);
   public abstract void sendNotification(String msg) throws Exception;


}
