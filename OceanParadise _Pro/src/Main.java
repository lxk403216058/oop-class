
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
		ArrayList<VIP> v = new ArrayList<>();
		ArrayList<Vistor> vt = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		FlyPerformence fp = new FlyPerformence();
		SwimPerformence sf  = new SwimPerformence();
		
		for (int i = 0;i < 30;i ++){
			String str = "";
			for (int j = 0;j < 5;j ++){
				str  = str +(char)(Math.random()*26 + 'a');
			}
			VIP vip = new VIP();
			vip.setName(str);
			vip.setMemberNumber(i + 1);
			vip.setNumber(10001 + i);
			v.add(vip);
		}
		
		for (int i = 0;i < 70;i ++){
			String str = "";
			for (int j = 0;j < 5;j ++){
				str  = str +(char)(Math.random()*26 + 'a');
			}
			Tourist tr = new Tourist();
			tr.setName(str);
			vt.add(tr);
		}
		
		int z = (int)(Math.random()*30);
		System.out.println("(" + v.get(z).name + "�ĺ�����԰һ����)");
		System.out.println("(��������Ʊ��)");
		System.out.println("��������Ļ�Ա��ţ�10010");
		System.out.println("���ã�" + v.get(z).name + "�������������ǵĵ�"+ v.get(z).getMemberNumber() +"����Ա�������ܻ�Ա�۸�ԭƱ��150Ԫ����Ա��120Ԫ����������Ҫ�����������");
		int tickets = input.nextInt();
		v.get(z).setTickets(tickets);
		if (tickets*120 > v.get(z).getPre_deposit()){
			System.out.println("�����������ֵ��");
			int enter = input.nextInt();
			v.get(z).setPre_deposit(enter);
		}
		System.out.println("�������Ʊ��Ϊ"+ tickets +"�ţ�һ����"+ 120*tickets +"Ԫ�������ڵ�Ԥ���Ϊ��" + v.get(z).getPre_deposit());
		System.out.println("���ڳ�Ʊ�������Դ��·��ĳ�Ʊ������Ʊ���ټ���");
		System.out.println("9��00  Ѳ�α�������Ҫ��ʼ�ˣ����λ�ο;���");
		System.out.println("9��10  Ѳ�α������Ͽ�ʼ�����Ƚ��еĿ��б���");
		fp.random();
		sf.radom();
		
		System.out.println("�����Ƿ�������ʱ�䣬�����ܻ�ӭ��ʮ�����ǳ���");
		Show show = new Show();
		show.random();
		t.change(50);
		
		
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
				Scanner input1 = new Scanner(System.in);
				String enter = input1.nextLine();
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
