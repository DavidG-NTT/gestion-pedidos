package com.ejercicio2.application;

public class PayPal implements MetodoPago {

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Pago realizado con PayPal por una cantidad de: " + cantidad);
        return true;
    }
}
