package huawei_20200422;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-22  19:49:49
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] s = str.split(" ");
		ArrayList<String[]> list = func2(s);
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] next = iterator.next();
			if(func(next)){
				System.out.print("5a" + " ");
				for (int i = 1; i < next.length-1; i++) {
					System.out.print(next[i] + " ");
				}
			}
		}
		System.out.print("5a");
	}

	/**
	 * 长度校验
	 * @param str
	 * @return
	 */
	static boolean func(String[] str){
		int length = str.length;
		String s = str[length - 2];
		// TODO 应该是这个位置的问题
		int tag = Integer.parseInt(s);
		int temp = 0;
		for (int i =1; i<str.length-2; i++){
			if(str[i].equals("5b") && str[i+1].equals("ba")){
				i++;
				temp++;
			}else if(str[i].equals("5b") && str[i+1].equals("bb")){
				i++;
				temp++;
			}else{
				temp++;
			}
		}
		return tag == temp ? true:false;
	}

	/**
	 * 长串切分
	 * @param str
	 * @return
	 */
	static ArrayList<String[]> func2(String[] str){
		ArrayList<String[]> list = new ArrayList<>();
		ArrayList<String> tag = new ArrayList<>();
		tag.add("5a");
		for(int i = 0; i<str.length; i++){
			if(str[i].equals("5a") && tag.size() > 1){
				tag.add(str[i]);
				list.add(tag.toArray(new String[tag.size()]));
				tag = new ArrayList<>();
				tag.add("5a");
			}
			if(!str[i].equals("5a")) {
				tag.add(str[i]);
			}
		}
		return list;
	}
}
