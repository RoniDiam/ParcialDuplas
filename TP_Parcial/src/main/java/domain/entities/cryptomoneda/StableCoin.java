package domain.entities.cryptomoneda;

import domain.entities.cryptomoneda.StateCrypto;

public class StableCoin extends StateCrypto {
    @Override
    public boolean meSirveComprar(Double valor){
        return true;
    }
}
