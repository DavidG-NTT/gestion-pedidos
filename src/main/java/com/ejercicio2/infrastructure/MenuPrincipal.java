package com.ejercicio2.infrastructure;

import com.ejercicio2.domain.Pedido;
import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.Scanner;

import static com.ejercicio2.infrastructure.MenuPago.ejecutarMenuPago;
import static com.ejercicio2.infrastructure.MenuPago.mostrarMenuPago;

public class MenuPrincipal {


    public static void ejecutarMenuPrincipal(Scanner teclado, Pedido pedido) {

        int opcion = 0;
        while (opcion != 9) {

            Main main = new Main();
            main.mostrarMenuPrincipal();

            try {
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        pedido.mostrarProductos();
                        break;
                    case 2:
                        pedido.agregarProducto(teclado);
                        break;
                    case 3:
                        pedido.actualizarProducto(teclado);
                        break;
                    case 4:
                        pedido.eliminarProducto(teclado);
                        break;
                    case 5:
                        pedido.buscarProducto(teclado);
                        break;
                    case 6:
                        pedido.totalPedido();
                        break;
                    case 7:
                        mostrarMenuPago();
                        ejecutarMenuPago(teclado, pedido);
                        break;
                    case 8:
                        pedido.vaciarPedido();
                        break;
                    case 9:
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
