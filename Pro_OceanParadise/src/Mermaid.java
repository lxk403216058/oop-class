
public class Mermaid extends Staff implements Swim {
	private final String mermaid = "����";
	private String type = "������";
	private int number = 90000;
	private int readyTime = (int)(Math.random() * 20 + 1);
	private Performence[] P = new Performence[3];
	private Interaction[] I = new Interaction[3];
	private boolean isReady = false;
	private String[] Per = {"ˮ������","ˮ���赸","����"};
	private String[] In = {"����ں�Ӱ","�͹���ӵ��","��������Գ�"};
	private int time = (int)(Math.random() * 5);
	private int score;
	
	public Mermaid(){
		this.name = mermaid;
	}
	
	public String swim(){
		return "�������ι�";
	}
	
	public void setScore(){
		this.score =(int)(Math.random()*10 + 1);
	}
	
	public int getScore(){
		return score;
	}
	
	public String[] getPer(){
		return Per;
	}
	
	public String[] getIn(){
		return In;
	}
	
	public String getType(){
		return type;
	}
	
	public int getTime(){
		return time;
	}
	
	public int getNum(){
		return number;
	}
	
	public int getReadyTime(){
		return readyTime;
	}
	
	public void setP(){
		for (int i = 0;i < Per.length;i ++){
			P[i] = new Performence(Per[i]);
		}
	}
	
	public void setI(){
		for (int i = 0;i < In.length;i ++){
			I[i] = new Interaction(In[i]);
		}
	}
	
	public Performence[] getP(){
		return P;
	}
	
	public Interaction[] getI(){
		return I;
	}
	
	public String getName(){
		return name;
	}
	
	public void setIsReady(boolean isReady){
		this.isReady = isReady;
	}
	
	public boolean getIsReady(){
		return isReady;
	}
	
	public String toString(){
		return "������ݵ�����������" + name + ",�Ա�Ů";
	}

}
