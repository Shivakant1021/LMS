package project.com.dao;

import java.util.List;

import project.com.model.Books;
import project.com.model.Member;

public interface MemberDao {
	Member addMember(Member member);
	List<Member> getAllMember();
	Member getMember(long memberId);
	Member updateMember(long memberId,Member member);
	String deleteMember(long memberId);
}
