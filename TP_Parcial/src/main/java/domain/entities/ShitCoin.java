package domain.entities;

public class ShitCoin extends StateCrypto{
    @Override
    public boolean meSirveComprar(Double valor){
        return valor >2;
    }
}
