package bookrating.vendor;

import bookrating.algorithm.stack.CircularStack;
import bookrating.book.Book;
import bookrating.user.User;

public class Vendor {

	private Book[] book;
	private String name;
	private User[] user;
	private int[] vendorRate;

	private int[] ratedTime;

	private double aggregateRate;

	private CircularStack stack;

	private static final int SIZE = 1000;

	public User getUser(int i) {
		return user[i];
	}

	public void listProductsVendorSell() {

		for (int i = 0; i < book.length; i++) {
			if (book[i] == null)
				break;
			else {
				book[i].calAggregateRate();
				System.out.println("Book: " + book[i].getName()
						+ "   Aggregate Rate: " + book[i].getAggregateRate());
			}
		}
	}

	public double calAggregateRate() {

		double upper = 0;
		double lower = 0;

		for (int i = 0; i < user.length; i++) {
			if (this.user[i] == null)
				break;

			upper += this.user[i].getxVendor() * this.vendorRate[i];
			// System.out.println(upper);
			lower += this.user[i].getxVendor() * this.ratedTime[i];

		}
		aggregateRate = upper / lower;
		return aggregateRate;

	}

	public void setUser(User user) {

		int temp = 0;
		int userPosition = 0;

		for (int i = 0; i < this.user.length; i++) {
			if (this.user[i] == null) {
				userPosition = i;
				break;
			} else if (this.user[i] == user) {
				temp++;
				userPosition = i;
				break;
			}

		}

		if (temp == 0) {
			// k++;
			this.user[userPosition] = user;
			this.vendorRate[userPosition] += user.getVendorRate();
			this.ratedTime[userPosition]++;
		} else {
			this.vendorRate[userPosition] += user.getVendorRate();
			this.ratedTime[userPosition]++;
		}

	}

	public void setBook(Book book) {
		/*
		 * int temp =0; for(int i=0;i<this.book.length;i++){
		 * if(this.book[i]==null){ break; } else if(this.book[i]==book){ temp++;
		 * }
		 * 
		 * }
		 * 
		 * if(temp==0){ j++; this.book[j]=book; }
		 */

		int temp = 0;
		int userPosition = 0;
		// int sumOfBookRating=0;

		for (int i = 0; i < this.book.length; i++) {
			if (this.book[i] == null) {
				userPosition = i;
				break;
			} else if (this.book[i] == book) {
				temp++;
				userPosition = i;
				break;
			}

		}

		if (temp == 0) {
			// k++;
			this.book[userPosition] = book;

		} else {

		}

	}

	public String getName() {
		return name;
	}

	public Vendor(String name) {
		this.name = name;
		book = new Book[SIZE];
		user = new User[SIZE];
		vendorRate = new int[SIZE];
		ratedTime = new int[SIZE];

		stack = new CircularStack();
		// vendorRate=0;

		for (int i = 0; i < book.length; i++)
			book[i] = null;

		for (int i = 0; i < user.length; i++)
			user[i] = null;

		for (int i = 0; i < vendorRate.length; i++)
			vendorRate[i] = 0;

		for (int i = 0; i < ratedTime.length; i++)
			ratedTime[i] = 0;
	}

	public void setUser(int i, User user) {
		this.user[i] = user;
		this.vendorRate[i] = user.getVendorRate();// ==
		this.ratedTime[i] = 1;
	}

	public void setBook(int i, Book book) {
		this.book[i] = book;
	}

	public void setVendorRate(int rate) {
		//
	}

	public CircularStack getStack() {
		return stack;
	}

	public void setStack(CircularStack stack) {
		this.stack = stack;
	}

	public Book[] getBook() {
		return book;
	}

	public User[] getUser() {
		return user;
	}

	public int[] getVendorRate() {
		return vendorRate;
	}

	public int[] getRatedTime() {
		return ratedTime;
	}

	public double getAggregateRate() {
		return aggregateRate;
	}

	public void setBook(Book[] book) {
		this.book = book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User[] user) {
		this.user = user;
	}

	public void setVendorRate(int[] vendorRate) {
		this.vendorRate = vendorRate;
	}

	public void setRatedTime(int[] ratedTime) {
		this.ratedTime = ratedTime;
	}

	public void setAggregateRate(double aggregateRate) {
		this.aggregateRate = aggregateRate;
	}

}
