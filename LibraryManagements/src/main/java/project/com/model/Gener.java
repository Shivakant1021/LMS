package project.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gener")
public class Gener {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generId;
	
	@Column(name="gener_name",length=10)
	private String generName;

	public Gener(Long generId, String generName) {
		super();
		this.generId = generId;
		this.generName = generName;
	}

	public Gener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getGenerId() {
		return generId;
	}

	public void setGenerId(Long generId) {
		this.generId = generId;
	}

	public String getGenerName() {
		return generName;
	}

	public void setGenerName(String generName) {
		this.generName = generName;
	}

	@Override
	public String toString() {
		return "Gener [generId=" + generId + ", generName=" + generName + "]";
	}
    
	
    
    
}
