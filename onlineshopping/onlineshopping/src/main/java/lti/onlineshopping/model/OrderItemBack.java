package lti.onlineshopping.model;

public class OrderItemBack {

    private int prodid;
	
	private int quantity;

	private double price;

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
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
		return "OrderItem [prodid=" + prodid + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
