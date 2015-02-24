package bookrating.record;

public class Record {

	private String timeStamp;
	private String userName;
	private String bookName;
	private String vendor;
	private int vendorRating;
	private int bookRating;
	private long time;

	public long getTime() {
		return time;
	}

	public void setTime() {
		String s = "";
		for (int i = 0; i < timeStamp.length(); i++) {
			if (i == 4 || i == 7 || i == 10 || i == 13)
				continue;
			s += timeStamp.charAt(i);
		}
		System.out.println(s);
		time = Long.parseLong(s);
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getUserName() {
		return userName;
	}

	public String getBookName() {
		return bookName;
	}

	public String getVendor() {
		return vendor;
	}

	public int getVendorRating() {
		return vendorRating;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setVendorRating(int vendorRating) {
		this.vendorRating = vendorRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
