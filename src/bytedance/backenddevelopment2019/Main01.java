package bytedance.backenddevelopment2019;

/**
 *
 *
 */

import java.util.Scanner;

/**
 * 字节跳动2019春招后端开发3月16日笔试题
 * 第一题：
 * 某国货币系统包含面值1元，4元，16元，64元共计4种硬币，以及面值1024元的纸币。
 * 现在某人使用1024元的纸币购买了一件价格为N(0≤N≤1024)的商品。
 * 请问最少他会收到多少枚硬币?
 * 输入：商品价格N
 * 输出：至少收到的硬币数
 * 求解思路：贪心算法
 *
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 17:24
 */
public class Main01 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 商品的价格n
		int n = sc.nextInt();
		int money = 1024-n;
		int count = 0;

		count += money/64;
		money = money%64;

		count += money/16;
		money = money%16;

		count += money/4;
		money = money%4;

		count += money;

		System.out.println(count);
	}
}
