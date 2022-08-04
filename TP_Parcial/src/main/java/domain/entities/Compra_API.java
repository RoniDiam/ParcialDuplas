package domain.entities;

import db.EntityManagerHelper;
import org.apache.cxf.jaxrs.client.WebClient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.Response;
import java.util.Arrays;

public class Compra_API  {
    public void getCryptos() throws Exception {
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
            System.out.println("Nombre = " + crypto[1].name);

            //Mover a otra clase, no es parte del dominio
            EntityManagerHelper.beginTransaction();


            Arrays.stream(crypto).forEach(element -> {EntityManagerHelper.getEntityManager().persist(element);});

            EntityManagerHelper.commit();

        } else {
        System.out.println("Error response = " + responseBody);
        throw new Exception("Error en la llamada a /api/crypto");
        }


    }
}
