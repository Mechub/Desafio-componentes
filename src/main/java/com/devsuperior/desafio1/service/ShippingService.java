package com.devsuperior.desafio1.service;

public class ShippingService {

    public double shipment(double value) {
        if(value < 100) {
            return 20.00;
        } else if (value < 200) {
            return 12.00;
        } else {
            return 0.00;
        }
    }

}