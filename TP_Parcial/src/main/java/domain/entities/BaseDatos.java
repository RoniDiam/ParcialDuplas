package domain.entities;

import db.EntityManagerHelper;
import domain.entities.cryptomoneda.Crypto;
import domain.entities.usuario.Compra;

import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

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
    public List traerCrypto(String name) throws Exception {
        return this.consulta_Crypto("SELECT name FROM Crypto Where name = '"+name+"'");
    }
//Esto tendria que ser un metodo solo
    public List traerIdCrypto(String name) throws Exception {
        return this.consulta_Crypto("SELECT id_crypto FROM Crypto Where name = '"+name+"'");
    }

    public List traerIdUsuario(String name) throws Exception {
        return this.consulta_Crypto("SELECT id FROM Usuario Where mail = '"+name+"'");
    }


    public List traerTop10() throws Exception {
       return this.consulta_Crypto("SELECT name FROM Crypto Where id_Crypto <= 10");
    }

    public List traerPrecio(String name) throws Exception {
        return this.consulta_Crypto("SELECT current_Price FROM Crypto Where name = '"+name+"'");
    }

    public  void guardarCompra(Compra compra){
       EntityManagerHelper session = new EntityManagerHelper();
       EntityManagerHelper.persist(compra);
       EntityManagerHelper.commit();
    }

    public void persistirCryptos(Crypto[] cryptos){
        EntityManagerHelper.beginTransaction();


        Arrays.stream(cryptos).forEach(element -> {EntityManagerHelper.getEntityManager().persist(element);});

        EntityManagerHelper.commit();
    }
}
