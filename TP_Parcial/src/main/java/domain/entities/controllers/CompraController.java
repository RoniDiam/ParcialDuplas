package domain.entities.controllers;

import domain.entities.BaseDatos;
import domain.entities.ConsoleHelper;
import domain.entities.activo.Activo;
import domain.entities.cryptomoneda.Crypto;
import domain.entities.usuario.Compra;
import domain.entities.usuario.Usuario;

import java.time.LocalDate;

public class CompraController {
    public static void registrarCompra(Usuario sesion) throws Exception {
        BaseDatos base = new BaseDatos();
        Compra compra = new Compra();
        Activo activo = null;
        compra.setUsuario(sesion);
        ConsoleHelper.printLine("Ingrese la criptomoneda");
        while (activo == null) {
            try {
                activo = base.traerActivo(ConsoleHelper.readString());

            } catch (Exception e){
                activo = null;
                ConsoleHelper.printLine("La cryptomoneda ingresada no es correcta\n Ingrese una nueva:");
            }


        }

        compra.setActivo((Crypto) activo);
        ConsoleHelper.printLine("Ingrese la cantidad de tokens");
        compra.setCantidad(ConsoleHelper.readDouble());
        compra.setFecha(LocalDate.now());

        base.persistir(compra);

    }
}
