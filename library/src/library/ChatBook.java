package library;

import java.util.Scanner;
/**
 * @author Nikoo Salehfard
 * @see com.library.Test
 * @see com.library.Member
 * @see com.library.Book
 * @see com.library.ExquisitBook
 * Chat is the short form of children and teenagers
 */
public class ChatBook extends Book {
	private char agelevels;
	private static int chatlength;
	/**
	 * Constructor
	 * @param i
	 * @param n book's name
	 * @param a book's author's name
	 * @param t book's translator's name
	 * @param p book's publisher
	 * @param py book's publication year
	 * @param al book's age level
	 */
	public ChatBook(int i, String n, String a, String t, String p, int py, char al) {
		super(i, n, a, t, p, py, "Children and teenagers");
		this.setAgelevels(al);
	}
	/**
	 * setters
	 */
	public static void setChatlength() {
		chatlength++;
	}

	public static void setchatlength2() {
		chatlength--;
	}
	public void setAgelevels(char agelevels) {
		this.agelevels = agelevels;
	}
	/**
	 * getters
	 */
	public static int getChatlenght() {
		return chatlength;
	}
	public char getAgelevels() {
		return this.agelevels;
	}
	/**
	 * Shows book's information
	 */
	@Override
	public void readbook() {
		super.readbook();
		System.out.println("Book's age level:" + this.getAgelevels());
	}
	/**
	 * Updates book's information
	 * @param Books books array
	 * @param chatbooks Children and teenager's books array
	 */
	@Override
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
			ChatBook[] copy = new ChatBook[100000];
			for (int i = 0, j = 0; i < ChatBook.getChatlenght(); i++) {
				if (i != Test.searchbook(this.getCallNumber(), chatbooks)) {
					copy[j++] = chatbooks[i];
				}
			}
			ChatBook.setchatlength2();
			for (int i = 0, j = 0; i < ChatBook.getChatlenght(); i++) {
				chatbooks[j++] = copy[i];

			}
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
			String al = scanner.nextLine();
			if (al.isEmpty() == false) {
				while (al.charAt(0) != 'A' && al.charAt(0) != 'a' && al.charAt(0) != 'B' && al.charAt(0) != 'b'
						&& al.charAt(0) != 'C' && al.charAt(0) != 'c' && al.charAt(0) != 'D' && al.charAt(0) != 'd'
						&& al.charAt(0) != 'E' && al.charAt(0) != 'e') {
					System.out.println("invalid,enter again please");
					al = scanner.nextLine();
				}
			}
			this.setName(n);
			this.setAuthor(a);
			this.setTranslator(t);
			this.setPublisher(p);
			this.setPublicationYear(Integer.parseInt(py));
			if (al.isEmpty() == false) {
				this.setAgelevels(al.charAt(0));
			}
			this.setCallNumber();
			System.out.println(
					"Book's infromation are successfully updated and book's call number is : " + this.getCallNumber());
		} else {
			ChatBook[] copy = new ChatBook[100000];
			for (int i = 0, j = 0; i < ChatBook.getChatlenght(); i++) {
				if (i != Test.searchbook(this.getCallNumber(), chatbooks)) {
					copy[j++] = chatbooks[i];
				}
			}
			ChatBook.setchatlength2();
			for (int i = 0, j = 0; i < ChatBook.getChatlenght(); i++) {
				chatbooks[j++] = copy[i];

			}
			Book book = new Book(code, n, a, t, p, Integer.parseInt(py), g);
			book.setCallNumber();
			books[Test.searchbook(this.getCallNumber(), books)] = book;
			System.out.println(
					"Book's infromation are successfully updated and book's call number is :" + book.getCallNumber());
		}
		}
		catch(NumberFormatException e) {
			System.out.println("You didn't enter publicationYear correctly");
		}
	}

}
