package Fx;

//报名活动类
public class RegistrationActivity {
	private String tag;
	private String deadline;
	private String numberLimit;
	private int num;

	public RegistrationActivity() {

	}

	public RegistrationActivity(String tag, String deadline, String numberLimit, int num) {
		this.tag = tag;
		this.deadline = deadline;
		this.numberLimit = numberLimit;
		this.num = num;
	}

	public String getTag() {
		return tag;
	}

	public String getDeadline() {
		return deadline;
	}

	public String getNumberLimit() {
		return numberLimit;
	}

	public int getNum() {
		return num;
	}

	public void setNum() {
		this.num = num + 1;
	}

}
