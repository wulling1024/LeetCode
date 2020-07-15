package Test_20200321;

import java.util.concurrent.TimeUnit;

/**
 * 使用 synchronized的 wait/notify机制
 *
 * @author wulling1024@163.com
 * @since 2020-03-21  18:33:33
 */
public class T_thread3 {
	public static void main(String[] args) throws InterruptedException {
		char[] nums = "123456789".toCharArray();
		char[] letter = "ABCDEFGHI".toCharArray();
		Object lock = new Object();

		new Thread(() -> {
			int i = 0;
			while (i < letter.length) {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(letter[i++]);
					lock.notify();
				}
			}
		}).start();
		Thread.sleep(500);

		new Thread(() -> {
			int i = 0;
			while (i < nums.length) {
				synchronized (lock) {
					System.out.println(nums[i++]);
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();


	}
}
