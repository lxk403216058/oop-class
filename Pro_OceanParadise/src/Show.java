
public class Show {
	private Airship as = new Airship();
	private FlyingMan fm = new FlyingMan();
	private GoldenBird gb = new GoldenBird();
	private Parrot pr = new Parrot();
	private Volador vd = new Volador();
	private ClownFish cf = new ClownFish();
	private Dolphin dp = new Dolphin();
	private Crocodile cd = new Crocodile();
	private SeaLion sl = new SeaLion();
	private Seals ss = new Seals();
	private Shark sk = new Shark();
	private Volador vl = new Volador();
	
	public Show(){
		
	}
	
	public void random(){
		as.setScore();
		fm.setScore();
		gb.setScore();
		pr.setScore();
		vd.setScore();
		cf.setScore();
		dp.setScore();
		cd.setScore();
		sl.setScore();
		ss.setScore();
		sk.setScore();
		vl.setScore();
		System.out.println("��һ�����������ӭ��������");
		int flag = 0;
		for (int i = 0;i < 10 && flag <= 10;i ++){
			if (as.getScore() == i){
				System.out.println("�������������Ƿ�ͧ");
				flag ++;
			}
			if (fm.getScore() == i){
				System.out.println("�������������Ƿ���");
				flag ++;
			}
			if (gb.getScore() == i){
				System.out.println("�������������ǽ�˿��");
				flag ++;
			}
			if (pr.getScore() == i){
				System.out.println("������������������");
				flag ++;
			}
			if (vd.getScore() == i){
				System.out.println("�������������Ƿ���");
				flag ++;
			}
			if (cf.getScore() == i){
				System.out.println("��������������С����");
				flag ++;
			}
			if (dp.getScore() == i){
				System.out.println("�������������Ǻ���");
				flag ++;
			}
			if (cd.getScore() == i){
				System.out.println("������������������");
				flag ++;
			}
			if (ss.getScore() == i){
				System.out.println("�������������Ǻ�ʨ");
				flag ++;
			}
			if (sk.getScore() == i){
				System.out.println("������������������");
				flag ++;
			}
			if (vl.getScore() == i){
				System.out.println("�������������Ƿ���");
				flag ++;
			}
			if (sl.getScore() == i){
				System.out.println("�������������Ǻ���");
				flag ++;
			}
		}
	}

}
