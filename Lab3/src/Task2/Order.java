package Task2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		int cost = 0;
		for (int i = 0; i < items.length; i++) {
			cost += items[i].getPrice();
		}
		return cost;
	}

	public OrderItem[] sort(OrderItem[] items) {
		Arrays.sort(items, Comparator.comparing(item -> item.getProduct().getPrice()));
		return items;
	}

	// using binary search approach
	public boolean contains(Product p) {
		OrderItem[] newItems = sort(items);
		int mid = newItems.length / 2;
		int left = 0;
		int right = newItems.length - 1;
		while (left < right) {
			if (p.getPrice() > newItems[mid].getPrice()) {
				left = mid + 1;
				mid = newItems.length - 1 - ((right - left) / 2);
			}
			if (p.getPrice() < newItems[mid].getPrice()) {
				right = mid - 1;
				mid = (right - left) / 2;
			}
			if (p.getPrice() == newItems[mid].getPrice()) {
				return true;
			}
			if (right == left && p.getPrice() == newItems[mid].getPrice()) {
				return true;
			}
		}
		return false;
	}

	// get all products based on the given type using linear search
	public int getLength(OrderItem[] items, String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				count++;
			}
		}
		return count;
	}

	public Product[] filter(String type) {
		Product[] correctOnType = new Product[getLength(items, type)];
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				correctOnType[index++] = items[i].getProduct();
			}
		}
		return correctOnType;
	}

	public static void main(String[] args) {
		Product p1 = new Product("01", "Coca", 10000, "Drink");
		Product p2 = new Product("02", "Pepsi", 9000, "Drink");
		Product p3 = new Product("03", "Fanta", 8000, "Drink");
		Product p4 = new Product("04", "Aquafina", 5000, "Drink");
		Product p5 = new Product("05", "French Fries", 22000, "Food");
		Product p6 = new Product("06", "Chicken Fried", 29000, "Food");
		Product p7 = new Product("07", "Spagetti", 50000, "Food");
		Product p8 = new Product("08", "Hot Dog", 30000, "Food");
		Product p9 = new Product("09", "Cheese Burger", 35000, "Food");
		OrderItem oi1 = new OrderItem(p1, 50);
		OrderItem oi2 = new OrderItem(p2, 30);
		OrderItem oi3 = new OrderItem(p3, 20);
		OrderItem oi4 = new OrderItem(p4, 70);
		OrderItem oi5 = new OrderItem(p5, 100);
		OrderItem oi6 = new OrderItem(p6, 30);
		OrderItem oi7 = new OrderItem(p7, 70);
		OrderItem oi8 = new OrderItem(p8, 40);
		OrderItem oi9 = new OrderItem(p9, 40);
		OrderItem[] items = { oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8 };
		Order o1 = new Order(items);
		// cost
		System.out.println("cost : " + o1.cost());
		// filter
		System.out.println("filter : ");
		System.out.println(Arrays.toString(o1.filter("Food")));
		System.out.println(Arrays.toString(o1.filter("Drink")));
		// sort based on Price
		System.out.println("sort : ");
		System.out.println(Arrays.toString(o1.sort(items)));
//		 contain
		System.out.println("contains : ");
		// contains() bị lỗi khi Product là p1 và p6
		// vẫn chưa fix được
		System.out.println(o1.contains(p4));
		System.out.println(o1.contains(p9));
	}
}
