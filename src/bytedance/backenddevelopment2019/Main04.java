package bytedance.backenddevelopment2019;

import java.util.Scanner;

/**
 * 字节跳动2019春招后端开发3月16日笔试题
 * 第四题:
 * 有N根绳子，第i根长为Li，现需要m根等长绳子。
 * 你可以对n根绳子进行任意剪裁(不能拼接)，计算出这m根绳子最长的长度是多少?
 * 输入：现有N根绳子 需要m根等长的绳子 每根绳子的长度
 * 输出：m根等长绳子的最长长度
 * 例如：
 * 输入：
 * 3 4
 * 3 5 4
 * 输出：
 * 2.50
 * 求解思路：二分法
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 18:15
 */
public class Main04 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 原来有n根绳子
		int n = sc.nextInt();
		// 裁剪成m根绳子
		int m = sc.nextInt();
		// 原来每根绳子的长度
		int[] len = new int[n];
		// 总绳子长度
		int sum = 0;

		for (int i=0;i<n;i++) {
			len[i] = sc.nextInt();
			sum += len[i];
		}

		double l = 0;
		double r = sum;
		double ans = 0;
		double eps = 1e-4;
		while (r - l > eps) {
			double mid = (l + r) / 2;
			if (mid == 0) {
				break;
			}
			if (check(m,len,mid)) {
				l = mid;
				ans = mid;
			} else {
				r = mid;
			}
		}
		System.out.println(String.format("%.2f", ans));
	}

	/**
	 *  判断是否能截成M段
	 */
	private static boolean check(int m,int[] len, double mid) {
		int sum = 0;
		for (int i= 0;i<len.length;i++) {
			// Math.floor 向下取整
			sum += Math.floor(len[i]/mid);
		}
		return sum >= m;
	}
}
