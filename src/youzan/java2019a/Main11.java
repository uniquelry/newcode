package youzan.java2019a;

import java.util.Scanner;

/**
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 23:41
 */
public class Main11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] m = str.split(";");
		if(m[0].length() != m[1].length()) {
			System.out.println("false");
			return;
		}
		m[0] = m[0]+m[0];
		System.out.println(m[0].contains(m[1]));
	}
}
