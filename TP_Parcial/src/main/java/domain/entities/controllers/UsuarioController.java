package domain.entities.controllers;

import db.BaseDatos;
import domain.entities.ConsoleHelper;
import domain.entities.usuario.Usuario;

public class UsuarioController {
    public static Usuario registrar() throws Exception {
        Usuario nuevoUsuario = new Usuario();


        String mail;

        BaseDatos base = new BaseDatos();
        nuevoUsuario.setNombre(ConsoleHelper.readString("Ingrese nombre: "));

        nuevoUsuario.setApellido(ConsoleHelper.readString("Ingrese apellido: "));

        mail = ConsoleHelper.readString("Ingrese Mail: ");
        nuevoUsuario.setMail(mail);


        base.persistir(nuevoUsuario);
        return base.traerUsuario(mail);

    }

    public static Usuario inciarSesion() throws Exception {
        BaseDatos base = new BaseDatos();

        ConsoleHelper.printLine("Ingrese su mail");
        return  base.traerUsuario(ConsoleHelper.readString());

    }
}
