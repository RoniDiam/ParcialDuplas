package domain.entities.activo;

import domain.entities.cryptomoneda.Crypto;

public class CreadorCrypto {

    public Activo crearActivo(){
    return new Crypto();
    }
}
