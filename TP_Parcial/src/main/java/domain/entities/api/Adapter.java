package domain.entities.api;

import db.EntityManagerHelper;
import domain.entities.BaseDatos;
import domain.entities.cryptomoneda.Crypto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter implements CompraInterfaz{
    public void getCryptos() throws Exception {

        Compra_API api = new Compra_API();
        BaseDatos base = new BaseDatos();
        Crypto[] cryptos = api.getApi();
        //System.out.println("Nombre = " + cryptos[1].getName());

        //Mover a otra clase, no es parte del dominio

        base.persistirCryptos(cryptos);

    }

    public Double getPrice(String name) throws Exception{
        Compra_API api = new Compra_API();
        List<Double> priceAux = new ArrayList<>();
        Crypto[] cryptos = api.getApi();
        System.out.println(cryptos);

        Arrays.stream(cryptos).forEach(element ->{if(name.equals(element.getName())){
            priceAux.add( element.getCurrent_price()); //Tambien se puede hacer con atomicas

            System.out.println(priceAux);

        }
        });
        return priceAux.get(0);
        //Arrays.stream(cryptos).filter(element ->{element.name == name});
    }

}
