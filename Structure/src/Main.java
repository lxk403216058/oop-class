
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
		
		System.out.println("删除后的集合：" + array);
		
		LinkedList<String> link = new LinkedList<>();
		
		link.add("北京");
		link.add("上海");
		link.add("深圳");
		link.add("广州");
		
		Iterator<String> iter2 = link.iterator();
		
		while (iter2.hasNext()){
			
			String str = iter2.next();
			if ("北京".equals(str)){
				iter2.remove();
			}else {
				System.out.println(str);
			}
		}
		
		link.set(2,"昆明");
		
		System.out.println("删除后的集合：" + link);
		
		Set<String> set = new HashSet<>();
		set.add("哈哈");
		set.add("呵呵");
		set.add("嘿嘿");
		set.add("嘻嘻");
		
		Iterator<String> iter3 = set.iterator();
		
		while (iter3.hasNext()){
			
			String str = iter3.next();
			if ("嘻嘻".equals(str)){
				iter3.remove();
			}else {
				System.out.println(str);
			}
		}
		
		set.remove("嘿嘿");
		
		System.out.println("删除后的集合：" + set);
		
		Set<String> set1 = new TreeSet<>(set);
		Iterator<String> iter4 = set.iterator();
		set1.add("呼呼");
		
		while (iter2.hasNext()){
			
			String str = iter4.next();
			if ("哈哈".equals(str)){
				iter3.remove();
			}else {
				System.out.println(str);
			}
		}

		System.out.println("删除后的集合：" + set1);
		
		Map<Integer,String> hashmap = new HashMap<>();
		
		Set<Map.Entry<Integer, String>> es=hashmap.entrySet();
		
		hashmap.put(1, "北京");
		hashmap.put(2, "上海");
		hashmap.put(3, "深圳");
		hashmap.put(4, "广州");
		
		
		
		Iterator<Map.Entry<Integer, String>> iter5= es.iterator();
		System.out.println("初始的集合：" + hashmap);
		
		
		
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
		
		System.out.println("key：" + hashmap.keySet() + "  value:" + hashmap.entrySet());
		
		hashmap.put(2, "昆明");
		
		System.out.println("key:" + hashmap.keySet() + "   value:" + hashmap.entrySet());
		
		Map<Integer,String> treemap = new TreeMap<>(hashmap);
		
		treemap.put(5, "南京");
		
		Set<Map.Entry<Integer, String>> ens = treemap.entrySet();
		
		Iterator<Map.Entry<Integer, String>> iter6 = ens.iterator();
		
		System.out.println("初始的集合：" + treemap);
		
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
		
		System.out.println("key：" + treemap.keySet() + "  value:" + treemap.entrySet());
	}

}
