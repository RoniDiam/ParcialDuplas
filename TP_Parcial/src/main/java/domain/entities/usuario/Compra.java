package domain.entities.usuario;

import domain.entities.activo.Activo;
import domain.entities.cryptomoneda.Crypto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue
    private int id;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getCantidadDeTokens() {
        return cantidad;
    }

    public void setCantidad(Double cantidadDeTokens) {
        this.cantidad = cantidadDeTokens;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "id")
    Usuario usuario;
    @Column(name ="fecha",columnDefinition = "DATE")
    LocalDate fecha;
    @Column
    Double cantidad;
    @ManyToOne
    @JoinColumn(name="activo_id", referencedColumnName = "id_activo" )
    Activo activo;



}
