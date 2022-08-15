package domain.entities.sender;

public  class ContextoSender {

    private static ContextoSender instancia = null;

    public void setSender(SenderStrategy sender) {
        this.sender = sender;
    }

    private SenderStrategy sender;
    public ContextoSender(SenderStrategy sender){
        this.sender = sender;
    }

    public void sendNotificacion(String msg) throws Exception {this.sender.sendNotification(msg);}

    public static ContextoSender getInstancia(){
        if(instancia==null){
            instancia = new ContextoSender(new EmailSender());
        }
        return instancia;
    }


}
