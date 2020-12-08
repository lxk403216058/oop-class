package three_exercise;

public class Mytime {
	
	private int hour;         
	private int minute;
	private String nowTime = "8:00";
	public Mytime(){
		this.hour = 8;
		this.minute = 0;
	}
	public String Go(int minute) {
		this.minute += minute;
		if(this.minute >= 60) {
			this.hour++;
			this.minute -= 60;
		}
		if(this.minute < 10) {
			this.nowTime = this.hour + ":0" + this.minute;
		}else {
			this.nowTime = this.hour + ":" + this.minute;
		}
		return this.nowTime;
	}
	
	
	public String toString() {
		return this.nowTime;
	}
	
}
