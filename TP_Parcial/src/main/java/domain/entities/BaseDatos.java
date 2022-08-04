package domain.entities;

import db.EntityManagerHelper;

import javax.persistence.Query;

import java.util.List;

import static org.hsqldb.Tokens.T;

public class BaseDatos {
    public void consulta_Crypto(String name) throws Exception{

    try {
        //Revisar despues
        String consulta = "SELECT name FROM Crypto Where name = '"+name+"'";
        EntityManagerHelper session = new EntityManagerHelper();
        Query query = session.createQuery(consulta);
        List results = query.getResultList();
        System.out.println(results.get(0));
    }
    catch (Exception e) {
        System.out.println("La cryptomoneda ingresada no se encuentra en la base de datos");
    }


    }

    public  void guardarCompra(Compra compra){
       EntityManagerHelper session = new EntityManagerHelper();
       EntityManagerHelper.persist(compra);
       EntityManagerHelper.commit();
    }
}
