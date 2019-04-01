package kuaishou;

import java.util.Scanner;

/**
 * 2019快手春招编程题第二题
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/30 19:53
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int count = 0;
		for (int i=1;i<=m;i++) {
			for (int j=1;j<=n;j++) {
				if (sum(i) + sum(j)>k) {
					continue;
				}
				count++;
			}
		}
		System.out.println(count);
	}
	private static int sum(int n) {
		int sum = 0;
		while (n/10 >0) {
			sum += n%10;
			n /= 10;
		}
		sum +=n;
		return sum;
	}

}
