package domain;

import db.EntityManagerHelper;
import domain.entities.Compra_API;
import domain.entities.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import spark.Session;

public class TP_Parcial {
    public static void main(String[] args) throws Exception {



        Compra_API prueba = new Compra_API();
        prueba.getCryptos();


    }
}
