package ContextTest;
import static org.junit.Assert.*;

import db.EntityManagerHelper;
import domain.entities.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.time.LocalDate;
import java.util.Arrays;

public class test extends AbstractPersistenceTest implements WithGlobalEntityManager {
    Usuario usuario = new Usuario();
    Crypto crypto = new Crypto();

    BaseDatos base = new BaseDatos();
    @Test
    public void contextUp() {

        assertNotNull(entityManager());
    }
    @Test
    public void contextUpWithTransaction() throws Exception {
        withTransaction(() -> {});
    }

    @Test
    public void persistirUsuario(){
        usuario.setNombre("Manuel2");
        usuario.setApellido("Cabral");
        usuario.setMail("123@gmail.com");
        crypto.setName("Bitcoin");

        EntityManagerHelper.beginTransaction();


        EntityManagerHelper.getEntityManager().persist(usuario);

        EntityManagerHelper.commit();

        //Esto va en otra capa de momento esta para probar

    }

    @Test

    public void registrarCompra(){
        usuario.setId(1);
        usuario.setNombre("Manuel");
        usuario.setApellido("Cabral");
        usuario.setMail("123@gmail.com");
        crypto.setId_crypto(1);
        crypto.setName("Bitcoin");


        Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setCantidadDeTokens(500.0);
        compra.setCriptomoneda(crypto);
        compra.setFecha(LocalDate.now());
        base.guardarCompra(compra);

        EntityManagerHelper.beginTransaction();


        EntityManagerHelper.getEntityManager().persist(compra);

        EntityManagerHelper.commit();


    }

    @Test
    public void traerCrypto() throws Exception {
        BaseDatos consulta = new BaseDatos();
        consulta.consulta_Crypto("Bitcoin");

    }

    @Test
    public void precioCrypto() throws Exception{
        Compra_API compra = new Compra_API();
        compra.getPrice("Bitcoin");
    }


    @Test
    public void meSirveBitcoin() throws Exception{
        crypto.setName("Bitcoin");
        assertEquals(true,crypto.meSirveComprar());
    }
}
