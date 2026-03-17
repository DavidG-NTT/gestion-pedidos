package com.ejercicio2.infrastructure;

import com.ejercicio2.application.PayPal;
import com.ejercicio2.application.Tarjeta;
import com.ejercicio2.application.Transferencia;
import com.ejercicio2.domain.Pedido;
import com.ejercicio2.shared.exceptions.PrecioInvalidoException;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\nMENU");
            System.out.println("1. Agregar un nuevo producto al pedido");
            System.out.println("2. Precio total del pedido");
            System.out.println("3. Realizar pago");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        pedido.agregarProducto(teclado);
                        break;
                    case 2:
                        pedido.totalPedido();
                        break;
                    case 3:

                        int metodoPagoElegido = 0;

                        while (metodoPagoElegido != 4) {

                            System.out.println("\nPara realizar el pedido, seleccione uno de los siguientes metodos de pago.");
                            System.out.println("1. Paypal");
                            System.out.println("2. Tarjeta");
                            System.out.println("3. Transferencia");
                            System.out.println("4. Salir");

                            metodoPagoElegido = teclado.nextInt();
                            teclado.nextLine();

                            switch (metodoPagoElegido) {
                                case 1:
                                    pedido.realizarPago(new PayPal());
                                    break;
                                case 2:
                                    pedido.realizarPago(new Tarjeta());
                                    break;
                                case 3:
                                    pedido.realizarPago(new Transferencia());
                                    break;
                                case 4:
                                    System.out.println("Saliendo del método de pago...");
                                    break;
                                default:
                                    System.out.println("Opción incorrecta");
                            }
                        }
                        break;
                    case 4:
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
