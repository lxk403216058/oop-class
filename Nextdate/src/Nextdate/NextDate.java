package Nextdate;

public class NextDate {
	private int year;
	private int month;
	private int day;

	
	public NextDate() {
		
	}
	
	public NextDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public boolean judgeLeapyear() {
		return year%400 == 0 || (year%4==0 && year%100 == 0);
	}


	public void nextdate() {
		if (year > 1600 && year < 2100) {
			switch (month) {
			case 2:
				if (judgeLeapyear()) {
					if (day == 29) {
						this.month = month + 1;
						this.day = 1;
					}else {
						this.day = day + 1;
					}
				}else {
					if (day == 28) {
						this.month = month + 1;
						this.day = 1;
					} else {
						this.day = day + 1;
					}
				}
				System.out.println("NextDate [year=" + year + ", month=" + month + ", day=" + day + "]"); 
				break;
			case 1: case 3: case 5: case 7: case 8: case 10:
				if (day == 31) {
					this.month = month + 1;
					this.day = 1;
				}else {
					this.day = day + 1;
				}
				System.out.println("NextDate [year=" + year + ", month=" + month + ", day=" + day + "]");
				break;
			case 4: case 6: case 9: case 11:
				if (day == 30) {
					this.month = month + 1;
					this.day = 1;
				}else {
					this.day = day + 1;
				}
				System.out.println("NextDate [year=" + year + ", month=" + month + ", day=" + day + "]");
				break;
			case 12:
				if (day == 31) {
					this.year = year + 1;
					this.month = 1;
					this.day = 1;
				}else {
					this.day = day + 1;
				}
				System.out.println("NextDate [year=" + year + ", month=" + month + ", day=" + day + "]");
				break;
			default:
				System.out.println("月份输入不合法");
				break;
			}
		}else {
			System.out.println("输入年份小于1600或大于2000");
		}
		
	}

	@Override
	public String toString() {
		return "NextDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
