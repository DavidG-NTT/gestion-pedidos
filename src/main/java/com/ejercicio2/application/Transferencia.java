package com.ejercicio2.application;

public class Transferencia implements MetodoPago {

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Pago realizado con transferencia por una cantidad de: " + cantidad);
        return true;
    }
}
