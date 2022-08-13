package domain.entities.cryptomoneda;

import domain.entities.activo.Activo;
import domain.entities.api.Adapter;
import domain.entities.api.CompraInterfaz;
import domain.entities.api.Compra_API;

import javax.persistence.*;

@Entity
@Table(name = "crypto")
public class Crypto implements Activo {
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Column(name="name")
    String name;

    public void setId_crypto(int id) {
        this.id_crypto = id;
    }

    @Id
    @GeneratedValue
    private int id_crypto;


    public Double getCurrent_price() {
        return currentPrice;
    }

    public void setCurrent_price(Double current_price) {
        this.currentPrice = current_price;
    }
    @Column(name="precio_Actual")
    public Double currentPrice;

   /* @OneToMany(mappedBy = "crypto", cascade = CascadeType.PERSIST)
    private List<Compra> compras;*/

    public boolean meSirveComprar() throws Exception{

        try {

            StateCrypto estado = null;
            CompraInterfaz consulta = new Adapter(); // Hacer estatico
            System.out.println(this.getName());
            System.out.println(consulta.getPrice(this.getName()));
            this.setCurrent_price(consulta.getPrice(this.getName()));
            System.out.println(this.getCurrent_price());
            if (this.getCurrent_price() < 1) {
                estado = new ShitCoin();
            } else if (this.getCurrent_price() == 1) {
                estado = new StableCoin();
            } else if (this.getCurrent_price() > 1000) {
                estado = new Strong();
            }
            System.out.println(this.getCurrent_price());

            ContextoTipoDeCrypto contexto = new ContextoTipoDeCrypto(estado);

            return contexto.meSirveComprar(this.currentPrice);
        }
        catch (Exception e) {
            System.out.println(this.getCurrent_price());
            throw new Exception("No se pudo determinar el tipo de crypto");
        }
    }

}
