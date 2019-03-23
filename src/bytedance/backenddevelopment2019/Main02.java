package bytedance.backenddevelopment2019;

import java.util.Scanner;

/**
 * 字节跳动2019春招后端开发3月16日笔试题
 * 第二题:
 * 规则：
 * 1.三个同样的字母连在一起，一定是拼写错误，去掉一个就好了。比如:helllo --> hello
 * 2.两对一样的字母(AABB型)连在一起，一定是拼写错误，去掉第二对的第一个字母。比如:helloo --> hello
 * 3.上面的规则优先从左到右匹配，即如果是AABBCC型，应优先考虑修复AABB为AABCC。
 * 输入：一串字符串
 * 输出：修正后的字符串
 * 例如：
 * 输入：woooooow
 * 输出：woow
 * 求解思路：遍历一次字符串即可
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 17:39
 */
public class Main02 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		for (int i=0;i<str.length()-1;i++) {
			int length = str.length();
			if (str.charAt(i) == str.charAt(i+1)) {
				if (i<length-2 && (str.charAt(i)==str.charAt(i+2))) {
					str = str.substring(0, i+2) + str.substring(i+3);
					i--;
				} else if (i<length-3 && (str.charAt(i+2)==str.charAt(i+3))) {
					str = str.substring(0, i+2) + str.substring(i+3);
					i--;
				}
			}
		}
		System.out.println(str);
	}
}
