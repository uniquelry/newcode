package bytedance.backenddevelopment2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 第二题
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
 * 为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
 * 手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。
 * 请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 * 输入描述：
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
 * 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 * 输出描述：
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 * 示例：
 * 输入：
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 * 输出：
 * 2
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 21:08
 */
public class Main02 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		// n个串珠
		int n = scanner.nextInt();
		// 手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次
		int m = scanner.nextInt();
		// 串珠的颜色一共有c种
		int c = scanner.nextInt();

		// key为串珠颜色，value为含有该颜色的串珠序号
		Map<Integer, List<Integer>> map = new HashMap<>(c);
		IntStream.rangeClosed(1,n).forEachOrdered(line -> {
			int bound = scanner.nextInt();
			IntStream.rangeClosed(1, bound).map(column -> scanner.nextInt()).forEachOrdered(color -> {
				if (!map.containsKey(color)) {
					map.put(color, new ArrayList<>());
				}
				map.get(color).add(line);
			});
		});

		AtomicInteger count = new AtomicInteger();
		IntStream.rangeClosed(1,c).forEachOrdered(i -> {
			AtomicBoolean flag = new AtomicBoolean(false);
			List<Integer> list = map.get(i);
			if (list.size() > 1) {
				for(int j=0;j<list.size()-1;j++) {
					if(list.get(j+1) - list.get(j) < m) {
						count.getAndIncrement();
						flag.set(true);
						break;
					}
				}
				if(!flag.get()) {
					if((n-list.get(list.size()-1)+list.get(0)) < m){
						count.getAndIncrement();
					}
				}
			}
		});
		System.out.println(count.get());
	}
}
