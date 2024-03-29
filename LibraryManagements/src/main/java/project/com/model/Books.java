package project.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Books {
	@Id
	private long bookId;
	
	@Column(name = "title",length = 100)
	private String title;
	
	@Column(name = "auther_name",length = 30)
	private String autherName;
	
	@Column(name = "publicationYear",length = 4)
	private int publicationYear;
	
	@Column(name = "gener",length = 10)
	private String gener;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Auther auther;

	public Books(long bookId, String title, String autherName, int publicationYear, String gener,Auther auther) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.autherName = autherName;
		this.publicationYear = publicationYear;
		this.gener = gener;
		this.auther=auther;
		
	}
	
	




	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}






	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public Auther getAuther() {
		return auther;
	}

	public void setAuther(Auther auther) {
		this.auther = auther;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", autherName=" + autherName + ", publicationYear="
				+ publicationYear + ", gener=" + gener + ", author=" + auther + "]";
	}

	
	
	
	
}
