package domain.entities;

import db.EntityManagerHelper;

import javax.persistence.Query;

import java.util.List;

import static org.hsqldb.Tokens.T;

public class BaseDatos {
    public List consulta_Crypto(String pedido) throws Exception{
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
        System.out.println("La cryptomoneda ingresada no se encuentra en la base de datos");
        return null;
    }


    }
    public void traerCrypto(String name) throws Exception {
        this.consulta_Crypto("SELECT name FROM Crypto Where name = '"+name+"'");
    }

    public List traerTop10() throws Exception {
       return this.consulta_Crypto("SELECT name FROM Crypto Where id_Crypto <= 10");
    }

    public  void guardarCompra(Compra compra){
       EntityManagerHelper session = new EntityManagerHelper();
       EntityManagerHelper.persist(compra);
       EntityManagerHelper.commit();
    }
}
