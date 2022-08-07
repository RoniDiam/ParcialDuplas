package domain.entities;

public class Strong implements StateCrypto{
    @Override
    public boolean meSirveComprar(Double valor){
        return valor > 10000;
    }
}
