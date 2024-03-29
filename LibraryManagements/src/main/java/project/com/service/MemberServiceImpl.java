package project.com.service;

import java.util.List;

import project.com.dao.MemberDao;
import project.com.dao.MemberDaoImpl;
import project.com.model.Member;

public class MemberServiceImpl implements MemberService{
static MemberDao mdao=new MemberDaoImpl();
	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return mdao.addMember(member);
	}

	@Override
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		return mdao.getAllMember();
	}

	@Override
	public Member updateMember(long memberId, Member member) {
		// TODO Auto-generated method stub
		return mdao.updateMember(memberId, member);
	}

	@Override
	public String deleteMember(long memberId) {
		// TODO Auto-generated method stub
		return mdao.deleteMember(memberId);
	}

	@Override
	public Member getMember(long memberId) {
		// TODO Auto-generated method stub
		return mdao.getMember(memberId);
	}

}
