package domain.entities.cryptomoneda;

import domain.entities.activo.Activo;
import domain.entities.api.Adapter;
import domain.entities.api.CryptoInterfaz;

import javax.persistence.*;

@Entity
public class Crypto extends Activo {


    public Crypto(int id_activo, String name) {
        super(id_activo, name);
    }

    public Crypto() {
    }

    /* @OneToMany(mappedBy = "crypto", cascade = CascadeType.PERSIST)
    private List<Compra> compras;*/

    public boolean meSirveComprar() throws Exception{

        try {

            StateCrypto estado = null;
            CryptoInterfaz consulta = new Adapter(); // Hacer estatico
            this.setCurrent_price(consulta.getPrice(this.getName()));
            if (this.getCurrent_price() < 1) {
                estado = new ShitCoin();
            } else if (this.getCurrent_price() == 1) {
                estado = new StableCoin();
            } else if (this.getCurrent_price() > 1000) {
                estado = new Strong();
            }

            ContextoTipoDeCrypto contexto = new ContextoTipoDeCrypto(estado);

            return contexto.meSirveComprar(this.getCurrent_price());
        }
        catch (Exception e) {
            throw new Exception("No se pudo determinar el tipo de crypto");
        }
    }

}
