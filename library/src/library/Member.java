package library;

import java.util.Scanner;
/**
 * @author Nikoo Salehfard
 * @see com.library.Test
 * @see com.library.Book
 * @see com.library.ExquisitBook
 * @see com.library.ChatBook
 *
 */
public class Member {
	private static int length;
	private static int counter;
	private long memberNo = 1000000;
	private String name;
	private short age;
	private char gender;
	private String phoneNo;
	private Book[] borrowedbooks = new Book[5];
	
	/** 
	 * Constructor
	 * @param n Member's name
	 * @param a Member's age
	 * @param g Member's gender(F or f or M or m)
	 * @param p Member's phone number
	 */
	public Member(String n, short a, char g, String p) {

		setName(n);
		setAge(a);
		setGender(g);
		setPhoneNo(p);
	}
	/** setters */
	public static void setCounter() {
		counter++;
	}

	public static void setLength() {
		length += 1;
	}

	public static void setLength2() {
		length--;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(short age) {
		this.age = age;

	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setMemberNo() {
		this.memberNo += counter;
	}
	/** getters */
	public static int getCounter() {
		return counter;
	}

	public static int getLength() {
		return length;
	}

	public String getName() {
		return this.name;
	}

	public short getAge() {
		return this.age;
	}

	public char getGender() {
		return this.gender;
	}

	public String getPhoneNO() {
		return this.phoneNo;
	}

	public long getMemberNo() {
		return this.memberNo;
	}
	
	/**
	 * Shows member's information
	 */
	public void read() {
		System.out.println("Name:" + this.getName());
		System.out.println("Age:" + this.getAge());
		System.out.println("Gender:" + this.getGender());
		System.out.println("Phonenumber:" + this.getPhoneNO());
		System.out.println("Membership Number: " + this.getMemberNo());
	}
	/** 
	 * Updates member's information 
	 */
	public void update() {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your name");
		String n = scanner.nextLine();
		System.out.println("please enter your age");
		String a = scanner.nextLine();
		System.out.println("please enter your gender");
		String g = scanner.nextLine();
		if (g.isEmpty() == false) {
			while (g.charAt(0) != 'm' && g.charAt(0) != 'M' && g.charAt(0) != 'f' && g.charAt(0) != 'F') {
				System.out.println("invalid,enter again please");
				g = scanner.nextLine();
			}
		}
		System.out.println("please enter your phonenumber");
		String p = scanner.nextLine();
		if (n.isEmpty() == false) {
			this.setName(n);
		}
		if (a.isEmpty() == false) {
			this.setAge(Short.valueOf(a));
		}
		if (g.isEmpty() == false) {
			this.setGender(g.charAt(0));

		}
		if (p.isEmpty() == false) {
			this.setPhoneNo(p);
		}
	    }
		catch(NumberFormatException e){
            System.out.println("You didn't enter age correctly");
            
        }

	}
	/**
	 * Adds book to member's borrowed books
	 * @param book The book that the member wants to borrow
	 * @return
	 */
	public boolean addbook(Book book) {
		for (int i = 0; i < 5; i++) {
			if (borrowedbooks[i] == null) {
				borrowedbooks[i] = book;
				return true;
			}
		}
		return false;
	}
	/**
	 * Removes book from member's borrowed books
	 * @param book The book that the member wants to return to the library
	 * @return
	 */
	public boolean removebook(Book book) {
		int index = 0;
		for (int i = 0; i < 5; i++) {
			if (borrowedbooks[i] == book) {
				borrowedbooks[i] = null;
				index = i;
			}
		}
		if (borrowedbooks[index] == null) {
			for (int i = index + 1; i < 5; i++) {
				borrowedbooks[i - 1] = borrowedbooks[i];
				borrowedbooks[i] = null;
			}
			return true;
		}
		return false;
	}
}