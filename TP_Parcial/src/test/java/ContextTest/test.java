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
  /* @Test
    public void iniciarBaseCrypto() throws Exception{
       CompraInterfaz consulta = new Adapter();
       consulta.getCryptos();
    }*/

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





    }

    @Test
    public void traerCrypto() throws Exception {
        BaseDatos consulta = new BaseDatos();
        consulta.traerCrypto("Bitcoin");

    }
    @Test
    public void traerUsuario() throws Exception{
        BaseDatos base = new BaseDatos();
        ConsoleHelper.printLine(base.traerUsuario("123@gmail.com").toString());
    }

    @Test
    public void precioCrypto() throws Exception{
        CompraInterfaz llamada = new Adapter();
        llamada.getPrice("Bitcoin");
    }


    @Test
    public void meSirveBitcoin() throws Exception{
        crypto.setName("Bitcoin");
        assertEquals(true,crypto.meSirveComprar());
    }

    @Test
    public void sendEmail() throws Exception{
        EmailSender sender = new EmailSender();
        sender.sendNotification("zirofernandez39@gmail.com","El valor de tu crypto xxxxxx aumento el triple o mas en el dia xxxx  !\n" );
        
    }
    //Mandar en dos clases y averiguar como es con cron


}
