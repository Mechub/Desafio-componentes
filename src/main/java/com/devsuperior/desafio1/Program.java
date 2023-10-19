package com.devsuperior.desafio1;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.service.OrderService;
import com.devsuperior.desafio1.service.ShippingService;

@SpringBootApplication
public class Program implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o código do pedido: ");
        int code = sc.nextInt();

        System.out.print("Digite o valor básico do pedido: R$");
        double valueBasic = sc.nextDouble();

        System.out.print("Digite a porcentagem de desconto: ");
        double discount = sc.nextDouble();

        Order order = new Order(code, valueBasic, discount);
        OrderService orderService = new OrderService();
        ShippingService shippingService = new ShippingService();

        double totalValue = orderService.calculateTotalValue(order, shippingService);

        System.out.println("\nPedido código " + order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", totalValue);

        sc.close();
	}

}
