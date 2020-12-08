package three_exercise;

public class shark extends fish {

	public shark() {
		super("Ğ¤¶÷",1,"ĞÛĞÔ",3, new trainer("Ê±Ê±"));
		type = "öèÓã";
		this.number = 2 + numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("öèÓãÇ×Ç×", rand.nextInt(10)+5);
		perform[1] = new perform("Ğ×ÃÍöèÓã", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("öèÓãÃşÃş", 2, rand.nextInt(5)+5);
		interact[1] = new Interact("öèÓã×ªÈ¦", 1 , rand.nextInt(5)+5);
	}
}
