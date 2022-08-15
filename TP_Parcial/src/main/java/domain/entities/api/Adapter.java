package domain.entities.api;

import domain.entities.BaseDatos;
import domain.entities.cryptomoneda.Crypto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter implements CryptoInterfaz {
    public void getCryptos() throws Exception {

        CryptoApi api = new CryptoApi();
        BaseDatos base = new BaseDatos();
        Crypto[] cryptos = api.getApi();


        base.persistirCryptos(cryptos);

    }

    public Double getPrice(String name) throws Exception{
        CryptoApi api = new CryptoApi();
        List<Double> priceAux = new ArrayList<>();
        Crypto[] cryptos = api.getApi();

        Arrays.stream(cryptos).forEach(element ->{if(name.equals(element.getName())){
            priceAux.add( element.getCurrent_price());

        }
        });
        return priceAux.get(0);
    }

}
