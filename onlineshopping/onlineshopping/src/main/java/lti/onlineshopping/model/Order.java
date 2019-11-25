package lti.onlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Myorder")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderid;
	
	@ManyToOne()
	@JoinColumn(name="username")
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItem;
	
	private float total;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", user=" + user + ", orderItem=" + orderItem + ", total=" + total + "]";
	} 
	
	
	
	
	
}
