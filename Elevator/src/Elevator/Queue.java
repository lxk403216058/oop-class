package Elevator;

import java.util.ArrayList;

public class Queue {
	private int size = 0;
	private ArrayList<String> f = new ArrayList<String>();

	public Queue() {

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public ArrayList<String> getF() {
		return f;
	}

	public void setF(ArrayList<String> f) {
		this.f = f;
	}

	public void add(String str) {
		f.add(str);
		size++;
	}

	public String poll() {
		if (isEmpty()) {
			System.out.println("�ն���");
			return "";
		}
		String str = f.get(0);
		f.remove(0);
		size--;

		return str;
	}

	public int getSize() {
		return f.size();
	}

}