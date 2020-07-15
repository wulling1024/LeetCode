import java.util.concurrent.Semaphore;

/**
 * @Author wulling1024
 * @Create 2019-12-25  20:36
 * @Description 利用CountDownLatch设计，指定线程执行的次序
 */

class Foo {

	private static Semaphore sp_first_second = new Semaphore(0);
	private static Semaphore sp_second_three = new Semaphore(0);

	public Foo() {

	}

	public void first(/*Runnable printFirst*/) /*throws InterruptedException */ {

		// printFirst.run() outputs "first". Do not change or remove this line.
//		printFirst.run();
		System.out.println("first");
		sp_first_second.release();
	}

	public void second(/*Runnable printSecond*/) /*throws InterruptedException*/ {
		try {
			sp_first_second.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// printSecond.run() outputs "second". Do not change or remove this line.
//		printSecond.run();
		System.out.println("second");
		sp_second_three.release();
	}

	public void third(/*Runnable printThird*/) /*throws InterruptedException*/ {
		try {
			sp_second_three.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// printThird.run() outputs "third". Do not change or remove this line.
//		printThird.run();
		System.out.println("three");
	}
}

public class Solution2 {
	public static void main(String[] args) {
		Foo demo = new Foo();
		new Thread(demo::first, "A").start();
		new Thread(demo::second, "B").start();
		new Thread(demo::third, "C").start();
	}
}
