package huawei;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/05/15
 */
public class Main {

	// 先序遍历
	void func(Node node){
		System.out.println(node.name);
		if(node.left != null){
			func(node.left);
		}
		if(node.right != null) {
			func(node.right);
		}
	}
	// 中序遍历
	void func2(Node node){
		if(node.left != null){
			func2(node.left);
		}
		System.out.println(node.name);
		if(node.right != null){
			func2(node.right);
		}
	}

}
class Node{
	Node left;
	Node right;
	String name;
}