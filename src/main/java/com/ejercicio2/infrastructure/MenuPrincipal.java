package com.ejercicio2.infrastructure;

import com.ejercicio2.domain.Pedido;
import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.Scanner;

import static com.ejercicio2.infrastructure.MenuPago.menuPago;

public class MenuPrincipal {

    public static void mostrarMenu(Scanner teclado, Pedido pedido, int opcion) {

        while (opcion != 5) {

            System.out.println("\nMENU");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar un nuevo producto al pedido");
            System.out.println("3. Precio total del pedido");
            System.out.println("4. Realizar pago");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        pedido.mostrarProductos();
                        break;
                    case 2:
                        pedido.agregarProducto(teclado);
                        break;
                    case 3:
                        pedido.totalPedido();
                        break;
                    case 4:
                        menuPago(teclado, pedido);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (PrecioInvalidoException e) {
                System.out.println("Error al agregar el producto: " + e.getMessage());
            } catch (TotalInvalidoException e) {
                System.out.println("Error al calcular el total del pedido: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error desconocido: " + e.getMessage());
            }
        }

        teclado.close();

    }
}
