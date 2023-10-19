package com.devsuperior.desafio1.service;

import com.devsuperior.desafio1.entities.Order;

public class OrderService {

    public double calculateDiscount(Order order) {
        return order.getBasic() * (order.getDiscount() / 100);
    }

    public double calculateTotalValue(Order order, double discount) {
        return order.getBasic() - discount;
    }

    public double calculateTotalValue(Order order, ShippingService shippingService) {
        double discountAmount = calculateDiscount(order);
        double totalValue = calculateTotalValue(order, discountAmount);
        double shippingCost = shippingService.shipment(totalValue);
        return totalValue + shippingCost;
 }   
}
