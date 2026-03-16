package com.ejercicio2.application;

public class Tarjeta implements MetodoPago {

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println("Pago realizado con tarjeta por una cantidad de: " + cantidad);
        return true;
    }
}
