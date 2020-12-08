
public class Mermaid extends Staff{
	private final String mermaid = "美美";
	private String type = "美人鱼";
	private int number = 90000;
	private int readyTime = (int)(Math.random() * 20 + 1);
	private Performence[] P = new Performence[3];
	private Interaction[] I = new Interaction[3];
	private boolean isReady = false;
	private String[] Per = {"水中漫步","水中舞蹈","出海"};
	private String[] In = {"与观众合影","和观众拥抱","与观众情歌对唱"};
	private int time = (int)(Math.random() * 5);
	
	public Mermaid(){
		this.name = mermaid;
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
		return "今天表演的美人鱼名叫" + name + ",性别女";
	}

}
