package domain.entities.controllers;

import domain.entities.BaseDatos;
import domain.entities.ConsoleHelper;
import domain.entities.usuario.Usuario;

public class UsuarioController {
    public static void registrar(){
        Usuario nuevoUsuario = new Usuario();

        String nombre;
        String mail;
        String apellido;

        BaseDatos base = new BaseDatos();
        ConsoleHelper.printLine("Ingrese nombre");
        nombre = ConsoleHelper.readString();
        ConsoleHelper.printLine("Ingrese apellido");
        apellido = ConsoleHelper.readString();
        ConsoleHelper.printLine("Ingrese Mail");
        mail = ConsoleHelper.readString();


        base.persistir(nuevoUsuario);

    }
}
