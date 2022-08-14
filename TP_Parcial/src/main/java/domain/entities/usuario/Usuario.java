package domain.entities.usuario;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "usuarios")
public class Usuario {
    public Usuario() {
    }

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

    public Usuario(int id, String nombre, String apellido, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    @Column
    private String apellido;

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column
    private String mail;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<Compra> compras;

}
