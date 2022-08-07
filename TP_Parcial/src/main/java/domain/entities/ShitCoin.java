package domain.entities;

public class ShitCoin implements StateCrypto{
    @Override
    public boolean meSirveComprar(Double valor){
        return valor >2;
    }
}
