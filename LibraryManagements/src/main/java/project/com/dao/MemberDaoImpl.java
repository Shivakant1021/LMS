package project.com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import project.com.model.Member;
import project.com.utility.HibernateUtil;

public class MemberDaoImpl implements MemberDao {
static Scanner sc = new Scanner(System.in);
	@Override
	public Member addMember(Member member) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			
			session.save(member);
			session.getTransaction().commit();
			session.close();
			return  member;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Member> getAllMember() {
		try (Session session = HibernateUtil.getSession()) {
			Query<Member> query=session.createQuery("FROM Member");
			List<Member> memberList=query.list();
			return memberList;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Member updateMember(long memberId, Member updateMember) {
		try (Session session = HibernateUtil.getSession()) {
			Member member=session.get(Member.class, memberId);
			session.beginTransaction();
			member.setMemberName(updateMember.getMemberName());
			member.setAddress(updateMember.getAddress());
			session.save(member);
			session.getTransaction().commit();
			session.close();
			
			return  member;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteMember(long memberId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Member member=session.get(Member.class, memberId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete? if yes type y");
				String status=sc.next();
				if(status.equalsIgnoreCase("y"))
				{
					session.delete(member);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(member);//data will remove from session Cache
					message="Object is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}

	@Override
	public Member getMember(long memberId) {
	try (Session session = HibernateUtil.getSession()) {
				
				Member member = (Member) session.get(Member.class, memberId);
				return member;
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
	}

}
