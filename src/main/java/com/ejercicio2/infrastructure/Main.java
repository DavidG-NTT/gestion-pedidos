package com.ejercicio2.infrastructure;

import com.ejercicio2.domain.Pedido;

import java.util.Scanner;

import static com.ejercicio2.infrastructure.MenuPrincipal.mostrarMenu;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int opcion = 0;

        mostrarMenu(teclado, pedido, opcion);
    }
}
