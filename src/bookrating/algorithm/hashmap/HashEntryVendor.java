package bookrating.algorithm.hashmap;

import bookrating.vendor.Vendor;

//Hash Entry for Vendor
public class HashEntryVendor {

	private String key;
	private Vendor value;

	HashEntryVendor(String key, Vendor value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Vendor getValue() {
		return value;
	}
}