
import java.util.ArrayList;

public class NewDispatcher extends Dispatcher {
	private ArrayList<Integer> fl = new ArrayList<>();
	private ArrayList<String>  type = new ArrayList<>();
	private ArrayList<Float> ti = new ArrayList<>();
	private ArrayList<Integer> flag1 = new ArrayList<>();
	
	public NewDispatcher(){
		
	}
	
	public ArrayList<Integer> getFloor(){
		return fl;
	}
	
	public ArrayList<String> getType(){
		return type;
	}
	
	public ArrayList<Float> getTime(){
		return ti;
	}
	
	public ArrayList<Integer> getFlag(){
		return flag1;
	}
	
	public void dealRequest(Queue q){
		int m = q.getSize();
		
		for (int i = 0;i < m;i ++){
			if (i == 0){
				q.poll();
				passager.passagerIn();
				passager.getWaiting(0, 1);
				String str = "[FR,1,UP,0］／(1,STILL,1.0) waiting time: 1.0";
				fl.add(1);
				type.add("STILL");
				ti.add((float) 0);
				flag1.add(1);
				T.ocTime();
				message.add(str);
			} else {
				String req = q.poll();
				req = req.replace("(", "");
				req = req.replace(")", "");
				String request[] = req.split(",");
				int pre = l.getFloor();
				int cur = Integer.valueOf(request[1]);
				int flag = 0;
				String s = "";
				
				int difference = Math.abs(cur - l.getFloor());
				
				for (int j = 0;j < difference;j ++){
					if (cur - pre > 0){
						l.LiftUp();
						T.runTime();
						l.setType("UP");
						
						flag = incedental(q,cur);
						
						if (flag == 1 || flag == 2){
							m = m -1;
						}
					}else if (cur - pre < 0){
						l.LiftDown();
						T.runTime();
						l.setType("DOWN");
						flag = incedental(q,cur);
						
						if (flag == 1 || flag == 2){
							m = m -1;
						}
					}else {
						l.setType("STILL");
					}
				}
				if (flag == 3){
					i ++;
				}
				s = output(req);

				message.add(s);
			}
		}
	
	}
	
	public int incedental(Queue q,int per){
		int flag = 0;
		for (int i = 0;i < q.getSize();i ++){
			
			String str = q.getQueue(i);
			str = str.replace(")", "");
			str = str.replace("(", "");
			String[] req = str.split(",");
			int cur = Integer.valueOf(req[1]);
			if (req[0].equals("FR")){
				int reqTime = Integer.valueOf(req[3]);
				
				if (reqTime < T.getTime() && judgeD(req[2]) && cur < per){
					liftRun(Math.abs(cur - l.getFloor()));
					T.ocTime();
					String s;
					flag = 1;
					if (passager.overload()){
						passager.passagerIn();
						passager.getWaiting(reqTime, T.getTime());
						s = "[" + str + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ") wauting time: " + passager.getWritingTime();
						fl.add(cur);
						type.add(l.getType());
						ti.add(T.getTime() - 1);
						flag1.add(1);
					}else{
						s = "[" + str + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ")";
						fl.add(cur);
						type.add(l.getType());
						ti.add(T.getTime() - 1);
						flag1.add(1);
					}
					
					message.add(s);
					q.remove(i);
					i --;
				}
				
				
			}else if(req[0].equals("ER")){
				int reqTime = Integer.valueOf(req[2]);
				if (reqTime < T.getTime() && judgeF(per,cur) == 2 && judgeLiftStatus(per,cur) == 1){
					liftRun(Math.abs(cur - l.getFloor()));
					T.ocTime();
					flag = 2;
					passager.passagerOut();
					String s = "[" + str + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ")";
					fl.add(cur);
					type.add(l.getType());
					ti.add(T.getTime() - 1);
					flag1.add(0);
					message.add(s);
					q.remove(i);
					i --;
				}else if(reqTime <= T.getTime() && judgeF(per,cur) == 1){
					q.remove(i);
					q.add(0, str);
					flag = 3;
					break;
				}else if (reqTime < T.getTime() && judgeF(per,cur) == 1 && judgeLiftStatus(per,cur) == 2){
					liftRun(Math.abs(cur - l.getFloor()));
					T.ocTime();
					passager.passagerOut();
					String s = "[" + str + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ")";
					fl.add(cur);
					type.add(l.getType());
					ti.add(T.getTime() - 1);
					flag1.add(-1);
					message.add(s);
					q.remove(i);
					flag = 2;
					i --;
				}else if (reqTime <= T.getTime() && judgeF(per,cur) == 2 && judgeLiftStatus(per,cur) == 2){
					q.remove(i);
					q.add(0, str);
					flag = 3;
					break;
				}
				
			}
			
		}
		return flag;
	}
	
	public String output(String req){
		req = req.replace("(", "");
		req = req.replace(")", "");
		String request[] = req.split(",");
		int pre = l.getFloor();
		int cur = Integer.valueOf(request[1]);
		String s = "";
		switch (request[0]){
		case "FR" :
			float reqTime = Float.valueOf(request[3]);
			T.ocTime();
			if (passager.overload()){
				passager.passagerIn();
				passager.getWaiting(reqTime, T.getTime());
				s = "[" + req + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ") wauting time: " + passager.getWritingTime();
				fl.add(cur);
				type.add(l.getType());
				ti.add(T.getTime() - 1);
				flag1.add(1);
			}
			break;
		case "ER" :
			passager.passagerOut();
			T.ocTime();
			s = "[" + req + "]/(" + cur + "," + l.getType() + "," +T.getTime() + ")";
			fl.add(cur);
			type.add(l.getType());
			ti.add(T.getTime());
			flag1.add(-1);
			break;
		}
		return s;
	}
	
	public int judgeF(int per,int cur){
		if (cur > per){
			return 1;
		}else if (cur < per){
			return 2;
		}
		return 0;
	}
	
	public boolean judgeD(String str){
		return str.equals("UP") || str.equals("FR");
	}
	
	public int judgeLiftStatus(int cur,int per){//判断ER指令中方向是否一致
		if (cur > per && l.getType().equals("UP")){
			return 1;
		}else if (cur < per && l.getType().equals("DOWN")){
			return 2;
		}
		return 0;
	}
	
	public void liftRun(int diffence){
		if (l.getType().equals("UP")){
			for (int i = 0;i < diffence;i ++){
				l.LiftUp();
				T.runTime();
			}
			
		}else if (l.getType().equals("DOWN")){
			for (int i = 0;i < diffence;i ++){
				l.LiftDown();
				T.runTime();
			}

		}
	}

}
