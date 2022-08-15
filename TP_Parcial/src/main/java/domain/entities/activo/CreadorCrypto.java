package domain.entities.activo;

import domain.entities.cryptomoneda.Crypto;

public class CreadorCrypto extends  CreadorActivo {

    public Activo crearActivo(){
    return new Crypto();
    }
}
