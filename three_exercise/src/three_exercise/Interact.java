package three_exercise;

public class Interact {
  String intename;
  int intenum;
  int intetime;
  public Interact(String intename,int intenum,int intetime){
	  this.intename=intename;
	  this.intenum=intenum;
	  this.intetime=intetime;
  }
  public void setname(String intename){
	  this.intename=intename;
  }
  public String getname(){
	  return intename;
  }
  public void setnum(int intenum){
	  this.intenum=intenum;
  }
  public int getnum(){
	  return intenum;
  }
  public void intetime(int intetime){
	  this.intetime=intetime;
  }
  public int gettime(){
	  return intetime;
  }
}
