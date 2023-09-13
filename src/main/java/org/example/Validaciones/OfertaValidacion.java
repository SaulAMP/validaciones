package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.example.Utilidades.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfertaValidacion {
    private Util validacion = new Util();

    public Boolean validarTitulo(String titulo) throws Exception{
        if(titulo.length()>20){
            throw new Exception(Mensaje.FORMATO_TITULO_OFERTA.getMensaje());
        }
        return true;

    }
    public Boolean validarFechaInicioFinal(LocalDate fechaInicio, LocalDate fechaFinal) throws Exception{
        if(fechaFinal.isBefore(fechaInicio)){
           return true;
        }
        throw new Exception(Mensaje.FECHA_INICIO.getMensaje());
    }
    public Boolean validarFormatoFechaInicio(String fechaInicio) throws Exception{
        if(!validacion.buscarCoincidencia(fechaInicio,"^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")){
            throw new Exception(Mensaje.FECHAS_NULAS.getMensaje());
        }
        return true;
    }
    public Boolean validarFormatoFechaFin(String fechaFinal) throws Exception{
        if(!validacion.buscarCoincidencia(fechaFinal,"^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")){
            throw new Exception(Mensaje.FECHAS_NULAS.getMensaje());
        }

        return true;
    }
    public Boolean validarCostoPersona(Double costoPersona) throws Exception{
        if(costoPersona<0){
            throw new Exception(Mensaje.COSTO_PERSONA.getMensaje());
        }
        return  true;
    }
}
