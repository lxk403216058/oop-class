
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
		System.out.println("(" + v.get(z).name + "的海洋乐园一日游)");
		System.out.println("(你来到售票处)");
		System.out.println("请输入你的会员编号：10010");
		System.out.println("您好，" + v.get(z).name + "先生，你是我们的第"+ v.get(z).getMemberNumber() +"个会员，可享受会员价格，原票价150元，会员价120元，请输入您要购买的张数：");
		int tickets = input.nextInt();
		v.get(z).setTickets(tickets);
		if (tickets*120 > v.get(z).getPre_deposit()){
			System.out.println("您的余额不足请充值：");
			int enter = input.nextInt();
			v.get(z).setPre_deposit(enter);
		}
		System.out.println("您购买的票数为"+ tickets +"张，一共是"+ 120*tickets +"元，您现在的预存款为：" + v.get(z).getPre_deposit());
		System.out.println("正在出票，您可以从下方的出票口拿走票，再见。");
		System.out.println("9：00  巡游表演马上要开始了，请各位游客就座");
		System.out.println("9：10  巡游表演马上开始，首先进行的空中表演");
		fp.random();
		sf.radom();
		
		System.out.println("下面是返场表演时间，由最受欢迎的十大明星出场");
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
			System.out.println(t.toString() + "各部门开始准备");
			for (int j = 0; j < 9; j++) {
				Scanner input1 = new Scanner(System.in);
				String enter = input1.nextLine();
				String[] str = enter.split(" ");
				int flag = Integer.valueOf(str[0]);

				if (flag == 90000) {
					t.change(m.getReadyTime());
					System.out.println(t.toString() + "美人鱼准备完毕");
				} else {
					for (int i = 0; i < a.size(); i++) {

						if (flag == a.get(i).number) {
							t.change(a.get(i).feedTime);
							a.get(i).isFeeded = true;
							System.out.println(t.toString() + a.get(i).type + "喂食完毕");
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
				System.out.println(t.toString() + "所有的动物喂食完毕，美人鱼也准备完毕，可以入场");
			} else {
				System.exit(0);
			}
			if (play.getExpression().get(1).equals("entrance start")) {
				t.change(3);
				System.out.println(t.toString() + "观众开始入场");
			}
			if (play.getExpression().get(2).equals("entrance end")) {
				int l = (int) (Math.random() * 10 + 1);
				t.change(l);
				System.out.println(t.toString() + "观众入场完毕，表演即将开始，请大家赶快坐好");
			}
			t.change(5);
			System.out.println(t.toString() + "各位观众，欢迎大家的到来，表演即将开始");

			for (int i = 3; i < a.size() + 3; i++) {
				String[] sp = play.getExpression().get(i).split(" ");
				int f = Integer.valueOf(sp[0]);
				for (int j = 0; j < a.size(); j++) {
					  if (f == a.get(j).number) {
						  if (j == 0) {
							t.change(1);
							System.out.println(t.toString() + "第一个出场的是" + a.get(j).type + a.get(j).toString());
							t.change(a.get(j).P[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "表演正式开始，现在" + a.get(j).P[0].toString());
							for (int n = 1; n < a.get(j).P.length; n++) {
								t.change(a.get(j).P[n].getTime());
								System.out.println(t.toString() + a.get(j).name + a.get(j).P[n].toString());
							}
							t.change(a.get(j).I[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "与观众互动，" + a.get(j).I[0].toString());
							for (int n = 1; n < a.get(j).I.length; n++) {
								t.change(a.get(j).I[n].getTime());
								System.out.println(t.toString() + a.get(j).I[n].toString());
							}
					    }else if (j > 0){
					    	System.out.println("下一个出场的是" + a.get(j).type + a.get(j).toString());
							t.change(a.get(j).P[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "表演正式开始，现在" + a.get(j).P[0].toString());
							for (int n = 1; n < a.get(j).P.length; n++) {
								t.change(a.get(j).P[n].getTime());
								System.out.println(t.toString() + a.get(j).name + a.get(j).P[n].toString());
							}
							t.change(a.get(j).I[0].getTime());
							System.out.println(t.toString() + a.get(j).name + "与观众互动，" + a.get(j).I[0].toString());
							for (int n = 1; n < a.get(j).I.length; n++) {
								t.change(a.get(j).I[n].getTime());
								System.out.println(t.toString() + a.get(j).I[n].toString());
					    }
							
							}
						}
					}
				}

			}
		System.out.println("下一个出场的是" + m.getType() + m.toString());
		t.change(5);
		System.out.println(t.toString() + m.name + "的表演正式开始，现在表演" + m.getPer()[0]);
		for (int i = 1; i < m.getP().length; i++) {
			t.change(m.getTime());
			System.out.println(t.toString() + m.name + "表演" + m.getPer()[i]);
		}
		t.change(5);
		System.out.println(t.toString() + m.name + "与观众互动，现在征选3位观众" + m.getIn()[0]);
		for (int i = 1; i < m.getI().length; i++) {
			t.change(m.getTime());
			System.out.println(t.toString() + "现在征选1位观众" + m.getIn()[i]);
		}
		if (play.getExpression().get(play.getExpression().size() - 1).equals("show end")) {
			t.change(5);
			System.out.println(t.toString() + "各位观众，今天的表演至此结束，请各位有序退场，欢迎大家下次光临。");
		}
	}

}
