package org.example.Validaciones;


import org.example.Utilidades.Mensaje;
import org.example.Utilidades.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioValidacion {
    private Util validacion = new Util();
    //metodos ordinarios
    public Boolean validarNombre(String names) throws Exception{
        //expresion regular
        if (!validacion.buscarCoincidencia(names,"^[a-zA-Z]+$")){
            throw new Exception(Mensaje.FORMATO_NOMBRE.getMensaje());
        }
        if(names.length()<10){
            throw new Exception(Mensaje.LONGITUD_NOMBRE.getMensaje());
        }
        return true;
    }
    public Boolean validarUbicacion(Integer ubicacion) throws Exception{
        if (ubicacion == 1 || ubicacion == 2 || ubicacion == 3 || ubicacion ==4){
            return true;
        }
        throw new Exception(Mensaje.FORMATO_UBICACION.getMensaje());
    }

    public Boolean validarCorreo(String correo) throws Exception{
        if(!validacion.buscarCoincidencia(correo, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new Exception(Mensaje.FORMATO_CORREO.getMensaje());
        }
        return true;
    }
}
