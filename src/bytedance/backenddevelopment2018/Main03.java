package bytedance.backenddevelopment2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 字符串S由小写字母构成，长度为n。
 * 定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
 * 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 * 输入描述：
 * 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 * 输出描述：
 * 一个非负整数，表示操作之后，连续最长的相同字母数量。
 * 示例：
 * 输入：abcbaa 2
 * 输出：2
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 21:08
 */
public class Main03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );
		// key为字符char，value为字符串中该字符出现的序号
		HashMap<Character, List<Integer>> map = new HashMap<>(26);
		String s = scan.next();
		int m = scan.nextInt();

		char c;
		for (int i=0;i<s.length();i++) {
			c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put( c,new ArrayList<>());
			}
			map.get(c).add(i);
		}

		int result = 1;
		for (Map.Entry<Character,List<Integer>> entry : map .entrySet()) {
			List<Integer> arrayList = entry.getValue();
			int arrayListSize = arrayList.size();
			int[][] dp = new int[arrayListSize][arrayListSize];
			int inResult = 1;

			for (int len=2;len<=arrayListSize;len++) {
				for (int i=0;i+len-1<arrayListSize;i++) {
					int right = i + len - 1;
					if (right-i<=2) {
						dp[i][right] = 0+arrayList.get(right)-arrayList.get(i)-len+1;
					}else {
						dp[i][right] = dp[i+1][right-1]+arrayList.get(right)-arrayList.get(i)-len+1;
					}
					if (dp[i][right]<=m) {
						inResult = len;
					}
				}
			}
			result = Math.max(result, inResult);
		}
		System.out.println(result);
	}
}
