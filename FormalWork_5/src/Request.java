
public class Request {
	private static LinkQueue<String[]> newqueue = new LinkQueue<String[]>();

	public Request(){
		
	}
	public void addRequest(String[] e){//�ļ��е��������
		newqueue.add(e);
	}
	
	public String[] getRequest(){//һ�����з�������ķ���
		String[] str = newqueue.poll().e;
		return str;
	}
	
	public int getSize(){
		return newqueue.length();
	}
}
