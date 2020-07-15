package jindong_20200418;

import java.util.*;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-18  18:58:58
 */
public class T_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		ArrayList<long[][]> list = new ArrayList<>();
		int tag = 0;
		while(tag < T) {
			long[][] longs = new long[6][2];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 2; j++) {
					longs[i][j] = scanner.nextLong();
				}
			}
			list.add(longs);
			tag++;
		}
		for(int i =0 ;i<T;i++){
			System.out.println(func(list.get(i)) ? "POSSIBLE" : "IMPOSSIBLE");
		}
	}

	static boolean func(long[][] arr){
		HashMap<Long, Long> map = new HashMap<>();
		Set<Long> set = new HashSet<>();
		for(int i = 0; i<6; i++){
			for(int j = 0;j<2;j++){
				if(map.containsKey(arr[i][j])){
					map.put(arr[i][j], map.get(arr[i][j])+1);
				}else{
					map.put(arr[i][j], 1L);
					set.add(arr[i][j]);
				}
			}
		}
		Iterator<Long> iterator = set.iterator();
		if(map.size() == 3){
			while(iterator.hasNext()){
				if(map.get(iterator.next()) != 4){
					return false;
				}
			}
			return true;
		}else if (map.size() == 2){
			while(iterator.hasNext()){
				if(map.get(iterator.next()) != 4 || map.get(iterator.next()) != 8){
					return false;
				}
			}
			return true;
		}else if(map.size() == 1){
			while (iterator.hasNext()){
				if(map.get(iterator.next()) != 12){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
