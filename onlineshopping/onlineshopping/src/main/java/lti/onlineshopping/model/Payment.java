package lti.onlineshopping.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private String payment_id;
private String order_id;
private String card_number;
private String card_type;
private String category;
private String cvv;
private Date date;
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
private String expirydate;
public String getPayment_id() {
	return payment_id;
}
public void setPayment_id(String payment_id) {
	this.payment_id = payment_id;
}
public String getCard_number() {
	return card_number;
}
public void setCard_number(String card_number) {
	this.card_number = card_number;
}
public String getCard_type() {
	return card_type;
}
public void setCard_type(String card_type) {
	this.card_type = card_type;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getExpirydate() {
	return expirydate;
}
public void setExpirydate(String expirydate) {
	this.expirydate = expirydate;
}

public Payment() {
	super();
}
@Override
public String toString() {
	return "Payment [payment_id=" + payment_id + ", order_id=" + order_id + ", card_number=" + card_number
			+ ", card_type=" + card_type + ", category=" + category + ", cvv=" + cvv + ", date=" + date
			+ ", expirydate=" + expirydate + "]";
}


public Payment(String payment_id, String order_id, String card_number, String card_type, String category, String cvv,
		Date date, String expirydate) {
	super();
	this.payment_id = payment_id;
	this.order_id = order_id;
	this.card_number = card_number;
	this.card_type = card_type;
	this.category = category;
	this.cvv = cvv;
	this.date = date;
	this.expirydate = expirydate;
}





}
