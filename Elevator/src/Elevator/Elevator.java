package Elevator;

import java.util.ArrayList;

public class Elevator {
	public static void main(String[] args) {
		String fileName1 = "request.txt";
		String fileName2 = "result.txt";
		RequestIn r = new RequestIn(fileName1);
		ArrayList<Integer> positionE = new ArrayList<Integer>();// 储存格式错误指令的位置
		ArrayList<Integer> positionR = new ArrayList<Integer>();// 储存指令时序错误的位置
		ArrayList<String> message = new ArrayList<String>();// 存储错误信息
		r.dataIn();
		Check c = new Check();
		Request req = new Request();

		if (!r.getExpression().get(r.getExpression().size() - 1).equals("RUN")) {// 如果最后一个指令不是RUN则程序退出
			//System.out.println("gg");
			System.exit(0);
		}

		for (int i = 0; i < r.getExpression().size() - 1; i++) {
			if (!c.check(r.getExpression().get(i))) {// 对指令进行格式判断并储存所在位置
				r.getExpression().remove(i);
				message.add(c.toString());
				positionE.add(i);
				i--;
			}
		}

		for (int i = 0; i < r.getExpression().size(); i++) {
			if (!req.checkRepeat(r.getExpression().get(i))) {// 对格式正确但时间不正确德指令进行判断并记住位置
				positionR.add(i);
			}
		}

		Queue q = new Queue();
		for (int i = 0; i < req.getStr().size(); i++) {// 将所有正确指令入队
			String[] s = req.getStr().get(0).split(",");
			String s1 = s[s.length - 1].replace(")", "");
			if (s1 == "0") {
				System.exit(0);
			}
			q.add(req.getStr().get(i));
		}
		Dispatcher d = new Dispatcher();

		d.dealReqest(q);// 计算所有指令时间并输出
		FileIn f = new FileIn(fileName2);
		int n = 0;

		for (int i = 0; i < r.getExpression().size(); i++) {
			int flag = 0;
			for (int j = 0; j < positionE.size(); j++) {
				if (positionE.get(j) == i) {// 输出错误格式的指令
					f.dataOut(message.get(j));
					flag = 1;
					break;
				}
			}

			for (int j = 0; j < positionR.size(); j++) {
				if (positionR.get(j) == i) {// 输出对指令格式正确但时间不正确的错误指令
					flag = 1;
					break;
				}
			}
			if (flag == 0) {// 输出正确内容
				f.dataOut(d.getMessage().get(n++));
			}
		}
	}
}
