package domain.entities.sender;

public class ContextoSender {
    private SenderStrategy sender;
    public ContextoSender(SenderStrategy sender){
        this.sender = sender;
    }


}
