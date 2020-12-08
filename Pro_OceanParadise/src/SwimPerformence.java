
public class SwimPerformence {
	private ClownFish cf = new ClownFish();
	private Dolphin dp = new Dolphin();
	private Crocodile cd = new Crocodile();
	private Mermaid md = new Mermaid();
	private SeaLion sl = new SeaLion();
	private Seals ss = new Seals();
	private Shark sk = new Shark();
	private Volador vl = new Volador();
	
	public SwimPerformence(){
		
	}
	
	public void radom(){
		cf.setScore();
		dp.setScore();
		cd.setScore();
		md.setScore();
		sl.setScore();
		ss.setScore();
		sk.setScore();
		vl.setScore();
		
		for (int i = 0;i < 10;i ++){
			if (cf.getScore() == i){
				System.out.println("     "+ cf.swim());
			}
			if (dp.getScore() == i){
				
				System.out.println("     " + dp.swim());
			}
			if (cd.getScore() == i){
				
				System.out.println("     " + cd.swim());
			}
			if (md.getScore() == i){
				
				System.out.println("     " + md.swim());
			}
			if (ss.getScore() == i){
				
				System.out.println("     " + ss.swim());
			}
			if (sk.getScore() == i){
				
				System.out.println("     " + sk.swim());
			}
			if (vl.getScore() == i){
				
				System.out.println("     " + vl.swim());
			}
			if (sl.getScore() == i){
				
				System.out.println("     " + sl.swim());
			}
		}
	}
	
	public int r(){
		return (int)(Math.random()*10);
	}

}
