package Test2;

public class Main {
	public static void main(String[] args){
		String[] str = {"(FR,1,UP,0)","(ER,8,1)","(FR,4,UP,2)","(ER,10,3)"};
		Queue q = new Queue();
		
		for (int i = 0;i < str.length;i ++){
			q.add(str[i]);
		}
		
		NewDispatcher d = new NewDispatcher();
		d.dealRequest(q);
	}

}
