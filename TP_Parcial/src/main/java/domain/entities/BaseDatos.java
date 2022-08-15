package domain.entities;

import db.EntityManagerHelper;
import domain.entities.cryptomoneda.Crypto;
import domain.entities.usuario.Compra;
import domain.entities.usuario.Usuario;

import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class BaseDatos {
    public static List consulta(String pedido) throws Exception{
//"SELECT name FROM Crypto Where name = '"+name+"'"
    try {
        //Revisar despues
        String consulta = pedido;
        EntityManagerHelper session = new EntityManagerHelper();
        Query query = session.createQuery(consulta);
        List results = query.getResultList();
        return results;
    }
    catch (Exception e) {
        System.out.println("El parametro ingresado no se encuenta en la base de datos");
        return null;
    }


    }
    public Crypto traerCrypto(String name) throws Exception {
       return (Crypto) this.consulta("SELECT new Crypto(id_crypto,name) FROM Crypto Where name = '"+name+"'").get(0);
    }
    public Usuario traerUsuario(String mail) throws Exception {

        return (Usuario) this.consulta("SELECT new Usuario(id,nombre,apellido,mail) FROM Usuario Where mail = '"+mail+"'").get(0);
    }

    public List traerMails() throws Exception {
        return this.consulta("SELECT mail FROM Usuario");
    }

    public List traerTop10() throws Exception {
       return this.consulta("SELECT name FROM Crypto Where id_Crypto <= 10");
    }


    public void persistir(Object objeto){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(objeto);
        EntityManagerHelper.commit();

    }



    public void persistirCryptos(Crypto[] cryptos){
        EntityManagerHelper.beginTransaction();


        Arrays.stream(cryptos).forEach(element -> {EntityManagerHelper.getEntityManager().persist(element);});

        EntityManagerHelper.commit();
    }
}
