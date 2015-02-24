package bookrating.book;

import bookrating.algorithm.sort.heapsort.HeapSort;
import bookrating.algorithm.stack.CircularStack;
import bookrating.user.User;
import bookrating.vendor.Vendor;

public class Book {

	private Vendor[] vendor;
	private String name;
	private User[] user;
	private int[] bookRate;
	private int[] ratedTime;
	private int sumOfBookRating;
	private CircularStack stack;


	private static final int SIZE = 1000;

	private double aggregateRate;

	public void bookSearch() {
		System.out.println("Book Name: " + name);
		stack.printList();
		System.out.println("overall aggregate rate: " + calAggregateRate());
		System.out.println();
		System.out.println("Top rated Vendors of product");
		listTopRatedVendors();
	}

	public void listTopRatedVendors() {

		HeapSort heapSortVendor = new HeapSort(vendor);
		heapSortVendor.heapSortVendor();
		for (int i = 0; i < vendor.length; i++) {
			if (vendor[i] == null)
				break;
			else {
				vendor[i].calAggregateRate();
				System.out.println("Vendor: " + vendor[i].getName()
						+ "   Aggregate Rate: " + vendor[i].getAggregateRate());
			}
		}
	}

	public int getBookRate(int i) {
		return bookRate[i];
	}

	public String getName() {
		return name;
	}

	public void setVendor(int i, Vendor vendor) {
		this.vendor[i] = vendor;
	}

	public void setUser(int i, User user) {
		this.user[i] = user;
		this.bookRate[i] = user.getBookRate();// ==
		this.ratedTime[i] = 1;
	}

	public Vendor getVendor(int i) {
		return vendor[i];
	}

	public User getUser(int i) {
		return user[i];
	}

	public Book(String name) {

		stack = new CircularStack();
		this.name = name;
		vendor = new Vendor[SIZE];
		user = new User[SIZE];
		bookRate = new int[SIZE];
		ratedTime = new int[SIZE];

		for (int i = 0; i < vendor.length; i++)
			vendor[i] = null;

		for (int i = 0; i < user.length; i++)
			user[i] = null;

		for (int i = 0; i < bookRate.length; i++)
			bookRate[i] = 0;

		for (int i = 0; i < ratedTime.length; i++)
			ratedTime[i] = 0;
		
		aggregateRate = 0;
	}

	public void setVendor(Vendor vendor) {

		int temp = 0;
		int userPosition = 0;

		for (int i = 0; i < this.vendor.length; i++) {
			if (this.vendor[i] == null) {
				userPosition = i;
				break;
			} else if (this.vendor[i] == vendor) {
				temp++;
				userPosition = i;
				break;
			}

		}

		if (temp == 0) {
			// k++;
			this.vendor[userPosition] = vendor;

		} else {

		}

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

			this.user[userPosition] = user;
			this.bookRate[userPosition] += user.getBookRate();
			this.ratedTime[userPosition]++;
		} else {
			this.bookRate[userPosition] += user.getBookRate();
			this.ratedTime[userPosition]++;
		}

	}

	public double calAggregateRate() {

		double upper = 0;
		double lower = 0;

		for (int i = 0; i < user.length; i++) {
			if (this.user[i] == null)
				break;

			upper += this.user[i].getX() * this.bookRate[i];

			lower += this.user[i].getX() * this.ratedTime[i];

		}

		aggregateRate = upper / lower;
		return aggregateRate;

	}

	public CircularStack getStack() {
		return stack;
	}

	public void setStack(CircularStack stack) {
		this.stack = stack;
	}

	public Vendor[] getVendor() {
		return vendor;
	}

	public User[] getUser() {
		return user;
	}

	public int[] getBookRate() {
		return bookRate;
	}

	public int[] getRatedTime() {
		return ratedTime;
	}

	public int getSumOfBookRating() {
		return sumOfBookRating;
	}

	public void setVendor(Vendor[] vendor) {
		this.vendor = vendor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User[] user) {
		this.user = user;
	}

	public void setBookRate(int[] bookRate) {
		this.bookRate = bookRate;
	}

	public void setRatedTime(int[] ratedTime) {
		this.ratedTime = ratedTime;
	}

	public void setSumOfBookRating(int sumOfBookRating) {
		this.sumOfBookRating = sumOfBookRating;
	}

	public double getAggregateRate() {
		return aggregateRate;
	}

	public void setAggregateRate(double aggregateRate) {
		this.aggregateRate = aggregateRate;
	}

}
