package com.devsuperior.desafio1.service;

import org.springframework.stereotype.Service;

import com.devsuperior.desafio1.entities.Order;
@Service
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
