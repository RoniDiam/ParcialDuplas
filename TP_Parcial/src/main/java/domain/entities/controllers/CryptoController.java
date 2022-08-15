package domain.entities.controllers;

import db.BaseDatos;
import domain.entities.ConsoleHelper;
import domain.entities.activo.Activo;
import domain.entities.api.Adapter;
import domain.entities.api.CryptoInterfaz;
import domain.entities.cryptomoneda.Crypto;

public class CryptoController {

    public static void consultarCrypto() throws Exception {
        Activo activo;

        activo = CryptoController.pedirCrypto();


        ConsoleHelper.printLine("Seleccione una opcion:\n 1_Consultar Precio\n 2_Sirve comprar crypto\n");
        int opc = -1;
        while (opc == -1){
            opc = ConsoleHelper.readInt();
            ConsoleHelper.readString();
            switch (opc){
                case 1: CryptoController.consultarPrecio(activo);
                break;
                case 2:  CryptoController.meSirveComprar(activo);
                break;
                default:
                    opc = -1;
                    ConsoleHelper.printLine("Operacion Incorrecta");
                    break;
            }
        }

    }

    public static Activo pedirCrypto(){
        Activo activo = null;
        BaseDatos base = new BaseDatos();

        ConsoleHelper.printLine("Ingrese la criptomoneda");
        while (activo == null) {
            try {
                activo = base.traerActivo(ConsoleHelper.readString());

            } catch (Exception e){
                activo = null;
                ConsoleHelper.printLine("La cryptomoneda ingresada no es correcta\n Ingrese una nueva:");
            }


        }
        return activo;
    }

    public static void consultarPrecio(Activo activo) throws Exception {
        CryptoInterfaz api = new Adapter();
        ConsoleHelper.printLine(api.getPrice(activo.getName()).toString());

    }
    public static void meSirveComprar(Activo activo) throws Exception {
       Crypto crypto;
        crypto = (Crypto) activo;
        if(crypto.meSirveComprar()) ConsoleHelper.printLine("Sirve comprar la crypto");
        else ConsoleHelper.printLine("No sirve comprar la crypto");
    }
}
