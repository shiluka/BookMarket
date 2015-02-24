package bookrating.algorithm.hashmap;

import bookrating.user.User;

//Hash Entry for User
public class HashEntryUser {

	private String key;
	private User value;

	HashEntryUser(String key, User value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public User getValue() {
		return value;
	}

}