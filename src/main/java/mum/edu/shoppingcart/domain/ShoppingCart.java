package mum.edu.shoppingcart.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	@OneToMany
	List<LineItem> items;

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

	@Override
	public String toString() {
		return "ShoppingCart [creationDate=" + creationDate + ", items=" + items + "]";
	}

}
