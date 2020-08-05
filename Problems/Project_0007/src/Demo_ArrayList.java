import java.util.ArrayList;
import java.util.Scanner;

/**
 * @idea 关于泛型数组的实现形式
 * 1、指定数组元素类型 ArrayList<int> A = new ArrayList<>(); 不定长度 自动判别
 * 2、不定数组元素类型 ArrayList<T> B = new ArrayList<>(); 存储多种类别 定义泛型类，之后进行指定元素
 * @wauthor wulling1024
 * @create 2019-01-05  10:33
 */
class MyStack<T> {
	ArrayList<T> stack = new ArrayList<>();

	public void push(T t) {
		stack.add(t);
	}

	public T pull() {
		return stack.remove(0);
	}

	public T peek() {
		return stack.get(0);
	}
}

public class Demo_ArrayList {
	public static void main(String[] args) {
		MyStack<Integer> A = new MyStack<Integer>();//使用包装类
		Scanner scanner = new Scanner(System.in);
		//以输入0 作为结束的标志
		System.out.println("-----请以 “0” 作为结束的标志-----");
		int temp = scanner.nextInt();
		while (temp != 0) {
			A.push(temp);
			temp = scanner.nextInt();
		}
		System.out.println(A.peek());
		System.out.println(A.pull());
		System.out.println(A.peek());
	}
}
