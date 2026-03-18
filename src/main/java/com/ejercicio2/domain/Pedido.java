package com.ejercicio2.domain;

import com.ejercicio2.application.MetodoPago;
import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.*;

public class Pedido {

    private final List<Producto> productos = new ArrayList<>();

    public void mostrarProductos() throws PrecioInvalidoException {
        System.out.println("=====PRODUCTOS=====");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        if (productos.isEmpty()) {
            System.out.println("No existen productos...");
        }
    }

    public void agregarProducto(Scanner teclado) throws PrecioInvalidoException {
        mostrarProductos();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(teclado.nextLine());

        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    public void actualizarProducto(Scanner teclado) throws PrecioInvalidoException {
        mostrarProductos();
        System.out.println("Ingrese el id del producto: ");
        int id = Integer.parseInt(teclado.nextLine());

        boolean encontrado = false;
        ListIterator<Producto> listIterator = productos.listIterator();
        while (listIterator.hasNext()) {
            Producto producto = listIterator.next();
            if (producto.getId() == id) {
                System.out.print("Ingrese el nombre del producto actualizado: ");
                String nombre = teclado.nextLine();
                System.out.print("Ingrese el precio del producto actualizado: ");
                double precio = Double.parseDouble(teclado.nextLine());

                Producto productoUpdate = new Producto(id, nombre, precio);
                listIterator.set(productoUpdate);
                System.out.println("Producto actualizado: " + productoUpdate);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado por ID: " + id);
        }
    }

    public void eliminarProducto(Scanner teclado) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            System.out.print("Ingrese el id del producto: ");
            int id = Integer.parseInt(teclado.nextLine());

            boolean encontrado = false;
            Iterator<Producto> iterator = productos.iterator();
            while (iterator.hasNext()) {
                Producto producto = iterator.next();
                if (producto.getId() == id) {
                    iterator.remove();
                    System.out.println("Producto eliminado: " + producto);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado por ID: " + id);
            }
        }
    }

    public void buscarProducto(Scanner teclado) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            System.out.print("Ingrese el id del producto: ");
            int id = Integer.parseInt(teclado.nextLine());

            boolean encontrado = false;
            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    System.out.println("Producto buscado: " + producto);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado por ID: " + id);
            }
        }
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
        vaciarPedido();
    }

    public void vaciarPedido() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            Scanner teclado = new Scanner(System.in);
            System.out.println("¿Esta seguro que desea vaciar el carrito? (si/no)");
            String opcion = teclado.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                productos.clear();
                System.out.println("Carrito vaciado.");
            }
        }
    }
}
