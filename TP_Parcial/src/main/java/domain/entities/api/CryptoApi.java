package domain.entities.api;

import domain.entities.cryptomoneda.Crypto;
import org.apache.cxf.jaxrs.client.WebClient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.Response;

public class CryptoApi {

    public Crypto[] getApi() throws Exception {
        WebClient cryptos = WebClient.create("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = cryptos
                .header("Content-Type", "application/json")
                .get();
        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);
        if (status == 200) {

            Crypto[] crypto = objectMapper.readValue(responseBody, Crypto[].class);
            return crypto;
        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a api crypto");
        }
    }


}
