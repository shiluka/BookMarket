package bookrating.algorithm.stack;

import bookrating.user.UserDetail;

//Circular Stack
public class CircularStack {

	private static final int SIZE = 5;

	private int stackPointer;
	private UserDetail[] recentList;
	private UserDetail ud;

	public CircularStack() {

		recentList = new UserDetail[SIZE];

		for (int i = 0; i < recentList.length; i++)
			recentList[i] = null;

		stackPointer = 0;
	}

	public void push(String time, String userName, int rate) {

		ud = new UserDetail(time, userName, rate);

		if (stackPointer == 5) {
			stackPointer = 0;
			recentList[stackPointer] = ud;
			stackPointer++;
		} else {
			recentList[stackPointer] = ud;
			stackPointer++;
		}
	}

	public void printList() {

		System.out.println("5 most recent ratings of product");
		int tempStackPointer = stackPointer;
		tempStackPointer--;
		for (int i = tempStackPointer; i >= 0; i--) {
			System.out.println("time: " + recentList[i].timeStamp
					+ "  userName: " + recentList[i].userName + "  rate: "
					+ recentList[i].rate);
			if (i == 0) {
				int x = SIZE - 1;
				while (x >= stackPointer) {
					if (recentList[x] == null)
						break;
					else {
						System.out.println("time: " + recentList[i].timeStamp
								+ "  userName: " + recentList[i].userName
								+ "  rate: " + recentList[i].rate);
						x--;
					}
				}
			}
		}
		System.out.println();
	}

}
