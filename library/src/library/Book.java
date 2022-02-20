package library;

import java.util.Scanner;

/**
 * @author Nikoo Salehfard
 * @see com.library.Test
 * @see com.library.Member
 * @see com.library.ExquisitBook
 * @see com.library.ChatBook
 *
 */
public class Book {
	private Member[] borrowmembers = new Member[10000000];
	/**
	 * Bno stands for current number of borrowers of this book
	 */
	private int Bno;
	private static int length;
	private String callNumber;
	private int ID;
	private String name;
	private String author;
	private String translator;
	private String publisher;
	private int publicationYear;
	private boolean state;
	private String genre;
	/** 
	 * Constructor
	 * @param i
	 * @param n Book's name
	 * @param a Book's author's name
	 * @param t Book's translator's name
	 * @param p Book's publisher
	 * @param py Book's publication year
	 * @param g Book's genre
	 */
	public Book(int i, String n, String a, String t, String p, int py, String g) {
		this.setID(i);
		this.setName(n);
		this.setAuthor(a);
		this.setTranslator(t);
		this.setPublisher(p);
		this.setPublicationYear(py);
		this.setState();
		this.setGenre(g);
	}
	/**setters */
	public static void setLength() {
		length += 1;
	}

	public static void setLength2() {
		length--;
	}

	public void setCallNumber() {
		int index = -1;
		for (int i = 0; i < author.length(); i++) {
			if (Character.isWhitespace(author.charAt(i))) {
				index = i;
				break;
			}
		}
		this.callNumber = this.ID + "/" + Character.toUpperCase(this.author.charAt(0))
				+ Character.toUpperCase(this.author.charAt(index + 1)) + "/"
				+ String.valueOf(this.publicationYear).charAt(2) + String.valueOf(this.publicationYear).charAt(3);
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public void setState() {
		if (this.state == true) {
			this.state = false;
		} else
			this.state = true;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**getters */
	public static int getLength() {
		return length;
	}

	public String getCallNumber() {
		return this.callNumber;
	}


	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getAuthor() {
		return this.author;
	}
	public String getTranslator() {
		return this.translator;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public int getPublicationYear() {
		return this.publicationYear;
	}
	public boolean getState() {
		return this.state;
	}

	public String getGenre() {
		return this.genre;
	}
	/** 
	 * Shows book's information
	 */
	public void readbook() {
		System.out.println("Book's name:" + this.getName());
		System.out.println("Author's name:" + this.getAuthor());
		System.out.println("Translator's name:" + this.getTranslator());
		System.out.println("Publisher's name:" + this.getPublisher());
		System.out.println("Book's publicationYear:" + this.getPublicationYear());
		System.out.println("Book's genre:" + this.getGenre());
		System.out.println("Book's call number:" + this.getCallNumber());
	}
	/**
	 * Updates book's information
	 * @param Books books array
	 * @param chatbooks Children and teenager's books array
	 */
	public void updatebook(Book[] books, ChatBook[] chatbooks) {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter book's name");
		String n = scanner.nextLine();
		System.out.println("please enter author's name");
		String a = scanner.nextLine();
		System.out.println("please enter translator's name");
		String t = scanner.nextLine();
		System.out.println("please enter publisher's name ");
		String p = scanner.nextLine();
		System.out.println("please enter book's publicationYear ");
		String py = scanner.nextLine();
		System.out.println("please enter book's genre ");
		String g = scanner.nextLine();
		if (n.isEmpty() == true) {
			n = this.getName();
		}
		if (a.isEmpty() == true) {
			a = this.getAuthor();
		}
		if (t.isEmpty() == true) {
			t = this.getTranslator();
		}
		if (p.isEmpty() == true) {
			p = this.getPublisher();
		}
		if (py.isEmpty() == true) {
			py = String.valueOf(this.getPublicationYear());
		}
		if (g.isEmpty() == true) {
			g = this.getGenre();
		}
		int code = Integer.parseInt(this.getCallNumber().substring(0, 4));
		if (g.equals("Exquisit")) {
			System.out.println("What is the book's type? handwritten or leather or aromatic?");
			String ty = scanner.next();
			while (ty.equals("handwritten") == false && ty.equals("leather") == false
					&& ty.equals("aromatic") == false) {
				System.out.println("invalid,enter again please");
				ty = scanner.next();
			}
			ExquisitBook book = new ExquisitBook(code, n, a, t, p, Integer.parseInt(py), ty);
			book.setCallNumber();
			books[Test.searchbook(this.getCallNumber(), books)] = book;
			System.out.println(
					"Book's infromation are successfully updated and book's call number is :" + book.getCallNumber());
		} else if (g.equals("Children and teenagers")) {
			System.out.println("please enter book's age level : A)1-5 B)6-7 C)8-9 D)10-11 E)12-15");
			char al = scanner.next().charAt(0);
			while (al != 'A' && al != 'a' && al != 'B' && al != 'b' && al != 'C' && al != 'c' && al != 'D' && al != 'd'
					&& al != 'E' && al != 'e') {
				System.out.println("invalid,enter again please");
				al = scanner.next().charAt(0);
			}
			ChatBook book = new ChatBook(code, n, a, t, p, Integer.parseInt(py), al);
			book.setCallNumber();
			books[Test.searchbook(this.getCallNumber(), books)] = book;
			chatbooks[ChatBook.getChatlenght()] = book;
			ChatBook.setChatlength();
			System.out.println(
					"Book's infromation are successfully updated and book's call number is :" + book.getCallNumber());
		}

		else {
			this.setName(n);
			this.setAuthor(a);
			this.setTranslator(t);
			this.setPublisher(p);
			this.setPublicationYear(Integer.parseInt(py));
			this.setGenre(g);
			this.setCallNumber();
			System.out.println(
					"Book's infromation are successfully updated and book's call number is : " + this.getCallNumber());
		}
		}
		catch(NumberFormatException e){
			System.out.println("You didn't enter publicationYear correctly");
			
		}

	}
	/**
	 * Add borrowers to book's borrowers list
	 * @param member The member that borrowed this book
	 */
	public boolean bmemebrs(Member member) {
		for (int i = 0; i < borrowmembers.length; i++) {
			if (borrowmembers[i] == null) {
				borrowmembers[i] = member;
				Bno++;
				return true;
			}
		}
		return false;
	}
	/**
	 * Print book's borrowers list
	 */
	public void borrowers() {
		for (int i = 0; i < borrowmembers.length; i++) {
			if(borrowmembers[i]!=null) {
				System.out.println(borrowmembers[i].getName());
				if (i == Bno-1 ) {
					if(state==false) {
						System.out.println("The current borrower of this book is " + borrowmembers[i].getName());
					}
					else {
						System.out.println("This book is available now");
					}
				}
			}
		}
	}
}
