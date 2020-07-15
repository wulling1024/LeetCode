package kuaishou_20200412;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 完美重复幂因子
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-12  15:51:51
 */
public class T_2 {
	public static void main(String[] args) {
		int R = 39;
		int N = 3;
		int[] result = GetPowerFactor(R, N);
		for(int i = 0; i< result.length; i++){
			System.out.println(result[i]);
		}
	}

	static int[] GetPowerFactor (int R, int N) {
		List<Integer> lists = new ArrayList<>();
		while(R > 0){
			int tag = GetTrim(R, N);
			if(tag >= 0){
				lists.add(tag);
				R = (int) (R - Math.pow(N, tag));
			}else{
				break;
			}
		}
		if(R != 0){
			return new int[0];
		}else{
			Iterator<Integer> iterator = lists.iterator();
			int[] result = new int[lists.size()];
			int tag = lists.size() -1;
			Integer start = iterator.next();
			while(iterator.hasNext()){
				result[tag--] = start;
				int temp = iterator.next();
				if(start != temp + 1){
					return new int[0];
				}
				start = temp;
			}
			result[tag] = start;
			return result;
		}
	}
	static int GetTrim(int all, int N){
		int i = 0;
		while(Math.pow(N, i) <= all){
			i++;
		}
		return i-1;
	}
}
