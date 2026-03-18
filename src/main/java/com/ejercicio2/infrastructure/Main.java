package com.ejercicio2.infrastructure;

import com.ejercicio2.domain.Pedido;

import java.util.Scanner;

import static com.ejercicio2.infrastructure.MenuPrincipal.ejecutarMenuPrincipal;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pedido pedido = new Pedido();

        ejecutarMenuPrincipal(teclado, pedido);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\nMENU");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Agregar un nuevo producto");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Buscar producto por id");
        System.out.println("6. Precio total del pedido");
        System.out.println("7. Realizar pago");
        System.out.println("8. Vaciar pedido");
        System.out.println("9. Salir");
    }
}
