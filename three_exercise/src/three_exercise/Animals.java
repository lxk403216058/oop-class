package three_exercise;

import java.util.Random;

//��š�����ǳơ����䡢�Ա�ιʳʱ��
public class Animals {
   protected int number=1;
   protected String tier=" ";//���
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
		return (type+",������ݵ�"+type+"��"+name+","+age+"��,"+sex+",��������ѵ��ʦ"+trainer.getname()+"����"+name+"����\r\n"+time.Go(1)+"  "+name+"�ı�����ʽ��ʼ�����ڱ��ݵ���"+perform[0].getName()+"\r\n"+time.Go(perform[0].pertime)+"  "+name+"����"+perform[1].pername+"\r\n"+time.Go(perform[1].pertime)+"  "+name+"����ڻ�����������ѡ"+interact[0].intenum+"λ���˹��ڸ�"+name+interact[0].intename+"\r\n"+time.Go(interact[0].intetime)+"  "+name+"���ݽ�������һ����������");
	}
}
