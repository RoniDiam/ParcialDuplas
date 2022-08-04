package domain.entities;

import javax.persistence.*;

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

    /*@OneToMany(mappedBy = "crypto", cascade = CascadeType.PERSIST)
    private List<Compra> compras;*/

}
