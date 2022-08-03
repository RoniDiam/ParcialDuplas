package ContextTest;
import static org.junit.Assert.*;

import db.EntityManagerHelper;
import domain.entities.Usuario;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class test extends AbstractPersistenceTest implements WithGlobalEntityManager {

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
        Usuario usuario = new Usuario();
        usuario.setNombre("Manuel");
        usuario.setApellido("Cabral");
        usuario.setMail("123@gmail.com");

        //Esto va en otra capa de momento esta para probar
        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.getEntityManager().persist(usuario);

        EntityManagerHelper.commit();
    }
}
