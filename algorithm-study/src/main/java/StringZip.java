/**
 * Created by cdyujing7 on 2018/8/6.
 */
public class StringZip {

    public static void main(String[] args) {
        System.out.println(stringZip("abccddee"));
    }

    //字符串压缩
    public static String stringZip(String source) {
        if (source == null || source.isEmpty() || source.length() == 1) {
            return source;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(source.charAt(0));
        int size = 1;
        for (int i=1;i<source.length();i++) {
            if (i == source.length()-1) {//末尾字符
                if (source.charAt(i - 1) == source.charAt(i)) {
                    builder.append(++size);
                    break;
                }
                if (size > 1){//新字符
                    builder.append(size);
                }
                builder.append(source.charAt(i));
                break;
            }
            if (source.charAt(i - 1) == source.charAt(i)) {//重复字符
                size++;
                continue;
            }
            if (size > 1) {//新字符
                builder.append(size);
                size = 1;
            }
            builder.append(source.charAt(i));
        }
        return builder.toString();
    }
}

