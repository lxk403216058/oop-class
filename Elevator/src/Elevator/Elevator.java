package Elevator;

import java.util.ArrayList;

public class Elevator {
	public static void main(String[] args) {
		String fileName1 = "request.txt";
		String fileName2 = "result.txt";
		RequestIn r = new RequestIn(fileName1);
		ArrayList<Integer> positionE = new ArrayList<Integer>();// �����ʽ����ָ���λ��
		ArrayList<Integer> positionR = new ArrayList<Integer>();// ����ָ��ʱ������λ��
		ArrayList<String> message = new ArrayList<String>();// �洢������Ϣ
		r.dataIn();
		Check c = new Check();
		Request req = new Request();

		if (!r.getExpression().get(r.getExpression().size() - 1).equals("RUN")) {// ������һ��ָ���RUN������˳�
			//System.out.println("gg");
			System.exit(0);
		}

		for (int i = 0; i < r.getExpression().size() - 1; i++) {
			if (!c.check(r.getExpression().get(i))) {// ��ָ����и�ʽ�жϲ���������λ��
				r.getExpression().remove(i);
				message.add(c.toString());
				positionE.add(i);
				i--;
			}
		}

		for (int i = 0; i < r.getExpression().size(); i++) {
			if (!req.checkRepeat(r.getExpression().get(i))) {// �Ը�ʽ��ȷ��ʱ�䲻��ȷ��ָ������жϲ���סλ��
				positionR.add(i);
			}
		}

		Queue q = new Queue();
		for (int i = 0; i < req.getStr().size(); i++) {// ��������ȷָ�����
			String[] s = req.getStr().get(0).split(",");
			String s1 = s[s.length - 1].replace(")", "");
			if (s1 == "0") {
				System.exit(0);
			}
			q.add(req.getStr().get(i));
		}
		Dispatcher d = new Dispatcher();

		d.dealReqest(q);// ��������ָ��ʱ�䲢���
		FileIn f = new FileIn(fileName2);
		int n = 0;

		for (int i = 0; i < r.getExpression().size(); i++) {
			int flag = 0;
			for (int j = 0; j < positionE.size(); j++) {
				if (positionE.get(j) == i) {// ��������ʽ��ָ��
					f.dataOut(message.get(j));
					flag = 1;
					break;
				}
			}

			for (int j = 0; j < positionR.size(); j++) {
				if (positionR.get(j) == i) {// �����ָ���ʽ��ȷ��ʱ�䲻��ȷ�Ĵ���ָ��
					flag = 1;
					break;
				}
			}
			if (flag == 0) {// �����ȷ����
				f.dataOut(d.getMessage().get(n++));
			}
		}
	}
}
