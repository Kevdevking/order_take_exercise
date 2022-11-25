package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import assets.Client;
import assets.Order;
import assets.OrderItem;
import assets.enu.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Client Data:");
		System.out.print("Name: ");
		String name = scn.nextLine();
		System.out.print("Email: ");
		String email = scn.nextLine();
		System.out.print("Date of Birth (dd/mm/yyyy): ");
		Date dateOfBirth = sdf1.parse(scn.nextLine());
		
		Client client = new Client(name, email, dateOfBirth);
		
		System.out.println("\nEnter Order Data: ");
		LocalDateTime orderDate = LocalDateTime.now();
		
		System.out.print("Order Status:\n"
				+ "1- Pending Payment\n"
				+ "2- Processing\n"
				+ "3- Shipped\n"
				+ "4- Delivered");
		System.out.println("\n");
		int switchNumber = scn.nextInt();
		String status = "PENDING_PAYMENT";
		
		switch(switchNumber) {
			case 1:
				status = ("PENDING_PAYMENT");			
			case 2:
				status = ("PROCESSING");
			case 3:
				status = ("SHIPPED");			
			case 4:
				status = ( "DELIVERED");		
			}
		
		
		System.out.print("Number of items in this order: ");
		int numberOfItems = scn.nextInt();
		scn.nextLine();
		Order order = new Order(orderDate, OrderStatus.valueOf(status), client);
		
		for (int i = 1; i<=numberOfItems; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Item Name: ");
			String itemName = scn.nextLine();
			System.out.print("Item Price: ");
			double price = scn.nextDouble();
			scn.nextLine();
			System.out.print("Item Quantity: ");
			int quantity = scn.nextInt();
			scn.nextLine();
			
			OrderItem item = new OrderItem(itemName, quantity, price);
			
			order.addItem(item);
		}
		

		System.out.println(order);
		
		scn.close();
	}

}
