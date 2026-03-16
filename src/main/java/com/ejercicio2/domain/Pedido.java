package com.ejercicio2.domain;

import com.ejercicio2.application.MetodoPago;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println(producto.toString());
    }

    public double totalPedido() throws TotalInvalidoException {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        if (total <= 0) {
            throw new TotalInvalidoException("El total del pedido no puede ser menor o igual a cero.");
        }

        return total;
    }

    public void realizarPago(MetodoPago metodoPago) throws TotalInvalidoException {
        double total = totalPedido();
        metodoPago.procesarPago(total);
    }

}
