package mum.edu.shoppingcart.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Shopping cart implements serializable because it needs to be stored in
 * session.
 * 
 * @author prithivi
 *
 */
@Entity
public class ShoppingCart implements Serializable {

	@Id
	@GeneratedValue
	Long id;

	Date creationDate;

	@OneToMany(cascade=CascadeType.ALL)
	List<LineItem> items;

	Double totalamout;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	
	public Double getTotalamout() {
		return totalamout;
	}

	public void setTotalamout(Double totalamout) {
		this.totalamout = totalamout;
	}

	@Override
	public String toString() {
		return "ShoppingCart [creationDate=" + creationDate + ", items=" + items + "]";
	}

}
