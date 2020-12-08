
public class Lift {
	private static int flor = 1;
	private double runtime = 0.0;
	private static String state = "STILL";

	public Lift() {

	}

	public void Run(String str[]) {// 一条有效请求执行一次
		if (Integer.valueOf(str[1]) > flor) {
			state = "UP";
		} else if (Integer.valueOf(str[1]) < flor) {
			state = "DOWN";
		} else {
			state = "STILL";
		}
		runtime = 0.5 * Math.abs(Integer.valueOf(str[1]) - flor);
		flor = Integer.valueOf(str[1]);

	}
	 public void Init(){//初始化数值，因为agent中检查使用了此类的静态属性
		 this.flor =1;
		 this.state = "STILL";
	 }
//访问器
	public int getFlor() {
		return flor;
	}

	public double getTime() {
		return runtime;
	}

	public String getState() {
		return state;
	}
//修改器
	public void  setFlor(int flor){
		this.flor = flor;
	}
	
	public void setState(String state){
		this.state = state;
	}
}
