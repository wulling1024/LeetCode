package Test_20200321;

import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch
 *
 * @author wulling1024@163.com
 * @since 2020-03-21  18:53:53
 */
public class T_thread4 {
	static CountDownLatch countDownLatch = null;
	static CountDownLatch countDownLatch1 = new CountDownLatch(1);

	public static void main(String[] args) {
		char[] nums = "123456789".toCharArray();
		char[] letter = "ABCDEFGHI".toCharArray();


		new Thread(() -> {
			int i = 0;
			while (i < nums.length) {
				countDownLatch = new CountDownLatch(1);
				System.out.println(nums[i++]);
				try {
					countDownLatch1.countDown();
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			int i = 0;
			while (i < letter.length) {
				try {
					countDownLatch1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(letter[i++]);
				countDownLatch1 = new CountDownLatch(1);
				countDownLatch.countDown();
			}
		}).start();
	}
}
