import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Agent_1 extends Agent {
	String tempstr[];
	protected ArrayList<String[]> str1 = new ArrayList<String[]>();
	int amount = 0;
	ArrayList<Double> waitime =new ArrayList();
	ArrayList<String> liftcommand = new ArrayList();
	
	public Agent_1(Request request) {// 有参构造方法，将要执行的请求还原到arraylist中
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

	public void Start() {// 程序开始运行
		lift.Init();
		this.n = commandstr.size();
		if (!RunorNot[0].equals("RUN")) {
			System.out.println("缺少执行语句:RUN");
			System.exit(0);
		} else {
			for (int i = 0; i < str.size(); i++) {// 将不合法的与应该忽略的先输出
				String command[] = str.get(i);
				if (flag == 0 && isValid.init() && isValid.JudgeValue(command) && check2(command)) {// 找到符合的第一个可执行请求
					flag = 1;
					str1.add(command);
				} else if (flag == 1 && isValid.init() && isValid.JudgeValue(command)) {// 符合条件的请求运行并且输出
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
					int flor = lift.getFlor();// 用于还原
					String state = lift.getState();// 用于还原
					run(command);

					String state1 = lift.getState();// 电梯的主请求运行时产生的方向,可捎带的方向
					double time2 = time;// time2为不经任何处理的主请求预期完成的时刻

					lift.setFlor(flor);// 还原电梯状态
					lift.setState(state);
					time = time1;// 还原时间

					temptime = time;// 用于模拟电梯运行时的时间流逝
					str1.remove(0);// 最后str2.add(command)
				// 电梯按主请求command的方向开始一层层运行,每层都遍历一次str1,如果str1中有满足:运行到某层时,该层的前往同方向楼层请求的
				// 产生时刻小于此时时刻,并且前往的楼层大于此时电梯所在楼层，并且小于等于主请求的楼层(电梯向上时),则此楼层请求可捎带.
				// 对于电梯内的请求应满足:若电梯继续沿此方向运行可抵达且请求产生时刻应小于经过处理之后的预期时刻-1
				// 实现电梯一层层运行:run((ER,lift.getflor+/-1,time-1))

				while (lift.getFlor() != Double.parseDouble(command[1])) {// 运行到主请求的楼层为止
					if (state1.equals("UP")) {// 电梯逐层向上运行
						String[] command2 = { "(ER", "" + (lift.getFlor() + 1), "" + time + ")" };// 模拟产生向上移动一楼\的请求
						run(command2);
						temptime += 0.5;
						time = temptime;
						// 运行了一层就遍历一遍待测试请求
						int flag1 = 0;
						for (int i = 0; i < str1.size(); i++) {
							String command1[] = str1.get(i);
							if (command1.length == 4 && command1[2].equals("UP")
									&& lift.getFlor() == Double.parseDouble(command1[1])
									&& Double.parseDouble(command1[3].replace(")", "")) < temptime) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// 真实时间
									time2++;// 每捎带一个楼层请求,预期完成请求的时刻就会加1
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
									time++;// 真实时间
									time2++;// 每捎带一个楼层请求,预期完成请求的时刻就会加1
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
								int flor11 = lift.getFlor();// 用于还原
								double temptime1 = time;

								time += (Integer.parseInt(command1[1]) - lift.getFlor()) * 0.5 + 1;

								time2 = time;// 新的预期完成时间
								time = temptime1;
								lift.setFlor(flor11);

								String tempcommand[] = command1;
								str1.set(i, command);
								command = tempcommand;
							}
						}
					} else if (state1.equals("DOWN")) {// 电梯逐层向下运行
						String[] command2 = { "(ER", "" + (lift.getFlor() - 1), "" + time + ")" };// 模拟产生向下移动一楼\的请求
						run(command2);
						temptime += 0.5;
						time = temptime;
						// 运行了一层就遍历一遍待测试请求
						int flag1 = 0;
						for (int i = 0; i < str1.size(); i++) {
							String command1[] = str1.get(i);
							if (command1.length == 4 && command1[2].equals("DOWN")
									&& lift.getFlor() == Double.parseDouble(command1[1])
									&& Double.parseDouble(command1[3].replace(")", "")) < temptime) {
								if (flag1 == 0) {
									flag1++;
									temptime++;
									time++;// 真实时间
									time2++;// 每捎带一个楼层请求,预期完成请求的时刻就会加1
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
									time++;// 真实时间
									time2++;// 每捎带一个楼层请求,预期完成请求的时刻就会加1
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
								int flor11 = lift.getFlor();// 用于还原
								double temptime1 = time;

								time += (lift.getFlor() - Integer.parseInt(command1[1])) * 0.5 + 1;

								time2 = time;// 新的预期完成时间
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
			
			output+="按电梯到达乘客的顺序依次输出等待时间（超载乘客也等待了）:\r\n";
			double sum = 0;
			for(int i = 0;i<waitime.size();i++){
				output+=waitime.get(i)+"\r\n";
				sum +=waitime.get(i);
			}
			output+="平均等待时间："+sum/waitime.size();
			
		}
	}

	public void SaveOutput() {// 调用存入文件中的方法保存输出
		Save save = new Save(fileName, output.trim());
		save.save();
	}

	protected void run(String[] command) {// 运行电梯

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

	protected void check1(String[] command) {// 替换应忽略请求条件,很苛刻
		for (int i = str.size() - 2; i > 0; i--) {
			Lift lift = new Lift();
			String command1[] = str.get(i);

			// 时间顺序不同需要忽略
			if ((str.get(i).length == 3 || str.get(i).length == 4)
					&& Double.parseDouble(command[command.length - 1].replace(")", "")) < Double
							.parseDouble(str.get(i)[str.get(i).length - 1].replace(")", ""))) {
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}

			// 运行规则下忽略,(同质请求)
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

			// 其余不合法
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

	protected boolean check2(String[] temp) {// 查找到电梯执行的第一个请求
		if (temp[0].equals("(FR") && temp[3].equals("0)") && temp[2].equals("UP") && temp[1].equals("1")) {
			return true;
		}
		System.out.println("电梯执行的第一条命令输入内容错误，程序终止");
		System.exit(1);
		return false;
	}
	public ArrayList<String> getcommand(){
		return this.liftcommand;
	}
}
