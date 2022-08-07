package domain.entities;

import db.EntityManagerHelper;
import org.apache.cxf.jaxrs.client.WebClient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compra_API  {

    public Crypto[] getApi() throws Exception {
        WebClient cryptos = WebClient.create("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = cryptos
                .header("Content-Type", "application/json")
                .get();
        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
            System.out.println("response = " + responseBody);

            Crypto[] crypto = objectMapper.readValue(responseBody, Crypto[].class);
            return crypto;
        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/crypto");
        }
    }
    public void getCryptos() throws Exception {
            Crypto[] cryptos = this.getApi();
            System.out.println("Nombre = " + cryptos[1].name);

            //Mover a otra clase, no es parte del dominio
            EntityManagerHelper.beginTransaction();


            Arrays.stream(cryptos).forEach(element -> {EntityManagerHelper.getEntityManager().persist(element);});

            EntityManagerHelper.commit();


    }
    //Revisar despues
    public Double getPrice(String name) throws Exception{
        List<Double> priceAux = new ArrayList<>();
        Crypto[] cryptos = this.getApi();
        System.out.println(priceAux);
        Arrays.stream(cryptos).forEach(element ->{if(name.equals(element.name)){
            priceAux.add( element.current_price); //Tambien se puede hacer con atomicas

            System.out.println(priceAux);
            
        }
        });
        return priceAux.get(0);
        //Arrays.stream(cryptos).filter(element ->{element.name == name});
    }

}
