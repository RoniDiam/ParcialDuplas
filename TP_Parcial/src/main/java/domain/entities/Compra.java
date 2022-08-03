package domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "id")
    Usuario usuario;
    LocalDate fecha;
    @Column
    Double cantidadDeTokens;
    @Transient
    String criptomoneda;

    public static void guardarCompra(){

    }

}
