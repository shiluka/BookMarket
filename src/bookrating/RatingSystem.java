package bookrating;

import java.io.*;

import bookrating.productsearch.ProductSearch;

public class RatingSystem {

	public static void main(String[] args) throws IOException {

		ProductSearch ps = new ProductSearch();

		ps.BookSearch("The_Bobbsey_Twins");

	}

}
