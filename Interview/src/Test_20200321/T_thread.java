package Test_20200321;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程轮换打印 ----- LockSupport
 *
 * @author wulling1024@163.com
 * @since 2020-03-21  17:44:44
 */
public class T_thread {
	static Thread A = null, B = null;

	public static void main(String[] args) {
		char[] nums = "123456789".toCharArray();
		char[] letter = "ABCDEFGHI".toCharArray();

		//线程A
		A = new Thread(() -> {
			int i = 0;
			while (i < nums.length) {
				System.out.println(nums[i++]);
				LockSupport.unpark(B);
				LockSupport.park();
			}
		});

		B = new Thread(() -> {
			int i = 0;
			while (i < letter.length) {
				LockSupport.park();
				System.out.println(letter[i++]);
				LockSupport.unpark(A);
			}
		});
		A.start();
		B.start();
	}
}

