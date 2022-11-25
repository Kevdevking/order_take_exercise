package assets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import assets.enu.OrderStatus;

public class Order {
	
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	

	public String getMoment() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(moment);
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		
		orderItem.add(item);
		
	}
	
	public void removeItem(OrderItem item) {
		
		orderItem.remove(item);
		
	}
	
	public double total() {
		double total = 0;
		for (OrderItem x : orderItem) {
			
			total += x.subTotal();
			
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + this.getMoment() + "\n");
		sb.append("OrderStatus: " + this.getStatus());
		sb.append("\nClient: " + this.getClient().getName());
		sb.append("\nOrder Items:\n");
		for (OrderItem x: orderItem) {
			
			sb.append(x.toString() + "\n");
			
		}
		sb.append("Total: " + String.format("$%.2f", this.total()));
		
		return sb.toString();
		
	}
	
	

}
