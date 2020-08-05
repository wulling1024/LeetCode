import java.util.ArrayList;

/**
 * @Author wulling1024
 * @Create 2020-01-10  20:15
 * @Description
 */

class SolutionDemo {
	public String longestPalindrome(String s) {
		ArrayList<String> results = new ArrayList<>();
		int tag = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = s.length() - 1; j > i; j--) {
				String temp = func(s.substring(i, j + 1));
				if (temp != null) {
					results.add(temp);
					break;
				}
			}
		}
		if (s.length() == 1 || s.length() == 0) {
			return s;
		} else if (results.size() == 0) {
			return s.substring(0, 1);
		} else if (results.size() == 1) {
			return results.get(0);
		} else {
			String result = results.get(0);
			for (int i = 1; i < results.size(); i++) {
				if (results.get(i).length() > result.length()) {
					result = results.get(i);
					continue;
				}
			}
			return result;
		}
	}

	static String func(String s) {
		int end = s.length() - 1;
		char[] arr = s.toCharArray();
		int i = 0, j = end;
		for (; i < j; i++, j--) {
			if (arr[i] != arr[j]) {
				break;
			}
		}
		if (i - j == 0 || i - j == 1) {
			return s;
		} else {
			return null;
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		SolutionDemo demo = new SolutionDemo();
		String str = demo.longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel");
		System.out.println(str);
	}
}
