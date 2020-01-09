/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  14:43
 */
public class Finally {
        char[] chars = new char[]{'I','V','X','L','C','D','M'};

        public String intToRoman(int num) {
            StringBuffer sb = new StringBuffer();

            int calcNum = 1000;
            for(int i=6;i>=0;i-=2){
                convert(i,num/calcNum,sb);
                num%=calcNum;
                calcNum/=10;
            }
            return sb.toString();
        }

        /**
         * 转换数字成罗马字符
         * @param baseIndex
         * @param calcNum
         * @param sb
         */
        public void convert(int baseIndex,int calcNum,StringBuffer sb){
            if(calcNum == 9){
                sb.append(chars[baseIndex]).append(chars[baseIndex+2]);
            }else if(calcNum >= 5){
                sb.append(chars[baseIndex+1]);
                while (calcNum-- > 5){
                    sb.append(chars[baseIndex]);
                }
            }else if(calcNum == 4){
                sb.append(chars[baseIndex]).append(chars[baseIndex+1]);
            }else{
                while (calcNum-- > 0){
                    sb.append(chars[baseIndex]);
                }
            }
        }
}
