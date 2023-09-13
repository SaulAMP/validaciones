package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OfertaValidacionTest {

    OfertaValidacion ofertaValidacion;

    @BeforeEach
    public void configurandoPruebas(){
        System.out.println("se esta ejecutando");
        this.ofertaValidacion=new OfertaValidacion();
    }

    @Test
    public void tituloTamano(){
        String titulo="saularcangelmolinapenasfdfgrgr";
        Exception respuesta= assertThrows(Exception.class, ()-> this.ofertaValidacion.validarTitulo(titulo));
        assertEquals(Mensaje.FORMATO_TITULO_OFERTA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void tituloValidacion(){
        String titulo="qwertyuio";
        Boolean respuesta= assertDoesNotThrow(()-> this.ofertaValidacion.validarTitulo(titulo));
        assertTrue(respuesta);
    }

    @Test
    public void compararFechaReserva(){
        LocalDate fechaInicio=LocalDate.of(2019,9,18);
        LocalDate fechaFin=LocalDate.of(2023,10,24);
        Exception respuesta= Assertions.assertThrows(Exception.class, ()-> this.ofertaValidacion.validarFechaInicioFinal(fechaInicio, fechaFin));
        Assertions.assertEquals(Mensaje.FECHA_INICIO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void compararValidacion(){
        LocalDate dateBooked=LocalDate.of(2024,11,11);
        LocalDate dateFinished=LocalDate.of(2020,5,2);
        Boolean respuesta= assertDoesNotThrow(()-> this.ofertaValidacion.validarFechaInicioFinal(dateBooked, dateFinished));
        assertTrue(respuesta);
    }

    @Test
    public void fechaValidacionFormato(){
        String fecha="12-9-1992";
        Exception respuesta= Assertions.assertThrows(Exception.class, ()-> this.ofertaValidacion.validarFormatoFechaInicio(fecha));
        Assertions.assertEquals(Mensaje.FECHAS_NULAS.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void fechaValidacion(){
        String fecha="11/11/2121";
        Boolean respuesta= assertDoesNotThrow(()-> this.ofertaValidacion.validarFormatoFechaFin(fecha));
        assertTrue(respuesta);
    }

    @Test
    public void validacionCostoNe(){
        Double costo=-1234123D;
        Exception respuesta= Assertions.assertThrows(Exception.class, ()-> this.ofertaValidacion.validarCostoPersona(costo));
        Assertions.assertEquals(Mensaje.COSTO_PERSONA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void costValidacion(){
        Double costo=1234123D;
        Boolean respuesta= assertDoesNotThrow(()-> this.ofertaValidacion.validarCostoPersona(costo));
        assertTrue(respuesta);
    }

}