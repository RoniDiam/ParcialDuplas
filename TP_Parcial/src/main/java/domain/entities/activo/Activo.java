package domain.entities.activo;

import javax.persistence.*;
@Entity
@Table(name = "activo")
public abstract class Activo {
    @Id
    @GeneratedValue
    private int id_activo;

    protected Activo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Column(name="nombre")
    protected
    String name;

    @Transient
    public Double current_price;




    public Activo(int id_activo, String name) {
        this.id_activo = id_activo;
        this.name = name;
    }


    public Double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Double current_price) {
        this.current_price = current_price;
    }

}
