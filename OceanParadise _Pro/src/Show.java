
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
		System.out.println("第一个出场的是最欢迎的美人鱼");
		int flag = 0;
		for (int i = 0;i < 10 && flag <= 10;i ++){
			if (as.getScore() == i){
				System.out.println("接下来出场的是飞艇");
				flag ++;
			}
			if (fm.getScore() == i){
				System.out.println("接下来出场的是飞人");
				flag ++;
			}
			if (gb.getScore() == i){
				System.out.println("接下来出场的是金丝鸟");
				flag ++;
			}
			if (pr.getScore() == i){
				System.out.println("接下来出场的是鹦鹉");
				flag ++;
			}
			if (vd.getScore() == i){
				System.out.println("接下来出场的是飞鱼");
				flag ++;
			}
			if (cf.getScore() == i){
				System.out.println("接下来出场的是小丑鱼");
				flag ++;
			}
			if (dp.getScore() == i){
				System.out.println("接下来出场的是海豚");
				flag ++;
			}
			if (cd.getScore() == i){
				System.out.println("接下来出场的是鳄鱼");
				flag ++;
			}
			if (ss.getScore() == i){
				System.out.println("接下来出场的是海狮");
				flag ++;
			}
			if (sk.getScore() == i){
				System.out.println("接下来出场的是鲨鱼");
				flag ++;
			}
			if (vl.getScore() == i){
				System.out.println("接下来出场的是飞鱼");
				flag ++;
			}
			if (sl.getScore() == i){
				System.out.println("接下来出场的是海豹");
				flag ++;
			}
		}
	}

}
