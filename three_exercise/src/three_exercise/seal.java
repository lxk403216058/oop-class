package three_exercise;

public class seal extends lactation{ 

   public seal() {
       super("恺恺",3,"雄性",2,new trainer("gege"));
	   // TODO Auto-generated constructor stub
	   type = "海豹";
	   this.number = 2 + numberRange;
	   getperform();
	   getInteract();
   }

   private void getInteract() {
	// TODO Auto-generated method stub
	 interact[0] = new Interact("海豹跳跳", 3, rand.nextInt(5)+5);
	 interact[1] = new Interact("海豹转圈", 3, rand.nextInt(5)+5);
}

    private void getperform() {
	 // TODO Auto-generated method stub
	  perform[0] = new perform("海豹过杆", rand.nextInt(10)+5);
	  perform[1] = new perform("海豹喂食", rand.nextInt(10)+5);
    }

}