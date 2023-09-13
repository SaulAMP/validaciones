package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UsuarioValidacionTest {

    UsuarioValidacion usuarioValidacion;

    @BeforeEach
    public void configurarPrubasIniciales(){
        System.out.println("Ejecución prueba");
        this.usuarioValidacion = new UsuarioValidacion();
    }
    @Test
    public void nombreCorto() {
        String nombre="juanawdwsd";
        Boolean respuesta= Assertions.assertDoesNotThrow(()-> this.usuarioValidacion.validarNombre(nombre));
        System.out.println(respuesta);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNombreFallaPorCaracteresEspeciales() {
        String nombrePrueba = "S@aul";
        Exception respuesta2 = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.FORMATO_NOMBRE.getMensaje(), respuesta2.getMessage());
    }

    @Test
    public void validarNombreCorrecto() {
        String nombrePrueba = "SaulArcangel";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioValidacion.validarNombre(nombrePrueba));
        System.out.println(respuesta);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCorreoIncorrecto() {
        String correoPrueba = "saul.com";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarCorreo(correoPrueba));
        System.out.println(respuesta.getMessage());
        Assertions.assertEquals(Mensaje.FORMATO_CORREO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarCorreoCorrecto() {
        String correoPrueba = "saul@gmail.com";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioValidacion.validarCorreo(correoPrueba));
        System.out.println(respuesta);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void ubicacionIncorrecta() {
        int ubicacionPrueba = 8;
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->
            this.usuarioValidacion.validarUbicacion(ubicacionPrueba));
        System.out.println(respuesta.getMessage());
        Assertions.assertEquals(Mensaje.FORMATO_UBICACION.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void ubicacionCorrecta() {
        int ubicacionPrueba = 2;
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioValidacion.validarUbicacion(ubicacionPrueba));
        System.out.println(respuesta);
        Assertions.assertTrue(respuesta);
    }
    //


}