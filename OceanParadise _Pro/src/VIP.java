
public class VIP extends Vistor {
	private int number;
	private int memberNumber;
	private static int pre_deposit = 1000;
	
	public VIP(){
		
	}
	
	public VIP(int number,int memberNumber){
		this.memberNumber = memberNumber;
		this.number = number;
	}
	
	public void setPre_deposit(int d){
		pre_deposit = pre_deposit + d;
	}
	
	public int getPre_deposit(){
		return pre_deposit - 120*tickets;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setMemberNumber(int m){
		this.memberNumber = m;
	}
	
	public int getMemberNumber(){
		return memberNumber;
	}
	
	public int score(){
		return (int)(Math.random()*10 + 1);
	}
	
	public String toString(){
		return "您好，" + name + "先生，您是我们的" + memberNumber + "号会员，可享受会员价格，原票价150元，会员价120元，请输入你要购买的张数：";
	}
}
