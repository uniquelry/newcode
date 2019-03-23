/**
 * @author uniquelry
 * @create 2019/3/21 15:02
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
    	int[] data = {
    			1,2,3,4,5,6
		};
		binarySearchMax(data,5);
    }

	private static int binarySearchMax(int[] data, int target) {
		int left = 0;
		int right = data.length-1;

		while (left<=right) {
			int mid = (left + right) / 2;
			if (data[mid] <= target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		if (data[right] == target) {
			return right;
		}
		return -1;
	}
}
