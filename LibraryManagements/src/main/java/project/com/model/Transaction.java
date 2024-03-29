package project.com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	public Transaction(Long transactionId) {
		super();
		this.transactionId = transactionId;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + "]";
	}

	
}
