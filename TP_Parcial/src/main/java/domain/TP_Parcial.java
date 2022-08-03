package domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.enteties.Compra_API;

public class TP_Parcial {
    public static void main(String[] args) throws JsonProcessingException {


        Compra_API prueba = new Compra_API();
        prueba.getCryptos();
    }
}
