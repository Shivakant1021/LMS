package project.com.service;

import java.util.List;

import project.com.model.Member;

public interface MemberService {
	Member addMember(Member member);
	List<Member> getAllMember();
	Member getMember(long memberId);
	Member updateMember(long memberId,Member member);
	String deleteMember(long memberId);
}
