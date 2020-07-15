/**
 * @Author wulling1024
 * @Create 2020-01-09  21:07
 * @Description
 */
public class Solution {
	static class FooBar {
		private int n;
		private volatile boolean flag = true;
		private static Object obj = new Object();

		public FooBar(int n) {
			this.n = n;
		}

		public void foo(/*Runnable printFoo*/) /*throws InterruptedException*/ {

			for (int i = 0; i < n; i++) {
				synchronized (obj) {
					if (!flag) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// printFoo.run() outputs "foo". Do not change or remove this line.
//					printFoo.run();
					System.out.print("foo");
					flag = !flag;
					obj.notifyAll();
				}
			}
		}

		public void bar(/*Runnable printBar*/) /*throws InterruptedException*/ {

			for (int i = 0; i < n; i++) {
				synchronized (obj) {
					if (flag) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// printBar.run() outputs "bar". Do not change or remove this line.
//				  	printBar.run();
					System.out.print("bar");
					flag = !flag;
					obj.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {
		FooBar demo = new FooBar(2);
		new Thread(demo::foo, "foo").start();
		new Thread(demo::bar, "bar").start();
	}
}
