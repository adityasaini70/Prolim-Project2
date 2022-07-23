package com.simplilearn.project.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "purchasetbl")
public class PurchaseReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "shoe_id")
	private Long shoeId;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "shoe_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Shoe purchasedShoe;

	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User userCustomer;

	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseReport(Long id, Long userId, Long shoeId, @NotEmpty Date date, Shoe purchasedShoe,
			User userCustomer) {
		super();
		this.id = id;
		this.userId = userId;
		this.shoeId = shoeId;
		this.date = date;
		this.purchasedShoe = purchasedShoe;
		this.userCustomer = userCustomer;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShoeId() {
		return shoeId;
	}

	public void setShoeId(Long shoeId) {
		this.shoeId = shoeId;
	}

	public Date getDate() {
		return date;
	}

	//setter(can add or modify) should be custom like below :
    public void setDate(String date){
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	public Shoe getPurchasedShoe() {
		return purchasedShoe;
	}

	public void setPurchasedShoe(Shoe purchasedShoe) {
		this.purchasedShoe = purchasedShoe;
	}

	public User getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(User userCustomer) {
		this.userCustomer = userCustomer;
	}

}
