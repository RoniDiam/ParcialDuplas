package ContextTest;
import static org.junit.Assert.*;

import db.EntityManagerHelper;
import domain.entities.Compra;
import domain.entities.Usuario;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class test extends AbstractPersistenceTest implements WithGlobalEntityManager {
    Usuario usuario = new Usuario();
    @Test
    public void contextUp() {
        assertNotNull(entityManager());
    }
    @Test
    public void contextUpWithTransaction() throws Exception {
        withTransaction(() -> {});
    }

    @Before
    public void persistirUsuario(){
        usuario.setNombre("Manuel");
        usuario.setApellido("Cabral");
        usuario.setMail("123@gmail.com");

        //Esto va en otra capa de momento esta para probar

    }

    @Test

    public void registrarCompra(){
        Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setCantidadDeTokens(500.0);
        compra.setCriptomoneda(crypto);

    }
}
