
import java.util.*;

public class Main {
	public static void main(String[] args){
		ArrayList<String> array = new ArrayList<>();
		array.add("0");
		array.add("1");
		array.add("2");
		array.add("3");
		Iterator<String> iter1 = array.iterator();
		while (iter1.hasNext()){
			
			String str = iter1.next();
			if ("2".equals(str)){
				iter1.remove();
			}else{
				System.out.println(str);
			}
		}
		
		array.set(2, "4");
		
		System.out.println("ɾ����ļ��ϣ�" + array);
		
		LinkedList<String> link = new LinkedList<>();
		
		link.add("����");
		link.add("�Ϻ�");
		link.add("����");
		link.add("����");
		
		Iterator<String> iter2 = link.iterator();
		
		while (iter2.hasNext()){
			
			String str = iter2.next();
			if ("����".equals(str)){
				iter2.remove();
			}else {
				System.out.println(str);
			}
		}
		
		link.set(2,"����");
		
		System.out.println("ɾ����ļ��ϣ�" + link);
		
		Set<String> set = new HashSet<>();
		set.add("����");
		set.add("�Ǻ�");
		set.add("�ٺ�");
		set.add("����");
		
		Iterator<String> iter3 = set.iterator();
		
		while (iter3.hasNext()){
			
			String str = iter3.next();
			if ("����".equals(str)){
				iter3.remove();
			}else {
				System.out.println(str);
			}
		}
		
		set.remove("�ٺ�");
		
		System.out.println("ɾ����ļ��ϣ�" + set);
		
		Set<String> set1 = new TreeSet<>(set);
		Iterator<String> iter4 = set.iterator();
		set1.add("����");
		
		while (iter2.hasNext()){
			
			String str = iter4.next();
			if ("����".equals(str)){
				iter3.remove();
			}else {
				System.out.println(str);
			}
		}

		System.out.println("ɾ����ļ��ϣ�" + set1);
		
		Map<Integer,String> hashmap = new HashMap<>();
		
		Set<Map.Entry<Integer, String>> es=hashmap.entrySet();
		
		hashmap.put(1, "����");
		hashmap.put(2, "�Ϻ�");
		hashmap.put(3, "����");
		hashmap.put(4, "����");
		
		
		
		Iterator<Map.Entry<Integer, String>> iter5= es.iterator();
		System.out.println("��ʼ�ļ��ϣ�" + hashmap);
		
		
		
		while (iter5.hasNext()){
			Map.Entry<Integer, String> en = iter5.next();
			int key = en.getKey();
			String str = en.getValue();
			
			if (key == 2){
				iter5.remove();
			}else {
				System.out.println("key:" + key+ "value:" +str);
			}
		}
		
		System.out.println("key��" + hashmap.keySet() + "  value:" + hashmap.entrySet());
		
		hashmap.put(2, "����");
		
		System.out.println("key:" + hashmap.keySet() + "   value:" + hashmap.entrySet());
		
		Map<Integer,String> treemap = new TreeMap<>(hashmap);
		
		treemap.put(5, "�Ͼ�");
		
		Set<Map.Entry<Integer, String>> ens = treemap.entrySet();
		
		Iterator<Map.Entry<Integer, String>> iter6 = ens.iterator();
		
		System.out.println("��ʼ�ļ��ϣ�" + treemap);
		
		while (iter6.hasNext()){
			Map.Entry<Integer, String> en = iter6.next();
			int key = en.getKey();
			String str = en.getValue();
			
			if (key == 3){
				iter6.remove();
			}else {
				System.out.println("key:" + key+ "   value:" +str);
			}
		}
		
		System.out.println("key��" + treemap.keySet() + "  value:" + treemap.entrySet());
	}

}
