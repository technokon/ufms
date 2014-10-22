package com.entity.processor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="SUSPICIOUS_TRANSACTION")
public class Transaction {
	
	@Id
	@GeneratedValue(generator="TRANSACTION_SEQ1")
	@SequenceGenerator(name="TRANSACTION_SEQ1", sequenceName="TRANSACTION_SEQ1", allocationSize=1)
	@Column(name="ID")
	private long id;
	
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	
	@Column(name ="TRANSACTION_NAME")
	private String name;
	
	@Column(name ="TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@Column(name ="TRANSACTION_LOCATION")
	private String location;
	
	@Column(name ="NOTES")
	private String notes;
	
	@XmlTransient
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionId=" + transactionId
				+ ", name=" + name + ", transactionDate=" + transactionDate
				+ ", location=" + location + ", notes=" + notes + "]";
	}

	
}
