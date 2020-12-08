import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Agent_1 extends Agent {
	String tempstr[];
	protected ArrayList<String[]> str1 = new ArrayList<String[]>();
	int amount = 0;
	ArrayList<Double> waitime =new ArrayList();
	ArrayList<String> liftcommand = new ArrayList();
	
	public Agent_1(Request request) {// �вι��췽������Ҫִ�е�����ԭ��arraylist��
		super(request);
	}

	protected void outPut(String command[], double temptime) {
		if(amount == 14){
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
			amount--;
		}
		output += "[" + command[0].replace("(", "");
		liftcommand.add(command[0]);
		liftcommand.add(command[1]);
		
		
		for (int j = 1; j < command.length; j++) {
			output += "," + command[j].replace(")", "");
		}
		liftcommand.add(lift.getState());
		output += "]/(" + lift.getFlor() + "," + lift.getState() + "," + temptime + ")\r\n";
		
	}

	protected void outPut1(String command[]) {
		if (command.length == 4) {
			output += "INVALID[" + command[0].replace("(", "") + "," + command[1] + "," + command[2] + ","
					+ command[3].replace(")", "") + "]\r\n";
		} else if (command.length == 3) {
			output += "INVALID[" + command[0].replace("(", "") + "," + command[1] + "," + command[2].replace(")", "")
					+ "]\r\n";
		} else {
			String str = "";
			for (int m = 0; m < command.length - 1; m++) {
				str += command[m] + ",";
			}
			str += command[command.length - 1];
			output += "INVALID[" + str.replace("(", "").replace(")", "") + "]\r\n";
		}
	}

	protected void outPut2(String command[]) {
		if (command.length == 4) {
			output += "SAME[" + command[0].replace("(", "") + "," + command[1] + "," + command[2] + ","
					+ command[3].replace(")", "") + "]\r\n";
		} else if (command.length == 3) {
			output += "SAME[" + command[0].replace("(", "") + "," + command[1] + "," + command[2].replace(")", "")
					+ "]\r\n";
		} else {
			String str = "";
			for (int m = 0; m < command.length; m++) {
				str += command[m];
			}
			output += "SAME[" + str.replace("(", "").replace(")", "") + "]\r\n";
		}
	}

	public void Start() {// ����ʼ����
		lift.Init();
		this.n = commandstr.size();
		if (!RunorNot[0].equals("RUN")) {
			System.out.println("ȱ��ִ�����:RUN");
			System.exit(0);
		} else {
			for (int i = 0; i < str.size(); i++) {// �����Ϸ�����Ӧ�ú��Ե������
				String command[] = str.get(i);
				if (flag == 0 && isValid.init() && isValid.JudgeValue(command) && check2(command)) {// �ҵ����ϵĵ�һ����ִ������
					flag = 1;
					str1.add(command);
				} else if (flag == 1 && isValid.init() && isValid.JudgeValue(command)) {// �����������������в������
					str1.add(command);
				} else if (str.get(i).length == 2 && str.get(i)[0].equals("not") && str.get(i)[1].equals("Addhere")) {
					if (n1 < n) {
						outPut1(commandstr.get(n1));
						n1++;
					}
				} else if (str.get(i).length == 2 && str.get(i)[0].equals("addhere") && str.get(i)[1].equals("SAME")) {
					if (n1 < n) {
						outPut2(commandstr.get(n1));
						n1++;
					}
				} else {
					outPut1(command);
				}
			}
			double temptime;
			while (str1.size() > 0) {
					String[] command = str1.get(0);
					
					if(command.length==4&&amount < 14){
						amount ++;
					}else if(command.length==3){
						amount --;
					}
					double time1 = time;
					int flor = lift.getFlor();// ���ڻ�ԭ
					String state = lift.getState();// ���ڻ�ԭ
					run(command);

					String state1 = lift.getState();// ���ݵ�����������ʱ�����ķ���,���Ӵ��ķ���
					double time2 = time;// time2Ϊ�����κδ����������Ԥ����ɵ�ʱ��

					lift.setFlor(flor);// ��ԭ����״̬
					lift.setState(state);
					time = time1;// ��ԭʱ��

					temptime = time;// ����ģ���������ʱ��ʱ������
					str1.remove(0);// ���str2.add(command)
				// ���ݰ�������command�ķ���ʼһ�������,ÿ�㶼����һ��str1,���str1��������:���е�ĳ��ʱ,�ò��ǰ��ͬ����¥�������
				// ����ʱ��С�ڴ�ʱʱ��,����ǰ����¥����ڴ�ʱ��������¥�㣬����С�ڵ����������¥��(��������ʱ),���¥��������Ӵ�.
				// ���ڵ����ڵ�����Ӧ����:�����ݼ����ش˷������пɵִ����������ʱ��ӦС�ھ�������֮���Ԥ��ʱ��-1
				// ʵ�ֵ���һ�������:run((ER,lift.getflor+/-1,time-1))

				while (lift.getFlor() != Double.parseDouble(command[1])) {// ���е��������¥��Ϊֹ
					if (state1.equals("UP")) {// ���������������
						String[] command2 = { "(ER", "" + (lift.getFlor() + 1), "" + time + ")" };// ģ����������ƶ�һ¥\������
						run(command2);
						temptime += 0.5;
						time = temptime;
						// ������һ��ͱ���һ�����������
						int flag1 = 0;
						for (int i = 0; i < str1.size(); i++) {
							String command1[] = str1.get(i);
							if (command1.length == 4 && command1[2].equals("UP")
									&& lift.getFlor() == Double.parseDouble(command1[1])
									&& Double.parseDouble(command1[3].replace(")", "")) < temptime) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// ��ʵʱ��
									time2++;// ÿ�Ӵ�һ��¥������,Ԥ����������ʱ�̾ͻ��1
									if(amount<14){
										amount ++;
									}
									waitime.add(temptime - Double.parseDouble(command1[3].replace(")", "")));
									outPut(command1, temptime);
									
									str1.remove(i);
									i--;
								} else {
									if(amount<14){
										amount ++;
									}
									outPut(command1, temptime);
									waitime.add(temptime - Double.parseDouble(command1[3].replace(")", "")));

									str1.remove(i);
									i--;
								}
							}
							if (command1.length == 3 && Double.parseDouble(command1[2].replace(")", "")) < temptime
									&& Double.parseDouble(command1[1]) == lift.getFlor()) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// ��ʵʱ��
									time2++;// ÿ�Ӵ�һ��¥������,Ԥ����������ʱ�̾ͻ��1
									amount --;
									outPut(command1, temptime);

									str1.remove(i);
									i--;
								} else {
									amount --;
									outPut(command1, temptime);
									str1.remove(i);
									i--;
								}
							}
							if (command1.length == 3 && Double.parseDouble(command1[2].replace(")", "")) < time2
									&& Double.parseDouble(command1[1]) > Double.parseDouble(command[1])) {
								int flor11 = lift.getFlor();// ���ڻ�ԭ
								double temptime1 = time;

								time += (Integer.parseInt(command1[1]) - lift.getFlor()) * 0.5 + 1;

								time2 = time;// �µ�Ԥ�����ʱ��
								time = temptime1;
								lift.setFlor(flor11);

								String tempcommand[] = command1;
								str1.set(i, command);
								command = tempcommand;
							}
						}
					} else if (state1.equals("DOWN")) {// ���������������
						String[] command2 = { "(ER", "" + (lift.getFlor() - 1), "" + time + ")" };// ģ����������ƶ�һ¥\������
						run(command2);
						temptime += 0.5;
						time = temptime;
						// ������һ��ͱ���һ�����������
						int flag1 = 0;
						for (int i = 0; i < str1.size(); i++) {
							String command1[] = str1.get(i);
							if (command1.length == 4 && command1[2].equals("DOWN")
									&& lift.getFlor() == Double.parseDouble(command1[1])
									&& Double.parseDouble(command1[3].replace(")", "")) < temptime) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// ��ʵʱ��
									time2++;// ÿ�Ӵ�һ��¥������,Ԥ����������ʱ�̾ͻ��1
									if(amount<14){
										amount ++;
									}
									outPut(command1, temptime);
									waitime.add(temptime - Double.parseDouble(command1[3].replace(")", "")));

									str1.remove(i);
									i--;
								} else {
									if(amount<14){
										amount ++;
									}
									outPut(command1, temptime);
									waitime.add(temptime - Double.parseDouble(command1[3].replace(")", "")));

									str1.remove(i);
									i--;
								}
							}
							if (command1.length == 3 && Double.parseDouble(command1[2].replace(")", "")) < temptime
									&& Double.parseDouble(command1[1]) == lift.getFlor()) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// ��ʵʱ��
									time2++;// ÿ�Ӵ�һ��¥������,Ԥ����������ʱ�̾ͻ��1
									amount --;
									outPut(command1, temptime);

									str1.remove(i);
									i--;
								} else {
									amount --;
									outPut(command1, temptime);
									str1.remove(i);
									i--;
								}
							}
							if (command1.length == 3 && Double.parseDouble(command1[2].replace(")", "")) < time2
									&& Double.parseDouble(command1[1]) < Double.parseDouble(command[1])) {
								int flor11 = lift.getFlor();// ���ڻ�ԭ
								double temptime1 = time;

								time += (lift.getFlor() - Integer.parseInt(command1[1])) * 0.5 + 1;

								time2 = time;// �µ�Ԥ�����ʱ��
								time = temptime1;
								lift.setFlor(flor11);

								String tempcommand[] = command1;
								str1.set(i, command);
								command = tempcommand;
							}
						}
					}
				}
				time = time2;
				outPut(command, time2);
				if(command.length==4){
					waitime.add(temptime - Double.parseDouble(command[3].replace(")", "")));
				}
			}
			
			output+="�����ݵ���˿͵�˳����������ȴ�ʱ�䣨���س˿�Ҳ�ȴ��ˣ�:\r\n";
			double sum = 0;
			for(int i = 0;i<waitime.size();i++){
				output+=waitime.get(i)+"\r\n";
				sum +=waitime.get(i);
			}
			output+="ƽ���ȴ�ʱ�䣺"+sum/waitime.size();
			
		}
	}

	public void SaveOutput() {// ���ô����ļ��еķ����������
		Save save = new Save(fileName, output.trim());
		save.save();
	}

	protected void run(String[] command) {// ���е���

		lift.Run(command);
		if (command.length == 4 && Double.parseDouble(command[3].replace(")", "")) <= time)
			time += lift.getTime() + 1;
		if (command.length == 3 && Double.parseDouble(command[2].replace(")", "")) <= time)
			time += lift.getTime() + 1;
		if (command.length == 4 && Double.parseDouble(command[3].replace(")", "")) > time)
			time = Double.parseDouble(command[3].replace(")", "")) + lift.getTime() + 1;
		if (command.length == 3 && Double.parseDouble(command[2].replace(")", "")) > time)
			time = Double.parseDouble(command[2].replace(")", "")) + lift.getTime() + 1;
	}

	protected void check1(String[] command) {// �滻Ӧ������������,�ܿ���
		for (int i = str.size() - 2; i > 0; i--) {
			Lift lift = new Lift();
			String command1[] = str.get(i);

			// ʱ��˳��ͬ��Ҫ����
			if ((str.get(i).length == 3 || str.get(i).length == 4)
					&& Double.parseDouble(command[command.length - 1].replace(")", "")) < Double
							.parseDouble(str.get(i)[str.get(i).length - 1].replace(")", ""))) {
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}

			// ���й����º���,(ͬ������)
			lift.Run(command);
			if (command.length == 4 && command1.length == 4 && command1[1].equals(command[1])
					&& command1[2].equals(command[2]) && Double.parseDouble(command[3].replace(")", ""))
							- Double.parseDouble(command1[3].replace(")", "")) <= lift.getTime() + 1) {

				String[] Strs = { "addhere", "SAME" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 3 && command1.length == 3 && command1[1].equals(command[1])
					&& Double.parseDouble(command[2].replace(")", ""))
							- Double.parseDouble(command1[2].replace(")", "")) <= lift.getTime() + 1) {

				String[] Strs = { "addhere", "SAME" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}

			// ���಻�Ϸ�
			if (command.length == 4 && command[1].equals("1") && !command[2].equals("UP")) {
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 4 && command[1].equals("10") && !command[2].equals("DOWN")) {
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
		}
	}

	protected boolean check2(String[] temp) {// ���ҵ�����ִ�еĵ�һ������
		if (temp[0].equals("(FR") && temp[3].equals("0)") && temp[2].equals("UP") && temp[1].equals("1")) {
			return true;
		}
		System.out.println("����ִ�еĵ�һ�������������ݴ��󣬳�����ֹ");
		System.exit(1);
		return false;
	}
	public ArrayList<String> getcommand(){
		return this.liftcommand;
	}
}
