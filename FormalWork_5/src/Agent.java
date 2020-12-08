import java.util.ArrayList;

public class Agent {
	String fileName = "output.txt";
	protected static double time = 0.0;
	protected String output = "";
	protected Lift lift = new Lift();
	protected Judge isValid = new Judge();
	protected ArrayList<String[]> str = new ArrayList<String[]>();
	protected String[] RunorNot;
	int flag = 0;
	ArrayList<String[]> commandstr = new ArrayList<String[]>();
	int n1 = 0;
	int n = 0;

	public Agent(Request request) {// �вι��췽������Ҫִ�е�����ԭ��arraylist��
		int n = request.getSize();
		for (int i = 0; i < n - 1; i++) {
			String commands[] = request.getRequest();

			this.str.add(commands);

			if (i > 0 && isValid.init() && isValid.JudgeValue(commands))
				check1(commands);
		}
		this.n = commandstr.size();
		RunorNot = request.getRequest();
	}

	protected void outPut() {
		if (lift.getState().equals("STILL")) {
			output += "(" + lift.getFlor() + "," + lift.getState() + "," + time + ")\r\n";
		} else {
			output += "(" + lift.getFlor() + "," + lift.getState() + "," + (time - 1) + ")\r\n";
		}
	}

	protected void outPut(String command[]) {
		if (command.length == 4) {
			output += "ERROR\r\n#" + command[0] + "," + command[1] + "," + command[2] + "," + command[3] + "\r\n";
		} else if (command.length == 3) {
			output += "ERROR\r\n#" + command[0] + "," + command[1] + "," + command[2] + "\r\n";
		} else {
			String str = "";
			for (int m = 0; m < command.length; m++) {
				str += command[m];
			}
			output += "ERROR\r\n#" + str + "\r\n";
		}
	}

	public void Start() {// ����ʼ����
		lift.Init();
		// System.out.println(str.size());
		if (!RunorNot[0].equals("RUN")) {
			System.out.println("ȱ��ִ�����:RUN");
			System.exit(0);
		} else {
			for (int i = 0; i < str.size(); i++) {
				String command[] = str.get(i);

				if (flag == 0 && isValid.init() && isValid.JudgeValue(command) && check2(command)) {// �ҵ����ϵĵ�һ����ִ������
					flag = 1;
					run(command);
					outPut();
				} else if (flag == 1 && isValid.init() && isValid.JudgeValue(command)) {// �����������������в������
					run(command);
					outPut();
				} else if (str.get(i).length == 2 && str.get(i)[0].equals("not") && str.get(i)[1].equals("Addhere")) {
					if (n1 < n ) {
						outPut(commandstr.get(n1));
						n1++;
					}
				} else {
					outPut(command);
				}
			}
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
			if (command.length == 4 && command1.length == 4 && Double.parseDouble(command[3].replace(")", "")) < Double
					.parseDouble(command1[3].replace(")", ""))) {
				// outPut(command);
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 3 && command1.length == 3 && Double.parseDouble(command[2].replace(")", "")) < Double
					.parseDouble(command1[2].replace(")", ""))) {
				// outPut(command);
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 3 && command1.length == 4 && Double.parseDouble(command[2].replace(")", "")) < Double
					.parseDouble(command1[3].replace(")", ""))) {
				// outPut(command);
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 4 && command1.length == 3 && Double.parseDouble(command[3].replace(")", "")) < Double
					.parseDouble(command1[2].replace(")", ""))) {
				// outPut(command);
				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}

			// ���й����º���
			lift.Run(command);
			if (command.length == 4 && command1.length == 4 && command1[2].equals(command[2])
					&& Double.parseDouble(command[3].replace(")", ""))
							- Double.parseDouble(command1[3].replace(")", "")) <= lift.getTime() + 1) {

				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
			if (command.length == 3 && command1.length == 3 && command1[1].equals(command[1])
					&& Double.parseDouble(command[2].replace(")", ""))
							- Double.parseDouble(command1[2].replace(")", "")) <= lift.getTime() + 1) {

				String[] Strs = { "not", "Addhere" };
				commandstr.add(command);
				str.set(str.size() - 1, Strs);
				break;
			}
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
		boolean value = true;

		if (temp.length == 4 && (!temp[3].equals("0)") || !temp[2].equals("UP"))) {
			System.out.println("����ִ�еĵ�һ�������������ݴ��󣬳�����ֹ");
			System.exit(1);
		}
		if (temp.length == 3 && (!temp[2].equals("0)"))) {
			System.out.println("����ִ�еĵ�һ�������������ݴ��󣬳�����ֹ");
			System.exit(1);
		}

		return value;
	}

}
