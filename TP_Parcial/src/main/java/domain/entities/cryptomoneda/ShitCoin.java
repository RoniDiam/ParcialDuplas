package domain.entities.cryptomoneda;

import domain.entities.cryptomoneda.StateCrypto;

public class ShitCoin extends StateCrypto {
    @Override
    public boolean meSirveComprar(Double valor){
        return valor >2;
    }
}
