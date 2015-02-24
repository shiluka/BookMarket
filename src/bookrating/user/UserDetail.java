package bookrating.user;

public class UserDetail {

	public String userName;
	public String timeStamp;
	public int rate;

	public UserDetail(String timeStamp, String userName, int rate) {
		this.userName = userName;
		this.timeStamp = timeStamp;
		this.rate = rate;
	}

}
