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
    @Id
    @GeneratedValue
    private int id;

    /*@OneToMany(mappedBy = "crypto", cascade = CascadeType.PERSIST)
    private List<Compra> compras;*/

}
