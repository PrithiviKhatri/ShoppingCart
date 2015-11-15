package mum.edu.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LineItem  implements Serializable{

	@Id
	@GeneratedValue
	Long id;

	int quanity;

	double totalprice;

	@ManyToOne
	Product product;

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "LineItem [quanity=" + quanity + ", totalprice=" + totalprice + "]";
	}

}
