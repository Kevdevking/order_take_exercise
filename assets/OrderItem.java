package assets;

public class OrderItem {
	
	private String name;
	private int quantity;
	private double price;
	
	public OrderItem() {
		
	}

	public OrderItem(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double subTotal() {
		
		return price * quantity;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + ", quantity: " + quantity + ", Subtotal: " + String.format("$%.2f", this.subTotal());
	}
	
	

}
