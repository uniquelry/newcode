package kuaishou;

import java.util.Scanner;

/**
 * 2019快手春招编程题第一题
 * 判断一颗满二叉树是否是一颗查找树，左子树的节点小于根节点，右子数的节点大于根节点。
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/30 19:53
 */
public class Main1 {
	private static boolean flag = true;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tree = scanner.next().split(",");
		int length = tree.length;
		if (2 < length) {
			int parentNode = Integer.valueOf(tree[0]);
			int leftNode = isFullBinaryTree(2, tree, true);
			int rightNode = isFullBinaryTree(3, tree, false);
			if (leftNode >= parentNode || rightNode <= parentNode) {
				flag = false;
			}
		}
		if (flag) System.out.println("True");
		else System.out.println("False");
	}

	/**
	 * 判断是否为满二叉树
	 */
	private static int isFullBinaryTree(int n,String[] tree,boolean isLeft) {
		int length = tree.length;
		if (n * 2 < length) {
			int parentNode = Integer.valueOf(tree[n - 1]);
			int leftNode = isFullBinaryTree(n * 2, tree, true);
			int rightNode = isFullBinaryTree(n * 2 + 1, tree, false);
			if (leftNode >= parentNode || rightNode <= parentNode) {
				flag = false;
			}
			if (isLeft) return rightNode;
			else return leftNode;
		}else return Integer.valueOf(tree[n - 1]);
	}
}
