import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wulling1024
 * @create 2019-03-30  21:24
 */
public class Fianlly2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        int size = words.length;
        if (size == 0) return res;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words)
            wordsMap.put(word, wordsMap.getOrDefault(word, 0)+1);
        int wordLen = words[0].length();
        int window = size * wordLen;
        char[] charArray = s.toCharArray();
        int slength = charArray.length;
        for (int i = 0; i < wordLen; i++)
            for (int j = i; j + window <= slength; j += wordLen) {
                Map<String,Integer> map = new HashMap<>();
                for (int k = size - 1; k >= 0; k--){
                    String word = new String(charArray, j + k * wordLen, wordLen);
                    int count = map.getOrDefault(word, 0)+1;
                    if (count > wordsMap.getOrDefault(word, 0)) {
                        j += k * wordLen;
                        break;
                    } else if (k == 0) {
                        res.add(j);
                    } else {
                        map.put(word, count);
                    }
                }
            }
        return res;
    }
}
