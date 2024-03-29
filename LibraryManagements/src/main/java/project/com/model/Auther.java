package project.com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "auther")
public class Auther {
	@Id
	@Column(name="auther_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long autherId;
	
	@Column(name = "auther_name", length = 50, nullable = false)
    private String name;

    // OneToMany relationship with Book entity (mappedBy to specify the owning side)
    @OneToMany(mappedBy = "auther", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Books> books = new ArrayList<>();

	public Auther(String name, List<Books> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Long getAutherId() {
		return autherId;
	}

	public void setAutherId(Long autherId) {
		this.autherId = autherId;
	}

	public Auther() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Auther(String autherName) {
		this.name=autherName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> book) {
		this.books = book;
	}

	@Override
	public String toString() {
		return "Auther [name=" + name + ", books=" + books + "]";
	}
	
    
	
}
