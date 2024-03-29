package project.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Column(name = "member_name", nullable = false)
    private String memberName;
    
    @Column(name="member_address",length=50)
    private String address;

	public Member(String memberName, String address) {
		super();
		this.memberName = memberName;
		this.address = address;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", address=" + address + "]";
	}
    
   
	
    
    

}
