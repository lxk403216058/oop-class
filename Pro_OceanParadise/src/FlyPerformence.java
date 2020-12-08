
public class FlyPerformence {
	private Airship as = new Airship();
	private FlyingMan fm = new FlyingMan();
	private GoldenBird gb = new GoldenBird();
	private Parrot pr = new Parrot();
	private Volador vd = new Volador();	
	
	public FlyPerformence(){
		
	}
	
	public void random(){
		as.setScore();
		fm.setScore();
		gb.setScore();
		pr.setScore();
		vd.setScore();
		
		for (int i = 0;i < 10;i ++){
			if (as.getScore() == i){
				System.out.println("     " + as.fly());
			}
			if (fm.getScore() == i){
				System.out.println("     " + fm.fly());
			}
			if (gb.getScore() == i){
				System.out.println("     " + gb.fly());
			}
			if (pr.getScore() == i){
				System.out.println("     " + pr.fly());
			}
			if (vd.getScore() == i){
				System.out.println("     " + vd.fly());
			}
		}
	}
	
	public int r(){
		return (int)(Math.random()*10);
	}

}
