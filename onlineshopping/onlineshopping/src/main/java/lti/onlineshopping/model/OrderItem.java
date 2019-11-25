package lti.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oiid;
	
    private int prodid;
	
	private int quantity;

	@ManyToOne
    @JoinColumn(name="orderid")
    private Order order;
    
	private double price;

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderItem() {
		super();
	}

	@Override
	public String toString() {
		return "OrderItem [oiid=" + oiid + ", prodid=" + prodid + ", quantity=" + quantity + ", order=" + order
				+ ", price=" + price + "]";
	}
	
	
	
}
