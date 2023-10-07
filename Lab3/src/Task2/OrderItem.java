package Task2;

public class OrderItem {
	private Product p;
	private int quantity;

	public OrderItem(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}

	public double getPrice() {
		return p.getPrice();
	}

	public String getName() {
		return p.getName();
	}

	public String getType() {
		return p.getType();
	}

	public Product getProduct() {
		return p;
	}

	public String toString() {
		return p.toString() + " " + quantity + " ";
	}
}
