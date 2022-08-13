package domain.entities.cryptomoneda;

import domain.entities.cryptomoneda.StateCrypto;

public class Strong extends StateCrypto {
    @Override
    public boolean meSirveComprar(Double valor){
        return valor > 10000;
    }
}
