package org.ed05_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionJuegosTest {

    private GestorJuegos gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorJuegos();

        gestor.registrarLoteJuegos(
                new String[]{"ABC123"},
                new int[]{10}
        );
    }

    @Test
    void ventaCorrecta() {
        int resultado = gestor.venderJuego("ABC123", 2);
        assertEquals(2, resultado);
    }

    @Test
    void cantidadCero() {
        int resultado = gestor.venderJuego("ABC123", 0);
        assertEquals(0, resultado);
    }

    @Test
    void cantidadNegativa() {
        int resultado = gestor.venderJuego("ABC123", -1);
        assertEquals(0, resultado);
    }

    @Test
    void stockInsuficiente() {
        int resultado = gestor.venderJuego("ABC123", 11);
        assertEquals(-2, resultado);
    }

    @Test
    void juegoNoExiste() {
        int resultado = gestor.venderJuego("XYZ999", 2);
        assertEquals(-1, resultado);
    }

    @Test
    void codigoInvalidoLongitud() {
        int resultado = gestor.venderJuego("ABC12", 2);
        assertEquals(0, resultado);
    }

    @Test
    void codigoInvalidoMinusculas() {
        int resultado = gestor.venderJuego("abc123", 2);
        assertEquals(0, resultado);
    }
}