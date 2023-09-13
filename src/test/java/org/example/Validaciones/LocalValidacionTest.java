package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LocalValidacionTest {
    // Preparo la prueba

    LocalValidacion localValidacion;

    @BeforeEach
    public void iniciandoPruebas(){
        System.out.println("ejecutando prueba");
        this.localValidacion=new LocalValidacion();
    }

    @Test
    public void nombreTamano() {
        String nombre="juanasdll2lassssssssssssssssssssssass";
        Exception respuesta= Assertions.assertThrows(Exception.class, ()-> this.localValidacion.valdarNombreEmpresa(nombre));
        Assertions.assertEquals(Mensaje.LONGITUD_NIT.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void nombreValidacion(){
        String nombre="Saulmolinapeña";
        Boolean respuesta=Assertions.assertDoesNotThrow(()-> this.localValidacion.valdarNombreEmpresa(nombre));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void nitValidacionCaracteres() {
        String nit="112791A736";
        Exception respuesta=Assertions.assertThrows(Exception.class, ()-> this.localValidacion.validarNit(nit));
        Assertions.assertEquals(Mensaje.FORMATO_NIT.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void nitValidacionLongitud() {
        String nit="11279147365";
        Exception respuesta=Assertions.assertThrows(Exception.class, ()-> this.localValidacion.validarNit(nit));
        Assertions.assertEquals(Mensaje.TAMANIO_NIT.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void nitValidacion(){
        String nit="1127914736";
        Boolean respuesta=Assertions.assertDoesNotThrow(()-> this.localValidacion.validarNit(nit));
        Assertions.assertTrue(respuesta);
    }
}