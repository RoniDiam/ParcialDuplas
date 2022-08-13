package ContextTest;
import static org.junit.Assert.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import db.EntityManagerHelper;
import domain.entities.*;
import domain.entities.api.Adapter;
import domain.entities.api.CompraInterfaz;
import domain.entities.cryptomoneda.Crypto;
import domain.entities.api.Compra_API;
import domain.entities.sender.EmailSender;
import domain.entities.usuario.Compra;
import domain.entities.usuario.Usuario;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.time.LocalDate;

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

    /*public void iniciarBaseCrypto() throws Exception{
       CompraInterfaz consulta = new Adapter();
       consulta.getCryptos();
    }*/

    @Test
    public void persistirUsuario(){
        usuario.setNombre("Manuel2");
        usuario.setApellido("Cabral");
        usuario.setMail("zirofernandez39@gmail.com");
        crypto.setName("Bitcoin");

        EntityManagerHelper.beginTransaction();


        EntityManagerHelper.getEntityManager().persist(usuario);

        EntityManagerHelper.commit();

        //Esto va en otra capa de momento esta para probar

    }

    @Test

    public void registrarCompra() throws Exception {

        usuario.setNombre("Manuel2");
        usuario.setApellido("Cabral");
        usuario.setMail("zirofernandez39@gmail.com");

        crypto.setName("Bitcoin");
        BaseDatos base = new BaseDatos();
        crypto.setId_crypto((Integer) base.traerIdCrypto(crypto.getName()).get(0));
        usuario.setId((Integer) base.traerIdUsuario(usuario.getMail()).get(0));


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
        BaseDatos base = new BaseDatos();
        System.out.println(base.traerCrypto("Bitcoin").get(0));

    }

    @Test
    public void precioCrypto() throws Exception{
        CompraInterfaz consulta = new Adapter();
        consulta.getPrice("Bitcoin");
    }
    @Test
    public void precioCryptoBase() throws Exception{
        BaseDatos base = new BaseDatos();

        System.out.println(base.traerPrecio("Bitcoin"));
    }



    @Test
    public void meSirveBitcoin() throws Exception{
        crypto.setName("Bitcoin");
        assertEquals(true,crypto.meSirveComprar());
    }


    //Mandar en dos clases y averiguar como es con cron


}
