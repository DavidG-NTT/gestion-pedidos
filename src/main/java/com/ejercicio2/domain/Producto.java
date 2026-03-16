package com.ejercicio2.domain;

import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase para representar un producto con su id, nombre y precio. Lombok es usado para generar
 * el constructor, el método toString y Getter.
 */
@AllArgsConstructor
@Getter
@ToString
public class Producto {
    private int id;
    private String nombre;
    private double precio;

    // Método para comprobar que el precio no es negativo. Si lo es, se lanza una excepción PrecioInvalidoException.
    public void comprobarPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo: " + precio);
        }
    }
}
