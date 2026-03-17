package com.ejercicio2.domain;

import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase para representar un producto con su id, nombre y precio. Lombok es usado para generar
 * el método toString y Getter.
 */
@Getter
@ToString
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private static int contadorId = 1;

    public Producto(String nombre, double precio) throws PrecioInvalidoException {
        this.id = contadorId++;
        this.nombre = nombre;
        comprobarPrecio(precio);
        this.precio = precio;
    }

    // Método para comprobar que el precio no es negativo. Si lo es, se lanza una excepción PrecioInvalidoException.
    public void comprobarPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo.");
        }
    }
}
