package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.example.Utilidades.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaValidacion {
    private Util validacion = new Util();
    public Boolean ValidarFechasReserva(String fechaReserva) throws Exception {
        if (!this.validacion.buscarCoincidencia(fechaReserva, "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$")) {
            throw new Exception(Mensaje.FECHA_FORMATO.getMensaje());
        }
            return true;

        }

        public Boolean validarNumeroPer(Integer numeroPer) throws Exception {
            try {

                if (numeroPer < 1 || numeroPer > 4) {
                    throw new Exception(Mensaje.CANTIDAD_PERSONAS_RESERVA.getMensaje());
                }
            } catch (Exception var3) {
                throw new Exception(Mensaje.CANTIDAD_PERSONAS_RESERVA.getMensaje());
            }

            return true;
        }
    }
