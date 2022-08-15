package domain;

import domain.entities.ConsoleHelper;
import domain.entities.controllers.CompraController;
import domain.entities.controllers.CryptoController;
import domain.entities.controllers.UsuarioController;
import domain.entities.scheduler.NotificationSchedule;
import domain.entities.sender.ContextoSender;
import domain.entities.usuario.Usuario;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.Level;

public class TP_Parcial {

    public static void main(String[] args) throws Exception {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ContextoSender.getInstancia();
        NotificationSchedule schedulerExample = new NotificationSchedule();
        schedulerExample.comenzar();
        Usuario sesion = new Usuario();
        int opc = -1;
        ConsoleHelper.print("Bienvenido\n Que desea hacer?\n 1-Iniciar sesion\n 2-Registrarse\n ");
        while (opc == -1) {
            opc = ConsoleHelper.readInt();
            ConsoleHelper.readString();
            switch (opc) {
                case 1:
                    sesion = UsuarioController.inciarSesion();
                    break;
                case 2:
                    sesion = UsuarioController.registrar();

                    break;
                default:
                    opc = -1;
                    ConsoleHelper.printLine("Operacion Incorrecta");
                    break;
            }
        }
        opc = -1;
        while (opc == -1) {
            ConsoleHelper.print("Seleccione que desea hacer? \n1-Registrar nueva compra \n2-Consultar cryptomoneda \n3-Salir del programa\n ");

            opc = ConsoleHelper.readInt();
            ConsoleHelper.readString();
            switch (opc) {
                case 1:
                    CompraController.registrarCompra(sesion);

                    break;
                case 2:
                    CryptoController.consultarCrypto();

                    break;

                case 3:
                    System.exit(0);
                    break;
                default:
                    ConsoleHelper.printLine("Operacion Incorrecta");
                    break;
            }
            opc = -1;
        }
    }

}
