package library;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
/**
 * @author Nikoo Salehfard
 * @see com.library.Member
 * @see com.library.Book
 * @see com.library.ExquisitBook
 * @see com.library.ChatBook
 */

public class Test {
	public static void main(String[] args) {
		int baseID = 1000;
		Member[] members=new Member[1000000];                                                                                                                                     
		Book[] books=new Book[100000];                                
		ChatBook[] chatbooks=new ChatBook[100000];
		Scanner scanner=new Scanner(System.in);
		boolean control = true;    
		/**
		 * Menu
		 */
		while(control) {
			System.out.println("*******************************************************");
			System.out.println("Hello and welcome to the library what do you want to do ?");
			System.out.println("1)Sign-Up");
			System.out.println("2)Show Information");
			System.out.println("3)Update Information");
			System.out.println("4)Delete");
			System.out.println("5)Find Membersip Number");
			System.out.println("6)Submit a new book");
			System.out.println("7)Show book's information");
			System.out.println("8)Update book's information");
			System.out.println("9)Delete a book");
			System.out.println("10)Find book's call number");
			System.out.println("11)Borrowing books");
			System.out.println("12)Borrowing children and teenagers books");
			System.out.println("13)Returning books");
			System.out.println("14)List of the borrowers of a specific book");
			System.out.println("0)Exit");
			System.out.println("Choose your number");
			try {
				int option=scanner.nextInt();
				scanner.nextLine();
				control = false;
				while(control == false){
					if(option >= 0 && option <=14){
						control = true;
					}
					else{
						System.out.print("Please Enter a Valid Number: ");
						option = scanner.nextInt();
						scanner.nextLine();
					}
				}
				switch(option) {
				case 1:
					creat(members,scanner);
					break;
				case 2:
					System.out.println("please enter your membershipnumber");
					String mn =scanner.next();
					if(search(mn, members)==-1) {
						System.out.println("invalid membershipnumber");
					}
					else {
						members[search(mn, members)].read();
					}
					break;
		
				case 3:
					System.out.println("please enter your membershipnumber");
					String n =scanner.next();
					if(search(n, members)==-1) {
						System.out.println("invalid membershipnumber");
					}
					else {
						members[search(n, members)].update();
					}
					break;
				case 4:
					delete(members,scanner);
					break;
				case 5:
					searchM(members,scanner);
					break;
				case 6:
					creatbook(books,chatbooks,scanner,baseID);
					baseID++;
					break;
				case 7:
					System.out.println("please enter book's call number");
					String h =scanner.next();
					if(searchbook(h, books)==-1) {
						System.out.println("invalid call number");
					}
					else {
						books[searchbook(h, books)].readbook();
					}
					break;
				case 8:
					System.out.println("please enter book's call number");
					String m =scanner.next();
					if(searchbook(m, books)==-1) {
						System.out.println("invalid call number");
					}
					else {
						books[searchbook(m, books)].updatebook(books,chatbooks);
					}
					break;
				case 9:
					deletebook(books,chatbooks,scanner) ;
					break;
				case 10:
					searchC(books,scanner);
					break;
				case 11:
					borrow(members,books,scanner);
					break;
				case 12:
					borrowchatbook(members,chatbooks,books,scanner);
					break;
				case 13:
					returnbook(members,books,scanner);
					break;
				case 14:
					System.out.println("please enter book's call number");
					String cn =scanner.next();
					if(searchbook(cn, books)==-1) {
						System.out.println("invalid call number");
					}
					else {
						books[searchbook(cn, books)].borrowers();
					}
					break;
				case 0:
					/**
					 * After the user finished using the library's menu 2 files would be written for library's information
					 */
					try {
						/**
						 * A file for saving information of the books
						 */
						BufferedWriter b=new BufferedWriter(
								new FileWriter("C:\\Users\\Hafez\\Desktop\\liberary file\\BooksInformation.txt"));
						/**
						 * A file for saving information of the members
						 */
						BufferedWriter d=new BufferedWriter(
								new FileWriter("C:\\Users\\Hafez\\Desktop\\liberary file\\MembersInformation.txt"));
						for(int i=0; i<books.length;i++) {
							if(books[i]!=null) {
								b.write(" Name:"+books[i].getName()+"/");
								b.write(" Author's name:"+books[i].getAuthor()+"/");
								b.write(" Translator's name:"+books[i].getTranslator()+"/");
								b.write(" Publisher's name:"+books[i].getPublisher()+"/");
								b.write(" PublicationYear:"+books[i].getPublicationYear()+"/");
								b.write(" Genre:"+books[i].getGenre()+"\n");
								b.flush();
							}
						}
						for(Member member: members) {
							if(member!=null) {
								d.write("Membership number:"+member.getMemberNo()+"/");
								d.write(" Name:"+member.getName()+"/");
								d.write(" Age:"+member.getAge()+"/");
								d.write(" Gender:"+member.getGender()+"/");
								d.write(" Phone number:"+member.getPhoneNO()+"\n");
								d.flush();
							}
							}
						}
						catch(Exception ex) {
							return;}
		
					return; 
					
				
				}
			
			}
			catch(InputMismatchException e){
				System.out.println("Input Mismatched");
				scanner.nextLine();
			}
		
	}
	}
	/**
	 * Creates members
	 * @param members The library's members array
	 * @param scanner
	 */
	public static void creat(Member[] members,Scanner scanner) {
		try {
			System.out.println("please enter your name");
			String n =scanner.next();
			System.out.println("please enter your age");
			short a =scanner.nextShort();
			System.out.println("please enter your gender");
			char g=scanner.next().charAt(0);
			while(g!='m'&& g!='M'&& g!='f'&& g!='F') {
				System.out.println("invalid,enter again please");
				g=scanner.next().charAt(0);
			}
			System.out.println("please enter your phonenumber");
			String p=scanner.next();
			Member member =new Member(n,a,g,p);
			members[Member.getLength()]= member;
			member.setMemberNo();
			System.out.println("your membershipnumber is : "+member.getMemberNo());
			Member.setLength();
			Member.setCounter();
		 
		}
		catch(InputMismatchException e){
			System.out.println("Input Mismatched ");
			scanner.nextLine();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Sorry storag is full");
			scanner.nextLine();
		}

	}
	/**
	 * Deletes a member from library's members list
	 * @param members The library's members array
	 * @param scanner
	 * @return
	 */
	public static Member[] delete(Member[] members,Scanner scanner) {
		System.out.println("please enter your membershipnumber");
		String mn =scanner.next();
		if(search(mn, members)==-1) {
			System.out.println("invalid membershipnumber");
		}
		else {
			Member[] copy=new Member[1000000];
			for(int i=0 ,j=0 ; i<Member.getLength();i++ ) {
				if (i!=search(mn,members)) {
					copy[j++]=members[i];
				}
			}
			Member.setLength2();
			for(int i=0,j=0;i<Member.getLength();i++) {
				members[j++]=copy[i];
				
			}
			System.out.println("your information are successfully deleted");
		}
		return members;
		
	}
	/**
	 * Searches for a member in the library's members array by using member's membership number
	 * @param mn Member's membership number
	 * @param members The library's members array
	 * @return
	 */
	public static int search(String mn,Member[] members) {
		for (int i=0;i<Member.getLength();i++) {
			if (mn.equals(String.valueOf(members[i].getMemberNo()))) {
				return i;
			}	
	}
		return -1;
}
	/**
	 * Searches for a member in the library's members array by using member's name or just a part of it
	 * @param members The library's members array
	 * @param scanner
	 */
	public static void searchM(Member[] members,Scanner scanner) {
		try {
		System.out.println("please enter your name or just a part of it");
		String n =scanner.next();
		int s=0;
		for (int i=0;i<Member.getLength();i++) {
			if(members[i].getName().contains(n)) {
				s++;
				System.out.println("(Name:"+members[i].getName()+" Age:"+members[i].getAge()+" Gender:"+members[i].getGender()+")"+"index number of this member is: "+i);
			}
		}
		if(s>0) {
			System.out.println("Enter the index number of your selected member");
			int index=scanner.nextInt();
			if(index<s) {
			System.out.println(members[index].getMemberNo());
			}
			else {
				System.out.println("You didn't choose the index from the list above");
			}
		}
		else {
			System.out.println("There was no matched member");
		}
		}
		catch(InputMismatchException e){
			scanner.nextLine();
			System.out.println("Input Mismatched");
		}
		catch(NullPointerException e){
			System.out.println("You didn't choose the index from the list above");
			scanner.nextLine();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You didn't choose the index from the list above");
			scanner.nextLine();
		}
	}
	/**
	 * Creates book
	 * @param books The library's books array
	 * @param chatbooks The library's children and teenagers books array
	 * @param scanner
	 * @param baseID
	 */
	public static void creatbook(Book[] books,ChatBook[] chatbooks,Scanner scanner,int baseID) {
		try {
			System.out.println("please enter book's name");
			String n =scanner.next();
			scanner.nextLine();
			System.out.println("please enter author's complete name");
			String a =scanner.nextLine();
			System.out.println("please enter translator's complete name");
			String t=scanner.nextLine();
			System.out.println("please enter publisher's name");
			String p=scanner.next();
			scanner.nextLine();
			System.out.println("please enter publicationYear");
			int py=scanner.nextInt();
			scanner.nextLine();
			System.out.println("please enter book's genre");
			String g =scanner.nextLine();
			if(g.equals("Exquisit")) {
				System.out.println("What is the book's type? handwritten or leather or aromatic?");
				String ty =scanner.next();
				while(ty.equals("handwritten")==false && ty.equals("leather")==false && ty.equals("aromatic")==false) {
					System.out.println("invalid,enter again please");
					ty=scanner.next();
				}
				ExquisitBook book =new ExquisitBook(baseID,n,a,t,p,py,ty);
				book.setCallNumber();
				books[Book.getLength()]=book;
				Book.setLength();
				System.out.println("The book's call number is : "+book.getCallNumber());
			}
			else if (g.equals("Children and teenagers")) {
				System.out.println("please enter book's age level : A)1-5 B)6-7 C)8-9 D)10-11 E)12-15");
				char al =scanner.next().charAt(0);
				while(al!='A' && al!='a'&& al!='B' && al!='b' && al!='C' && al!='c' && al!='D'&& al!='d' && al!='E' && al!='e') {
					System.out.println("invalid,enter again please");
					al =scanner.next().charAt(0);
				}
				ChatBook book=new ChatBook(baseID,n,a,t,p,py,al);
				book.setCallNumber();
				books[Book.getLength()]=book;
				chatbooks[ChatBook.getChatlenght()]=book;
				Book.setLength();
				ChatBook.setChatlength();
				System.out.println("The book's call number is : "+book.getCallNumber());
			}
			else {
				Book book =new Book(baseID,n,a,t,p,py,g);
				book.setCallNumber();
				books[Book.getLength()]=book;
				Book.setLength();
				System.out.println("The book's call number is : "+book.getCallNumber());
			}
		}
		catch(InputMismatchException e){
			System.out.println("Input Mismatched ");
			scanner.nextLine();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Sorry storag is full");
			scanner.nextLine();
		}

	}
	/**
	 * Deletes a book from the library's books array
	 * @param books The library's books array
	 * @param chatbooks The library's children and teenagers books array
	 * @param scanner
	 * @return
	 */
	public static Book[] deletebook(Book[] books,ChatBook[] chatbooks,Scanner scanner) {
		System.out.println("please enter book's call number");
		String mn =scanner.next();
		if(searchbook(mn, books)==-1) {
			System.out.println("invalid book's call number");
		}
		else {
			if(books[searchbook(mn,books)].getGenre().equals("Children and teenagers")) {
				ChatBook[] copy=new ChatBook[100000];
				for(int i=0 ,j=0 ; i<ChatBook.getChatlenght();i++ ) {
					if (i!=searchbook(mn,chatbooks)) {
						copy[j++]=chatbooks[i];
					}
			}
				ChatBook.setchatlength2();
				for(int i=0,j=0;i<ChatBook.getChatlenght();i++) {
					chatbooks[j++]=copy[i];
					
				}
			}
			Book[] copy=new Book[100000];
			for(int i=0 ,j=0 ; i<Book.getLength();i++ ) {
				if (i!=searchbook(mn,books)) {
					copy[j++]=books[i];
				}
		}
			Book.setLength2();
			for(int i=0,j=0;i<Book.getLength();i++) {
				books[j++]=copy[i];
				
			}
			System.out.println("Book's information are successfully deleted");
		}
		return books;
	}
	/**
	 * Searches for a book in the library's books array by using book's call number
	 * @param mn Book's call number
	 * @param books The library's books array
	 * @return
	 */
	public static int searchbook(String mn,Book[]books) {
		for (int i=0;i<Book.getLength();i++) {
			if (mn.equals(String.valueOf(books[i].getCallNumber()))){
				return i;
			}	
	}
		return -1;
}
	/**
	 * Searches for a children and teenagers book in the library's children and teenagers books array by using book's call number
	 * @param mn Book's call number
	 * @param chatbooks The library's children and teenagers books array
	 * @return
	 */
	public static int searchbook(String mn,ChatBook[]chatbooks) {
		for (int i=0;i<ChatBook.getChatlenght();i++) {
			if (mn.equals(String.valueOf(chatbooks[i].getCallNumber()))){
				return i;
			}	
	}
		return -1;
}
	/**
	 * Searches for a book in the library's book's array by using book's name or just a part of it
	 * @param books The library's book's array
	 * @param scanner
	 */
	public static void searchC(Book[] books,Scanner scanner) {
		try {
		System.out.println("please enter book's name or just a part of it");
		String n =scanner.next();
		int s=0;
		for (int i=0;i<Book.getLength();i++) {
			if(books[i].getName().contains(n)) {
				s++;
				System.out.println("(Book's name:"+books[i].getName()+" Author's name:"+books[i].getAuthor()+" Translator's name:"+books[i].getTranslator()+" Publisher's name:"+books[i].getPublisher() +" Book's publicationYear:"+books[i].getPublicationYear()+")"+"index number of this book is: "+i);
				
			}
		}
		if(s>0) {
			System.out.println("Enter the index number of your selected book");
			int index=scanner.nextInt();
			if(index<s) {
				System.out.println(books[index].getCallNumber());
			}
			else {
				System.out.println("You didn't choose the index from the list above");
			}
		}
		else {
			System.out.println("There was no matched book");
		}

		}
		catch(InputMismatchException e){
			scanner.nextLine();
			System.out.println("Input Mismatched");
		}
		catch(NullPointerException e){
			System.out.println("You didn't choose the index from the list above");
			scanner.nextLine();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You didn't choose the index from the list above");
			scanner.nextLine();
		}
	}
	/**
	 * lends a book(except exquisite books or children and teenagers books) to a member by using book's call number and member's membership number
	 * @param members The library's member's array
	 * @param books The library's book's array
	 * @param scanner
	 */
	public static void borrow(Member[] members,Book[] books,Scanner scanner) {
		System.out.println("please enter your membershipnumber");
		String mn =scanner.next();
		System.out.println("please enter book's call number");
		String cn =scanner.next();
		if((search(mn, members)!=-1)&&(searchbook(cn, books)!=-1)) {
			if(members[search(mn, members)].getAge()>15) {
				if(books[searchbook(cn, books)].getGenre().equals("Exquisit")||books[searchbook(cn, books)].getGenre().equals("Children and teenagers")) {
					System.out.println("Sorry but you can't borrow a book from this genre");
				}
				else {
					if (books[searchbook(cn, books)].getState()==true) {
						if(members[search(mn, members)].addbook(books[searchbook(cn, books)])==true) {
							books[searchbook(cn, books)].setState();
							books[searchbook(cn, books)].bmemebrs(members[search(mn, members)]);
							System.out.println("You borrowed "+books[searchbook(cn, books)].getName()+" ;)");
						}
						else
							System.out.println("You can only borrow 5 books");
					}
					else
						System.out.println("This book is not available");
				}
			}
			else
				System.out.println("You must be over 15 to be able to borrow these kind of books , you can use case 12 in order to borrow children and teenager's books");
			}
		else 
			System.out.println("invalid membershipnumber or invalid book's call number");
	}
	/**
	 * lend a children and teenagers book to a member by using book's call number and member's membership number
	 * @param members The library's member's array
	 * @param chatbooks The library's children and teenagers book's array
	 * @param books The library's book's array
	 * @param scanner
	 */
	public static void borrowchatbook(Member[] members,ChatBook[] chatbooks, Book[] books,Scanner scanner) {
		System.out.println("please enter your membershipnumber");
		String mn =scanner.next();
		char aupper;
		char alower;
		if((search(mn, members)!=-1)) {
			short age=members[search(mn, members)].getAge();
			if(members[(search(mn, members))].getAge()<16) {
				if(age<6) {
					aupper='A';
					alower='a';
					for(int i=0; i<ChatBook.getChatlenght();i++) {
						if(chatbooks[i].getAgelevels()=='A'||chatbooks[i].getAgelevels()=='a') {
							chatbooks[i].readbook();
							System.out.println("**********************");
						}
					}
				}
				else if (age==6||age==7) {
					aupper= 'B';
					alower='b';
					for(int i=0; i<ChatBook.getChatlenght();i++) {
						if(chatbooks[i].getAgelevels()=='B'||chatbooks[i].getAgelevels()=='b') {
							chatbooks[i].readbook();
							System.out.println("**********************");
						}
					}
					
				}
				else if(age==8||age==9) {
					aupper='C';
					alower='c';
					for(int i=0; i<ChatBook.getChatlenght();i++) {
						if(chatbooks[i].getAgelevels()=='C'||chatbooks[i].getAgelevels()=='c') {
							chatbooks[i].readbook();
							System.out.println("**********************");
						}
					}
					
				}
				else if(age==10||age==11) {
					aupper='D';
					alower='d';
					for(int i=0; i<ChatBook.getChatlenght();i++) {
						if(chatbooks[i].getAgelevels()=='D'||chatbooks[i].getAgelevels()=='d') {
							chatbooks[i].readbook();
							System.out.println("**********************");
						}
					}
					
				}
				else {
					aupper='E';
					alower='e';
					for(int i=0; i<ChatBook.getChatlenght();i++) {
						if(chatbooks[i].getAgelevels()=='E'||chatbooks[i].getAgelevels()=='e') {
							chatbooks[i].readbook();
							System.out.println("**********************");
						}
					}
					
				}
				System.out.println("please enter your selected book's call number");
				String cn =scanner.next();
				if((searchbook(cn, books)!=-1)) {
					if((searchbook(cn, chatbooks)!=-1)) {
						if(aupper==chatbooks[(searchbook(cn, chatbooks))].getAgelevels()||alower==chatbooks[(searchbook(cn, chatbooks))].getAgelevels()) {
								if (books[searchbook(cn, books)].getState()==true) {
									if(members[search(mn, members)].addbook(books[searchbook(cn, books)])==true) {
										books[searchbook(cn, books)].setState();
										books[searchbook(cn, books)].bmemebrs(members[search(mn, members)]);
										System.out.println("You borrowed "+books[searchbook(cn, books)].getName()+" ;)");
									}
									else
										System.out.println("You can only borrow 5 books");
								}
								else
									System.out.println("This book is not available");
						}
						else
							System.out.println("This book is not for your age range you should have choosen a book from the upper list.");
					}
					else
						System.out.println("Your selected book is not a children and teenager's book");
				}
				else 
					System.out.println("Invalid book's call number");
			}
			else
				System.out.println("You are over 15 you can't choose a children and teenager's book, you can use case 11.");
			
		}
		else 
			System.out.println("invalid membershipnumber");
	}
	/**
	 * Takes back a book from a member by using book's call number and member's membership number
	 * @param members The library's member's array
	 * @param books The library's book's array
	 * @param scanner
	 */
	public static void returnbook(Member[] members,Book[] books,Scanner scanner) {
		System.out.println("please enter your membershipnumber");
		String mn =scanner.next();
		System.out.println("please enter book's call mnumber");
		String cn =scanner.next();
		if((search(mn, members)!=-1)&&(searchbook(cn, books)!=-1)) {
			if(members[search(mn, members)].removebook(books[searchbook(cn, books)])==true) {
				books[searchbook(cn, books)].setState();
				System.out.println("You returned "+ books[searchbook(cn, books)].getName()+" ;)");
			}
			else
				System.out.println("You haven't borrowed this book");
		}
		else 
			System.out.println("invalid membershipnumber or invalid book's call number");
	}


 }
	
