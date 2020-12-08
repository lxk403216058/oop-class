public class NextDate {

	
	public NextDate() {
		
	}
	
	public boolean judgeLeapyear(int year) {
		return year%400 == 0 || (year%4==0 && year%100 == 0);
	}


	public String nextdate(int year,int month,int day) {
		if (year>2100||year<1600||month>12||month<1||day>31||day<1) {
			return "输入日期非法";
		}
		switch (month) {
		case 2:
			if (judgeLeapyear(year)) {
				if (day == 29) {
					month = month + 1;
					day = 1;
				}else {
					day = day + 1;
				}
			}else {
				if (day == 28) {
					month = month + 1;
					day = 1;
				} else if (day<28){
					day = day + 1;
				}else {
					return "输入日期非法";
				}
			}
			return year+" "+month+" "+day;
		case 1: case 3: case 5: case 7: case 8: case 10:
			if (day == 31) {
				month = month + 1;
				day = 1;
			}else {
				day = day + 1;
			}
			return year+" "+month+" "+day;
		case 4: case 6: case 9: case 11:
			if (day == 30) {
				month = month + 1;
				day = 1;
			}else if (day<31){
				day = day + 1;
			}else {
				return "输入日期非法";
			}
			return year+" "+month+" "+day;
		case 12:
			if (day == 31) {
				year = year + 1;
				month = 1;
				day = 1;
			}else {
				day = day + 1;
			}
			return year+" "+month+" "+day;
		default:
			return "输入日期非法";
		}
		
	}

}
