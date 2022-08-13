package domain.entities.usuario;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "usuarios")
public class Usuario {
    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private int id;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    private String nombre;

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column
    private String apellido;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    @Column
    private String mail;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<Compra> compras;

}
