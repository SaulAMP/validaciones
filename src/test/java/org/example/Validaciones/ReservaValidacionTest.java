package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaValidacionTest {
    ReservaValidacion reservaValidacion;
    @BeforeEach
     public void configurarPruebas() {
        System.out.println("Se esta ejecutando la prueba");
        this.reservaValidacion = new ReservaValidacion();
    }

    @Test
    public void formatoFechaIncorrecto(){
        String prueba = "134-82-2023";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.reservaValidacion.ValidarFechasReserva(prueba));
        Assertions.assertEquals(Mensaje.FECHA_FORMATO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void formatoFechaCorrecto() {
        String prueba = "10-02-2023";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.reservaValidacion.ValidarFechasReserva(prueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void usuarioValidacionCantidad(){
        Integer usuarios=5;
        Exception respuesta=Assertions.assertThrows(Exception.class, ()-> this.reservaValidacion.validarNumeroPer(usuarios));
        Assertions.assertEquals(Mensaje.CANTIDAD_PERSONAS_RESERVA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void usuaruioValidacion(){
        Integer usuario=4;
        Boolean respuesta= Assertions.assertDoesNotThrow(()-> this.reservaValidacion.validarNumeroPer(usuario));
        Assertions.assertTrue(respuesta);
    }

}
