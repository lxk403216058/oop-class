
public class Request {
	private static LinkQueue<String[]> newqueue = new LinkQueue<String[]>();

	public Request(){
		
	}
	public void addRequest(String[] e){//文件中的请求入队
		newqueue.add(e);
	}
	
	public String[] getRequest(){//一个按行返回请求的方法
		String[] str = newqueue.poll().e;
		return str;
	}
	
	public int getSize(){
		return newqueue.length();
	}
}
