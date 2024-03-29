package com.project.LibraryManagements;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.com.exception.ResourceNotFoundException;
import project.com.model.*;
import project.com.service.*;

public class AllOperation {
static MemberService memberservice = new MemberServiceImpl();
static AutherService autherservice = new AutherServiceImpl();
static BookService bookservice = new BookServiceImpl();
static GenerService generservice = new GenerServiceImpl();
static Scanner sc = new Scanner(System.in);
static Books books = new Books();
static Auther auther = new Auther();

	public static void BookOperations() {
		while(true) {
			System.out.println("<< BOOK OPERATION >>");
			System.out.println("Press [1]: For add Book \nPress [2]: For Show all Books \nPress [3]: For Update book \nPress [4]: For Delete Book \nPress [5]: To Return to Main Manue");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				Books book=createBook();
				Books savedEntity=bookservice.addBook(book);
				Auther auther = CreateAuther();
				autherservice.addAuther(auther);
				System.out.println("Book Data has been saved successfully"+ savedEntity);
				break;
				
			case 2:
				List<Books> books=bookservice.getAllBooks();
				for(Books b:books)
				{
					System.out.println(b);
				}
				break;
				
			case 3:
				System.out.println("Enter Book Id to update the infromation");
			       long bId=sc.nextLong();
			       Books b=bookservice.getBook(bId);
			       if(b!=null) {
			       Books bk=updateBookData();
			     //service
			       Books updatedInfo=bookservice.updateBook(bId, bk);
			       System.out.println("Book Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Book Id not found");
			       }
			       
				break;
			case 4:
				System.out.println("Enter Book Id to delete the infromation");
			       long id=sc.nextLong();
			       String message=bookservice.deleteBook(id);
			       
			       if(message!=null) {
			    	   System.out.println(message);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("Book Id not found");
				       }
				break;
			case 5:
				MainOperation.mainOps();
				break;
			}
		}
		
	}
	
	private static Auther CreateAuther() {
		String autherName=books.getAutherName();
		auther.setName(autherName);
		return auther;
	}

	private static Books updateBookData() {
		sc.nextLine();
		
		System.out.println("Enter Book title");
		String btitle=sc.nextLine();
		
		System.out.println("Enter Auther Name");
		String autherName=sc.nextLine();
		
		System.out.println("Enter Publication Year(in YYYY Formate)");
		int publicationYear=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Book gener");
		String gener=sc.nextLine();
		
		Auther auther = new Auther(autherName, new ArrayList<>());
		
		return new Books(publicationYear, btitle,autherName,publicationYear,gener,auther);
		
	}

	

	private static Books createBook() {
		
		sc.nextLine();
		System.out.println("Enter Book-ID");
		Long bookId=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter Book Title");
		String title=sc.nextLine();

		sc.nextLine();
		System.out.println("Enter Auther Name");
		String autherName=sc.nextLine();
		
		System.out.println("Enter Publication Year(in YYYY Formate)");
		int publicationYear=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Book gener");
		String gener=sc.nextLine();
		
		Auther auther = new Auther(autherName, new ArrayList<>());
		
		// Create a new Books object with the author
	    Books book = new Books(bookId, title, autherName, publicationYear, gener,auther);
		
		return book;
	}
	
	public static void MemberOperation() {
			System.out.println("<< MEMBER OPERATION >>");
			while(true) {
			System.out.println("Press [1]: For add Member \nPress [2]: For Show all member \nPress [3]: For Update member \nPress [4]: For Delete Member \nPress [5]: For go to Main Menu");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				Member member=AddMember();
				Member savedEntity=memberservice.addMember(member);
				System.out.println("Student Data has been saved successfully"+ savedEntity);
				break;
			case 2:
				List<Member> members=memberservice.getAllMember();
				for(Member m:members)
				{
					System.out.println(m);
				}
				break;
			case 3:
				System.out.println("Enter Member Id to update the infromation");
			       long mId=sc.nextLong();
			       Member m=memberservice.getMember(mId);
			       if(m!=null) {
				       Member md=updateMemberData();
				     //service
				       Member updatedInfo=memberservice.updateMember(mId, md);
				       System.out.println("Member Data has been updated Successfully"+ updatedInfo);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("Member Id not found");
				       }
			       break;
			case 4:
				System.out.print("Enter Member Id to delete the infromation: ");
			       long id=sc.nextLong();
			       String message=memberservice.deleteMember(id);
			       
			       if(message!=null) {
			    	   System.out.println(message);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("--[ Member Id not found ]--");
				       }
				break;
			case 5:
				MainOperation.mainOps();
				break;
			}
	}

}

	private static Member updateMemberData() {
		sc.nextLine();
		System.out.print("Enter Member Name: ");
		String memberName=sc.nextLine();

		sc.nextLine();
		System.out.print("Enter Member Address: ");
		String address=sc.nextLine();
		return new Member(memberName,address);
	}

	private static Member AddMember() {
		sc.nextLine();
		System.out.println("Enter Member Name");
		String memberName=sc.nextLine();

		sc.nextLine();
		System.out.println("Enter Member Address");
		String address=sc.nextLine();
		return new Member(memberName,address);
	}
}