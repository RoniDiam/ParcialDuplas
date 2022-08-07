package domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "crypto")
public class Crypto {
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
        return current_price;
    }

    public void setCurrent_price(Double current_price) {
        this.current_price = current_price;
    }
    @Transient
    public Double current_price;

   /* @OneToMany(mappedBy = "crypto", cascade = CascadeType.PERSIST)
    private List<Compra> compras;*/

    public boolean meSirveComprar() throws Exception{

        try {

            StateCrypto estado = null;
            Compra_API api = new Compra_API(); // Hacer estatico
            System.out.println(this.getName());
            System.out.println(api.getPrice(this.getName()));
            this.setCurrent_price(api.getPrice(this.getName()));
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

            return contexto.meSirveComprar(this.current_price);
        }
        catch (Exception e) {
            System.out.println(this.getCurrent_price());
            throw new Exception("No se pudo determinar el tipo de crypto");
        }
    }

}
