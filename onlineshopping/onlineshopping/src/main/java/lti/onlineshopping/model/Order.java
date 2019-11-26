package lti.onlineshopping.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Myorder")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderid;
	
	private String username;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderItem> orderItem;
	
	private String total;
	
	@Temporal(TemporalType.DATE)
	private Date date_added;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", username=" + username + ", orderItem=" + orderItem + ", total=" + total + "]";
	} 
	
	
	
	
	
}
