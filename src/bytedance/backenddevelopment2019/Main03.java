package bytedance.backenddevelopment2019;

import java.util.Scanner;

/**
 * 字节跳动2019春招后端开发3月16日笔试题
 * 第三题：
 * n个人参加比赛，结束后每个人一个分数。
 * 领奖时所有人依次排成一圈，第一个和第n个相邻。
 * 要求:
 * 1.如果某个人的分数比旁边的人高，那么奖品数量也要比他多。
 * 2.每个至少得一个奖品。
 * 问最少应该准备多少个奖品?
 * 输入：
 * 第一行是一个整数n,代表测试样例个数
 * 每个测试样例第一行是一个正整数n,表示参赛的人数，第二行是n个正整数，表示每个人的分数
 * 输出：
 * 对每组测试样例，输出应该准备的最少奖品数
 * 例如：
 * 输入：
 * 2
 * 2
 * 1 2
 * 4
 * 1 2 3 3
 * 输出：
 * 3
 * 8
 * 求解思路：化环为直，动态调整循环次数
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 18:13
 */
public class Main03 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			int num = sc.nextInt();
			int[] grade = new int[num+1];
			int[] gift = new int[num+1];
			for (int j=0;j<num;j++) {
				grade[j] = sc.nextInt();
				gift[j] = 1;
			}
			grade[num] = grade[0];
			gift[num] = 1;

			slove(num, grade, gift);
		}
	}

	private static void slove(int n, int[] grade, int[] gift) {
		while (true) {
			boolean flag = false;

			for(int i=1; i<=n; i++) {
				// 与左边的人比
				if(grade[i]>grade[i-1] && gift[i]<=gift[i-1]){
					gift[i] = gift[i-1]+1;
					flag = true;
				}
			}
			gift[0] = gift[n];

			for(int i=0; i<n; i++){
				// 与右边的人比
				if(grade[i]>grade[i+1] && gift[i]<=gift[i+1]){
					gift[i] = gift[i+1]+1;
					flag =true;
				}
			}
			gift[n] = gift[0];

			if (!flag) {
				break;
			}
		}

		int ans = 0;
		for (int i=0;i<n;i++) {
			ans += gift[i];
		}
		System.out.println(ans);
	}
}
