
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Animal> a = new ArrayList<Animal>();
		PlaybillIn play = new PlaybillIn();
		play.dataIn();
		Timec t = new Timec();
		Mermaid m = new Mermaid();
		RandomList r = new RandomList();
		r.ListIn();

		a.add(new ClownFish());// 10002
		a.add(new Crocodile());// 30000
		a.add(new Dolphin());// 20001
		a.add(new Lizard());// 30001
		a.add(new SeaLion());// 20000
		a.add(new Seals());// 20002
		a.add(new Shark());// 10001
		a.add(new Volador());// 10000

		if (play.getExpression().get(0).equals("show prepare")) {
			System.out.println(t.toString() + "�����ſ�ʼ׼��");
			for (int j = 0; j < 9; j++) {
				Scanner input = new Scanner(System.in);
				String enter = input.nextLine();
				String[] str = enter.split(" ");
				int flag = Integer.valueOf(str[0]);

				if (flag == 90000) {
					t.change(m.getReadyTime());
					System.out.println(t.toString() + "������׼�����");
				} else {
					for (int i = 0; i < a.size(); i++) {

						if (flag == a.get(i).number) {
							t.change(a.get(i).feedTime);
							a.get(i).isFeeded = true;
							System.out.println(t.toString() + a.get(i).type + "ιʳ���");
						}

					}
				}

			}
			
			int flag = 0;
			
			for (int i = 0; i < a.size(); i++) {
				if (!a.get(i).isFeeded) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 0) {
				System.out.println(t.toString() + "���еĶ���ιʳ��ϣ�������Ҳ׼����ϣ������볡");
			} else {
				System.exit(0);
			}
			if (play.getExpression().get(1).equals("entrance start")) {
				t.change(3);
				System.out.println(t.toString() + "���ڿ�ʼ�볡");
			}
			if (play.getExpression().get(2).equals("entrance end")) {
				int l = (int) (Math.random() * 10 + 1);
				t.change(l);
				System.out.println(t.toString() + "�����볡��ϣ����ݼ�����ʼ�����ҸϿ�����");
			}
			t.change(5);
			System.out.println(t.toString() + "��λ���ڣ���ӭ��ҵĵ��������ݼ�����ʼ");

			for (int i = 3; i < a.size() + 3; i++) {
				String[] sp = play.getExpression().get(i).split(" ");
				int f = Integer.valueOf(sp[0]);
				for (int j = 0; j < a.size(); j++) {
					  if (f == a.get(j).number) {
						  if (j == 0) {
							t.change(1);
							System.out.println(t.toString() + "��һ����������" + a.get(j).type + a.get(j).toString());
							t.change(a.get(j).P[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "������ʽ��ʼ������" + a.get(j).P[0].toString());
							for (int n = 1; n < a.get(j).P.length; n++) {
								t.change(a.get(j).P[n].getTime());
								System.out.println(t.toString() + a.get(j).name + a.get(j).P[n].toString());
							}
							t.change(a.get(j).I[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "����ڻ�����" + a.get(j).I[0].toString());
							for (int n = 1; n < a.get(j).I.length; n++) {
								t.change(a.get(j).I[n].getTime());
								System.out.println(t.toString() + a.get(j).I[n].toString());
							}
					    }else if (j > 0){
					    	System.out.println("��һ����������" + a.get(j).type + a.get(j).toString());
							t.change(a.get(j).P[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "������ʽ��ʼ������" + a.get(j).P[0].toString());
							for (int n = 1; n < a.get(j).P.length; n++) {
								t.change(a.get(j).P[n].getTime());
								System.out.println(t.toString() + a.get(j).name + a.get(j).P[n].toString());
							}
							t.change(a.get(j).I[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "����ڻ�����" + a.get(j).I[0].toString());
							for (int n = 1; n < a.get(j).I.length; n++) {
								t.change(a.get(j).I[n].getTime());
								System.out.println(t.toString() + a.get(j).I[n].toString());
					    }
							
							}
						}
					}
				}

			}
		System.out.println("��һ����������" + m.getType() + m.toString());
		t.change(5);
		System.out.println(t.toString() + m.name + "�ı�����ʽ��ʼ�����ڱ���" + m.getPer()[0]);
		for (int i = 1; i < m.getP().length; i++) {
			t.change(m.getTime());
			System.out.println(t.toString() + m.name + "����" + m.getPer()[i]);
		}
		t.change(5);
		System.out.println(t.toString() + m.name + "����ڻ�����������ѡ3λ����" + m.getIn()[0]);
		for (int i = 1; i < m.getI().length; i++) {
			t.change(m.getTime());
			System.out.println(t.toString() + "������ѡ1λ����" + m.getIn()[i]);
		}
		if (play.getExpression().get(play.getExpression().size() - 1).equals("show end")) {
			t.change(5);
			System.out.println(t.toString() + "��λ���ڣ�����ı������˽��������λ�����˳�����ӭ����´ι��١�");
		}
	}

}
