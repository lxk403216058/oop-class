package three_exercise;

public class perform {
  String pername;
  int pertime;
  public perform(String pername,int pertime){
	  this.pername=pername;
	  this.pertime=pertime;
  }
  public void setName(String pername){
	  this.pername=pername;
  }
  public String getName(){
	  return pername;
  }
  public void setTime(int pertime){
	  this.pertime=pertime;
  }
  public int getTime(){
	  return pertime;
  }
}
