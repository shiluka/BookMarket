package bookrating.productsearch;

import java.io.IOException;

import bookrating.algorithm.hashmap.HashMap;
import bookrating.algorithm.hashmap.HashMapUser;
import bookrating.algorithm.hashmap.HashMapVendor;
import bookrating.algorithm.sort.heapsort.HeapSort;
import bookrating.book.Book;
import bookrating.filehandler.FileReader;
import bookrating.record.Record;
import bookrating.user.User;
import bookrating.vendor.Vendor;

public class ProductSearch {

	private final static int RECORD_SIZE = 1000;

	private Record[] record;

	private HashMap hashTableBook;
	private HashMapUser hashTableUser;
	private HashMapVendor hashTableVendor;

	private Book book;
	private Vendor vendor;

	public ProductSearch() throws IOException {
		record = new Record[RECORD_SIZE];
		// book hash table
		hashTableBook = new HashMap();
		// user hash table
		hashTableUser = new HashMapUser();
		// vendor hash table
		hashTableVendor = new HashMapVendor();

		for (int i = 0; i < RECORD_SIZE; i++)
			record[i] = new Record();

		FileReader fr = new FileReader(record);

		System.out.println("before heap");
		for (int i = 0; i < RECORD_SIZE; i++) {
			System.out.println(record[i].getTimeStamp() + " " + record[i].getUserName()
					+ " " + record[i].getBookName() + " " + record[i].getVendor() + " "
					+ record[i].getVendorRating() + " " + record[i].getBookRating());
		}

		HeapSort heap = new HeapSort(record);
		heap.heapSort();
		System.out.println("****after heap" + heap.getHeapSize());
		for (int i = 0; i < RECORD_SIZE; i++) {
			System.out.println(record[i].getTimeStamp() + " " + record[i].getUserName()
					+ " " + record[i].getBookName() + " " + record[i].getVendor() + " "
					+ record[i].getVendorRating() + " " + record[i].getBookRating());
		}

		System.out.printf("=====");
		record[0].setTime();

		// creating book objects
		for (int i = 0; i < RECORD_SIZE; i++) {

			Book book = new Book(record[i].getBookName());

			Vendor vendor = new Vendor(record[i].getVendor());

			User user = new User(record[i].getUserName());
			user.setBookRate(record[i].getBookRating());
			user.setVendorRate(record[i].getVendorRating());

			if (hashTableUser.get(user.getName()) == null) {
				if (hashTableBook.get(book.getName()) == null) {
					if (hashTableVendor.get(vendor.getName()) == null) {
						user.setBookRate(record[i].getBookRating(), book);
						user.setVendorRate(record[i].getVendorRating(), vendor);
						book.setUser(0, user);
						book.setVendor(0, vendor);
						vendor.setBook(0, book);
						vendor.setUser(0, user);
						hashTableUser.put(user.getName(), user);
						hashTableBook.put(book.getName(), book);
						hashTableVendor.put(vendor.getName(), vendor);

						book.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						vendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					} else {
						Vendor tempVendor = hashTableVendor.get(vendor
								.getName());

						user.setBookRate(record[i].getBookRating(), book);
						user.setVendorRate(record[i].getVendorRating(), tempVendor);

						tempVendor.setUser(user);
						tempVendor.setBook(book);

						book.setUser(0, user);
						book.setVendor(0, tempVendor);

						book.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						tempVendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					}
					hashTableBook.put(book.getName(), book);
				} else {
					if (hashTableVendor.get(vendor.getName()) == null) {
						Book tempBook = hashTableBook.get(book.getName());

						user.setBookRate(record[i].getBookRating(), tempBook);
						user.setVendorRate(record[i].getVendorRating(), vendor);

						tempBook.setUser(user);
						tempBook.setVendor(vendor);

						vendor.setUser(0, user);
						vendor.setBook(0, tempBook);
						hashTableVendor.put(vendor.getName(), vendor);

						tempBook.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						vendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					} else {
						Book tempBook = hashTableBook.get(book.getName());
						Vendor tempVendor = hashTableVendor.get(vendor
								.getName());

						user.setBookRate(record[i].getBookRating(), tempBook);
						user.setVendorRate(record[i].getVendorRating(), tempVendor);

						tempBook.setUser(user);
						tempBook.setVendor(tempVendor);

						tempVendor.setBook(tempBook);
						tempVendor.setUser(user);

						tempBook.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						tempVendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					}
				}
				hashTableUser.put(user.getName(), user);
			} else {
				if (hashTableBook.get(book.getName()) == null) {
					if (hashTableVendor.get(vendor.getName()) == null) {
						User tempUser = hashTableUser.get(user.getName());

						tempUser.setBookRate(record[i].getBookRating(), book);
						tempUser.setVendorRate(record[i].getVendorRating(), vendor);

						book.setUser(0, tempUser);
						book.setVendor(0, vendor);
						vendor.setUser(0, tempUser);
						vendor.setBook(0, book);

						hashTableVendor.put(vendor.getName(), vendor);

						book.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						vendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					} else {
						User tempUser = hashTableUser.get(user.getName());
						Vendor tempVendor = hashTableVendor.get(vendor
								.getName());

						tempUser.setBookRate(record[i].getBookRating(), book);
						tempUser.setVendorRate(record[i].getVendorRating(),
								tempVendor);

						tempVendor.setUser(tempUser);
						tempVendor.setBook(book);
						book.setUser(0, tempUser);
						book.setVendor(0, tempVendor);

						book.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						tempVendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					}
					hashTableBook.put(book.getName(), book);
				} else {
					if (hashTableVendor.get(vendor.getName()) == null) {
						User tempUser = hashTableUser.get(user.getName());
						Book tempBook = hashTableBook.get(book.getName());

						tempUser.setBookRate(record[i].getBookRating(), tempBook);
						tempUser.setVendorRate(record[i].getVendorRating(), vendor);

						tempBook.setUser(tempUser);
						tempBook.setVendor(vendor);
						vendor.setUser(0, tempUser);
						vendor.setBook(0, tempBook);

						hashTableVendor.put(vendor.getName(), vendor);

						tempBook.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						vendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					} else {
						User tempUser = hashTableUser.get(user.getName());
						Book tempBook = hashTableBook.get(book.getName());
						Vendor tempVendor = hashTableVendor.get(vendor
								.getName());

						tempUser.setBookRate(record[i].getBookRating(), tempBook);
						tempUser.setVendorRate(record[i].getVendorRating(),
								tempVendor);

						tempBook.setUser(tempUser);
						tempBook.setVendor(tempVendor);
						tempVendor.setUser(tempUser);
						tempVendor.setBook(tempBook);

						tempBook.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());
						tempVendor.getStack().push(record[i].getTimeStamp(),
								record[i].getUserName(), record[i].getBookRating());

					}
				}
			}

		}
	}

	public void BookSearch(String name) {
		book = hashTableBook.get(name);
		try {
			book.bookSearch();
		} catch (Exception e) {
			System.out.println("ERROR: Book Name is Wrong !");
		}
	}

	public Record[] getRecord() {
		return record;
	}

	public HashMap getHashTableBook() {
		return hashTableBook;
	}

	public HashMapUser getHashTableUser() {
		return hashTableUser;
	}

	public HashMapVendor getHashTableVendor() {
		return hashTableVendor;
	}

	public Book getBook() {
		return book;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setRecord(Record[] record) {
		this.record = record;
	}

	public void setHashTableBook(HashMap hashTableBook) {
		this.hashTableBook = hashTableBook;
	}

	public void setHashTableUser(HashMapUser hashTableUser) {
		this.hashTableUser = hashTableUser;
	}

	public void setHashTableVendor(HashMapVendor hashTableVendor) {
		this.hashTableVendor = hashTableVendor;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}
