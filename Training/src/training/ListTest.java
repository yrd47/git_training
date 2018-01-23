package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * list是对象集合，允许重复对象；map是键值对的集合，不允许key重复
 * 利用迭代器将list里的值取出来
 */
public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(Iterator<Object> iterator=list.iterator();iterator.hasNext();){
			Object string = iterator.next();
			System.out.println(string);
		}
		Map<String, String> map0=new HashMap<String,String>();
		map0.put("name", "kuli");
		map0.put("sex", "male");
		String nameString = map0.get("name");
		String sexString = map0.get("sex");
		System.out.println(nameString +"\n"+ sexString);
		
		List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();	
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("name", "aaa");
		map1.put("age", 23);
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("name", "bbb");
		map2.put("age", 43);
		lists.add(map1);
		lists.add(map2);
		Iterator<Map<String, Object>> iterator = lists.iterator();
		for(;iterator.hasNext();){
			Map<String, Object> map3 = iterator.next();
			String name = (String) map3.get("name");
			Object age = map3.get("age");
			System.out.println("name=" + name + "\nage" + age);
		}
	}
	
}
