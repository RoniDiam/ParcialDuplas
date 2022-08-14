package domain;

import domain.entities.ConsoleHelper;
import domain.entities.controllers.UsuarioController;
import domain.entities.scheduler.NotificationSchedule;

import java.io.Console;
import java.util.Scanner;

public class TP_Parcial {

    public static void main(String[] args) throws Exception {
        NotificationSchedule schedulerExample = new NotificationSchedule();
        schedulerExample.comenzar();
        Scanner scanner = new Scanner(System.in);
        int opc = -1;
        ConsoleHelper.print("Bienvenido\n Que desea hacer?\n 1-Iniciar sesion\n 2-Registrarse ");
        while (opc == -1) {
            opc = ConsoleHelper.readInt();
            switch (opc) {
                case 1:

                    break;
                case 2:
                    UsuarioController.registrar();

                    break;
                default: opc = -1;
                        ConsoleHelper.print("Operacion Incorrecta");
                        break;
            }
        }


    }
}
