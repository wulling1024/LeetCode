/**
 * @Author wulling1024
 * @Create 2020-01-11  14:02
 * @Description 最快的解决方案
 */
class Solution2Demo {
	public String longestPalindrome(String s) {
		if(s == null || s.length()==0){
			return "";
		}

		int sLength = s.length();
		if(sLength == 1){
			return s;
		}
		char[] chars = s.toCharArray();

		int[] result = new int[2];
		for(int i = 0; i < sLength ;i++){
			i = explore(chars,i,result);
		}
		return s.substring(result[0] + 1, result[1]);
	}

	private int explore(char[] chars, int i ,int [] result){
		int l =i;
		int r = i;
		int length = chars.length;
		while ((r+1) < length && chars[r+1] == chars[r]){
			r++;
		}
		int re =r;
		while(l>=0 && r < length && chars[l] == chars[r]){
			l--;
			r++;
		}
		if((r-l) > (result[1]- result[0])){
			result[0]= l;
			result[1]= r;
		}
		return re;
	}

}

public class Solution2 {
	public static void main(String[] args) {

	}
}
