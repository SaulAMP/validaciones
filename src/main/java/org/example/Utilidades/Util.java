package org.example.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public Boolean buscarCoincidencia(String validacion, String expresionRegular){
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher coincidencia = patron.matcher(validacion);
        if(coincidencia.matches()){
            return true;
        }
        else {
            return false;
        }
    }

    public LocalDate convertirString(String fecha, String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        LocalDate fechaForm = LocalDate.parse(fecha,formatter);
        return  fechaForm;
    }
}
