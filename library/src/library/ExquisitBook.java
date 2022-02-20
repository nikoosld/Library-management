package library;

import java.util.Scanner;
/**
 * @author Nikoo Salehfard
 * @see com.library.Test
 * @see com.library.Member
 * @see com.library.Book
 * @see com.library.ChatBook
 *
 */
public class ExquisitBook extends Book {
	private String type;
	/**
	 * Constructor
	 * @param i
	 * @param n book's name
	 * @param a book's author's name
	 * @param t book's translator's name
	 * @param p book's publisher
	 * @param py book's publication year
	 * @param ty book's type(handwritten or leather or aromatic)
	 */
	public ExquisitBook(int i, String n, String a, String t, String p, int py, String ty) {
		super(i, n, a, t, p, py, "Exquisit");
		this.setType(ty);
	}
	/**
	 * setter
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * getter
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * Shows book's information 
	 */
	@Override
	public void readbook() {
		super.readbook();
		System.out.println("Book's type:" + this.getType());
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
			System.out.println("please enter book's type: handwritten or leather or aromatic");
			String ty = scanner.nextLine();
			if (ty.isEmpty() == false) {
				while (ty.equals("handwritten") == false && ty.equals("leather") == false
						&& ty.equals("aromatic") == false) {
					System.out.println("invalid,enter again please");
					ty = scanner.nextLine();
				}
			}
			this.setName(n);
			this.setAuthor(a);
			this.setTranslator(t);
			this.setPublisher(p);
			this.setPublicationYear(Integer.parseInt(py));
			if (ty.isEmpty() == false) {
				this.setType(ty);
			}
			this.setCallNumber();
			System.out.println(
					"Book's infromation are successfully updated and book's call number is : " + this.getCallNumber());
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
		} else {
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
