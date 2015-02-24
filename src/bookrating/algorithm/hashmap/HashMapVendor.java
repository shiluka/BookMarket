package bookrating.algorithm.hashmap;

import bookrating.vendor.Vendor;

//Hash Map for Vendor
public class HashMapVendor {

	private final static int TABLE_SIZE = 1500;
	private HashEntryVendor[] table;

	public HashMapVendor() {
		table = new HashEntryVendor[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public Vendor get(String key) {
		int hash = (Math.abs(key.hashCode()) % (TABLE_SIZE));
		// System.out.println("**" + hash+" "+table[hash].getKey()+ " **"+ key);
		while (table[hash] != null && !(table[hash].getKey().equals(key))) {
			hash = (hash + 1) % (TABLE_SIZE);
		}
		if (table[hash] == null)
			return null;
		else
			return table[hash].getValue();
	}

	public void put(String key, Vendor value) {

		int hash = (Math.abs(key.hashCode()) % (TABLE_SIZE));

		while (table[hash] != null && !(table[hash].getKey().equals(key)))
			hash = (hash + 1) % (TABLE_SIZE);

		table[hash] = new HashEntryVendor(key, value);
	}

	public void print() {

		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[i] == null)
				i++;
			else
				System.out.println(table[i].getValue().getName() + " "
						+ table[i].getKey() + "*");
		}
	}

}