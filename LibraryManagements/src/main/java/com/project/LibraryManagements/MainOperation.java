package com.project.LibraryManagements;

import java.util.Scanner;
import static com.project.LibraryManagements.AllOperation.*;

public class MainOperation {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void mainOps() {
		System.out.println("------<< Library management System >>------");
		System.out.println();
		while(true) {
			System.out.println("<< MAIN PAGE >>");
			System.out.println("Press [1]: For Book Details \nPress [2]: For Member Detail");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				BookOperations();
				System.out.println("=========================================");
		          break;
			case 2:
				MemberOperation();
				System.out.println("=========================================");
				break;
			}
		}
	}




}
