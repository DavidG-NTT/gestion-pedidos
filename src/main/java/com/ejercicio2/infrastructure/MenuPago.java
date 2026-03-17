package com.ejercicio2.infrastructure;

import com.ejercicio2.application.PayPal;
import com.ejercicio2.application.Tarjeta;
import com.ejercicio2.application.Transferencia;
import com.ejercicio2.domain.Pedido;
import com.ejercicio2.shared.exceptions.TotalInvalidoException;

import java.util.Scanner;

public class MenuPago {

    public static void menuPago(Scanner teclado, Pedido pedido) throws TotalInvalidoException {

        System.out.println("\nPara realizar el pedido, seleccione uno de los siguientes metodos de pago.");
        System.out.println("1. Paypal");
        System.out.println("2. Tarjeta");
        System.out.println("3. Transferencia");
        System.out.println("4. Salir");

        int metodoPagoElegido = teclado.nextInt();
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
}
