import java.util.concurrent.Semaphore;

/**
 * @Author wulling1024
 * @Create 2020-01-10  10:41
 * @Description
 */
public class Solution2 {
}

/**
 * 官方最快的方案：使用是 Semaphore工具类
 */
class FooBar {
	private int n;

	public FooBar(int n) {
		this.n = n;
	}

	/**
	 * 使用 Semaphore.release() 就会增加一个可用的信号信息
	 */
	Semaphore foo = new Semaphore(1);
	Semaphore bar = new Semaphore(0);

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			foo.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			bar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			bar.acquire();
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			foo.release();
		}
	}
}
