package bytedance.backenddevelopment2018;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一题
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。
 * 假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。
 * 因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 * 输入描述：
 * 第1行为n代表用户的个数
 * 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度
 * 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 * 输出描述：
 * 一共q行，每行一个整数代表喜好值为k的用户的个数
 * 示例：
 * 输入：
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * 输出：
 * 1
 * 0
 * 2
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/23 21:07
 */
public class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		// 通过map存储喜好程度不同的用户标号，key为喜好程度k值，value为对应的用户下标集合
		Map<Integer,List<Integer>> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			int key = nums[i];
			int value = i+1;
			if(!map.containsKey(key)) {
				List<Integer> list=new LinkedList<>();
				list.add(value);
				map.put(key,list);
			}else {
				List<Integer> list=map.get(key);
				list.add(value);
			}
		}

		int q = sc.nextInt();
		for (int i=0;i<q;i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			int count = 0;
			List<Integer> intList = map.get(k);
			if(intList!=null) {
				for(Integer integer : intList) {
					if(integer>=l&&integer<=r) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
