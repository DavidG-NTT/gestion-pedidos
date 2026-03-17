package com.ejercicio2.domain;

import com.ejercicio2.application.MetodoPago;
import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {

    private final List<Producto> productos = new ArrayList<>();

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public void agregarProducto(Scanner teclado) throws PrecioInvalidoException {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = teclado.nextDouble();
        teclado.nextLine();

        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    public double totalPedido() throws TotalInvalidoException {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        if (total <= 0) {
            throw new TotalInvalidoException("El total del pedido no puede ser menor o igual a cero.");
        }

        System.out.println("Total del pedido: " + total);

        return total;
    }

    public void realizarPago(MetodoPago metodoPago) throws TotalInvalidoException {
        double total = totalPedido();
        metodoPago.procesarPago(total);
    }

}
