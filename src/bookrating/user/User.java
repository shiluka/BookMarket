package bookrating.user;

import bookrating.book.Book;
import bookrating.vendor.Vendor;

public class User {

	private String name;
	private int num;
	private int bookRate;
	private int vendorRate;
	private double x;
	private double xVendor;
	private int numVendor;

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public User(String name) {
		this.name = name;
		num = 1;
		numVendor = 1;
	}

	public void setBookRate(int rate, Book book) {
		this.bookRate = rate;
		num++;
		x = (2 - 1 / (num - 1.0));
	}

	public void setVendorRate(int rate, Vendor vendor) {
		this.vendorRate = rate;
		vendor.setVendorRate(rate);
		numVendor++;
		xVendor = (2 - 1 / (numVendor - 1.0));
	}

	public int getBookRate() {
		return bookRate;
	}

	public int getVendorRate() {
		return vendorRate;
	}

	public double getX() {
		return x;
	}

	public double getxVendor() {
		return xVendor;
	}

	public int getNumVendor() {
		return numVendor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setBookRate(int bookRate) {
		this.bookRate = bookRate;
	}

	public void setVendorRate(int vendorRate) {
		this.vendorRate = vendorRate;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setxVendor(double xVendor) {
		this.xVendor = xVendor;
	}

	public void setNumVendor(int numVendor) {
		this.numVendor = numVendor;
	}

}
