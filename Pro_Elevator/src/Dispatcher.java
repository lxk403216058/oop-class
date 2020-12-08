
import java.util.ArrayList;

public class Dispatcher {
	protected Lift l = new Lift();
	protected float t = 0;
	protected Floor f;
	protected Time T = new Time();
	protected Passager passager = new Passager();
	protected ArrayList<String> message = new ArrayList<String>();

	public Dispatcher() {

	}

	public Dispatcher(Lift l) {
		this.l = l;
	}
	
	public Passager getPassager(){
		return passager;
	}
	
	public ArrayList<String> getMessage(){
		return message;
	}

	public float dealReqest(Queue q) {
		int flag = 0;
		float time = 0;
		int x = q.getSize();

		for (int i = 0; i < x; i++) {
			
			String req = q.poll();
			
			if (flag == 0) {
				String str = req.replace("(", "");
				str = str.replace(")", "");
				String[] request = str.split(",");
				
				int n = 0;
				float j = 0;

				switch (request[0]) {//����ʱ��
				case "FR":
					n = Integer.valueOf(request[1]);
					j = Float.valueOf(request[3]);
					f = new Floor(n, request[2], j);
					time = dispatcher(f.getDiffence(), j);
					f.setPerFloor(n);
					l.setFloor(n);
					String str1 = "(" + request[1] + "," + l.getType() + "," + time + ")";
					message.add(str1);
					break;
				case "ER":
					n = Integer.valueOf(request[1]);
					j = Float.valueOf(request[2]);
					l = new Lift(n, j);
					time = dispatcher(l.getDiffence(), j);
					l.setFloor(n);
				    str1 ="(" + request[1] + "," + l.getType() + "," + time + ")";
				    message.add(str1);
					break;
				}
			}
		}
		return time;

	}

	public float dispatcher(int floorDiffence, float time) {//����ʱ��
		t = setTime(T.getTime(), time);

		t = t + (float) (floorDiffence * 0.5);
		T.setTime(t + 1);

		return t;
	}

	public float setTime(float time, float t) {
		if (t > time) {
			time = t;
		}

		return time;
	}

}

