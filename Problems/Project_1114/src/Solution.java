import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wulling1024
 * @Create 2019-12-25  20:36
 * @Description 利用CountDownLatch设计，指定线程执行的次序
 */

public class Solution {
	public static void main(String[] args) {
		Foo demo = new Foo();
		int[] arr = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < 3; j++) {
			arr[j] = sc.nextInt();
		}

		for (int j = 0; j < 3; j++) {
			int i = arr[j];
			switch (i) {
				case 1:
					new Thread(demo::first, "A").start();
					break;
				case 2:
					new Thread(demo::second, "B").start();
					break;
				case 3:
					new Thread(demo::third, "C").start();
					break;
			}
		}

	}

	static class Foo {

		private static CountDownLatch latch = new CountDownLatch(1);
		private static CountDownLatch latch2 = new CountDownLatch(1);

		public Foo() {

		}

		public void first(/*Runnable printFirst*/) /*throws InterruptedException*/ {

			// printFirst.run() outputs "first". Do not change or remove this line.
//			printFirst.run();
			System.out.println("first");
			latch.countDown();
		}

		public void second(/*Runnable printSecond*/) /*throws InterruptedException*/ {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// printSecond.run() outputs "second". Do not change or remove this line.
//			printSecond.run();
			System.out.println("second");
			latch2.countDown();
		}

		public void third(/*Runnable printThird*/) /*throws InterruptedException*/ {
			try {
				latch2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// printThird.run() outputs "third". Do not change or remove this line.
//			printThird.run();
			System.out.println("three");
		}
	}
}
