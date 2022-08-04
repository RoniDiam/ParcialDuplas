package domain.entities;

import db.EntityManagerHelper;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

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
        return cantidadDeTokens;
    }

    public void setCantidadDeTokens(Double cantidadDeTokens) {
        this.cantidadDeTokens = cantidadDeTokens;
    }

    public Crypto getCriptomoneda() {
        return criptomoneda;
    }

    public void setCriptomoneda(Crypto criptomoneda) {
        this.criptomoneda = criptomoneda;
    }

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "id")
    Usuario usuario;
    @Column(name ="fecha",columnDefinition = "DATE")
    LocalDate fecha;
    @Column
    Double cantidadDeTokens;
    @ManyToOne
    @JoinColumn(name="crypto_id", referencedColumnName = "id_crypto" )
    Crypto criptomoneda;



}
