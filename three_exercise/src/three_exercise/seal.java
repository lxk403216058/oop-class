package three_exercise;

public class seal extends lactation{ 

   public seal() {
       super("����",3,"����",2,new trainer("gege"));
	   // TODO Auto-generated constructor stub
	   type = "����";
	   this.number = 2 + numberRange;
	   getperform();
	   getInteract();
   }

   private void getInteract() {
	// TODO Auto-generated method stub
	 interact[0] = new Interact("��������", 3, rand.nextInt(5)+5);
	 interact[1] = new Interact("����תȦ", 3, rand.nextInt(5)+5);
}

    private void getperform() {
	 // TODO Auto-generated method stub
	  perform[0] = new perform("��������", rand.nextInt(10)+5);
	  perform[1] = new perform("����ιʳ", rand.nextInt(10)+5);
    }

}