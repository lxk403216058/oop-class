package three_exercise;

import java.util.Random;

//编号、类别、昵称、年龄、性别、喂食时长
public class Animals {
   protected int number=1;
   protected String tier=" ";//类别
   protected String name=" ";
   protected int age=1;
   protected String sex=" ";
   protected int feedtime=1;
   protected perform[] perform=new perform[2];
   protected Interact[] interact=new Interact[2];
   protected trainer  trainer=new trainer();
   String type = " ";
   Random rand = new Random();
   public Animals(){
	   
   }
   public Animals(String name,int age,String sex,int feedtime,trainer trainer){
    super();
    this.name=name;
    this.age=age;
    this.sex=sex;
    this.feedtime=feedtime;
    trainer =new trainer(name);
   }
   public void setnumber(int number){
	   this.number=number;
   }
   public int getnumber(){
	   return number;
   }
   public String gettier(){
	   return tier;
   }
   public void settier(String tier){
	   this.tier=tier;
   }
   public void setname(String name){
	   this.name=name;
   }
   public String getname(){
	   return name;
   }
   public void setage(int age){
	   this.age=age;
   }
   public int getage(){
	   return age;
   }
   public void setsex(String sex){
	   this.sex=sex;
   }
   public String getsex(){
	   return sex;
   }
   public void setfeedtime(int feedtime){
	   this.feedtime=feedtime;
   }
   public int getfeedtime(){
	   return feedtime;
   }
	public String toString(Mytime time) {
		return (type+",今天表演的"+type+"叫"+name+","+age+"岁,"+sex+",现在有请训兽师"+trainer.getname()+"带领"+name+"出场\r\n"+time.Go(1)+"  "+name+"的表演正式开始，现在表演的是"+perform[0].getName()+"\r\n"+time.Go(perform[0].pertime)+"  "+name+"表演"+perform[1].pername+"\r\n"+time.Go(perform[1].pertime)+"  "+name+"与观众互动，现在征选"+interact[0].intenum+"位幸运观众跟"+name+interact[0].intename+"\r\n"+time.Go(interact[0].intetime)+"  "+name+"表演结束，下一个出场的是");
	}
}
