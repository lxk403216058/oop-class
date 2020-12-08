
public class Timec {
	private static String time = "8:00";
	
	public Timec(){
		
	}
	
	public void change(int t){
		String[] str = time.split(":");
		int o = 0;
		int m = 0;
		
		if ((Integer.valueOf(str[str.length - 1]) + t) >= 60){
			o = Integer.valueOf(str[0]) + 1;
			m = Integer.valueOf(str[str.length-1]) + t - 60;
		}else{
			o = Integer.valueOf(str[0]);
			m = Integer.valueOf(str[str.length-1]) + t;
		}
		
		if (m < 10){
			time = o + ":0" + m; 
		}else{
			time = o + ":" + m;
		}
	}
	
	public String toString(){
		return time + "     ";
	}

}
