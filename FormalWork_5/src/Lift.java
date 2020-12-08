
public class Lift {
	private static int flor = 1;
	private double runtime = 0.0;
	private static String state = "STILL";

	public Lift() {

	}

	public void Run(String str[]) {// һ����Ч����ִ��һ��
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
	 public void Init(){//��ʼ����ֵ����Ϊagent�м��ʹ���˴���ľ�̬����
		 this.flor =1;
		 this.state = "STILL";
	 }
//������
	public int getFlor() {
		return flor;
	}

	public double getTime() {
		return runtime;
	}

	public String getState() {
		return state;
	}
//�޸���
	public void  setFlor(int flor){
		this.flor = flor;
	}
	
	public void setState(String state){
		this.state = state;
	}
}
