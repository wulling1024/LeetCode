package Test_20200321;

/**
 * 使用 Volatile
 *
 * @author wulling1024@163.com
 * @since 2020-03-21  17:59:59
 */
public class T_thread2 {
	enum Tag {T1, T2}

	private static volatile Tag startRun = Tag.T1;
	static Thread A = null, B = null;

	public static void main(String[] args) {
		char[] nums = "123456789".toCharArray();
		char[] letter = "ABCDEFGHI".toCharArray();

		A = new Thread(() -> {
			int i = 0;
			while (i < nums.length) {
				if (startRun == Tag.T1) {
					System.out.println(nums[i++]);
					startRun = Tag.T2;
				}
			}
		});
		A.start();

		B = new Thread(() -> {
			int i = 0;
			while (i < nums.length) {
				if (startRun == Tag.T2) {
					System.out.println(letter[i++]);
					startRun = Tag.T1;
				}
			}
		});
		B.start();
	}
}
